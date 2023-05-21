package com.example.lab2.controller.student;

import com.example.lab2.entity.Group;
import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/students/update-student")
public class UpdateStudentController {

    private final StudentsRepository studentsRepository;

    @Autowired
    public UpdateStudentController(StudentsRepository studentsRepository) {

        this.studentsRepository = studentsRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) Long id, Model model) {

        if (id != null) {

            Optional<Student> student = studentsRepository.getEntity(id);
            if (student.isPresent()) {
                model.addAttribute("id", id);
                model.addAttribute("email", student.get().getEmail());
                model.addAttribute("phoneNumber", student.get().getPhoneNumber());
                model.addAttribute("firstName", student.get().getFirstName());
                model.addAttribute("secondName", student.get().getSecondName());
                model.addAttribute("practiceCount", student.get().getPracticeCount());
                model.addAttribute("groupId", student.get().getGroupId());
                model.addAttribute("instructorId", student.get().getInstructorId());
            } else {
                model.addAttribute("error", "No student found with id = " + id);
            }
        }

        return "student/update_student";

//        ModelAndView mav = new ModelAndView("redirect:/students/update-student");
//        mav.addObject("id", id);
//
//        Optional<Student> student = studentsRepository.getEntity(id);
//        if (student.isPresent()) {
//            mav.addObject("email", student.get().getEmail());
//            mav.addObject("phoneNumber", student.get().getPhoneNumber());
//            mav.addObject("firstName", student.get().getFirstName());
//            mav.addObject("secondName", student.get().getSecondName());
//            mav.addObject("practiceCount", student.get().getPracticeCount());
//            mav.addObject("groupId", student.get().getGroupId());
//            mav.addObject("instructorId", student.get().getInstructorId());
//        } else {
//            mav.addObject("error", "No student found with id = " + id);
//        }
//
//        return mav;
    }

    @PostMapping
    public String updateStudent(@Valid Student student, Errors errors, Model model) {

        if (errors.hasErrors()) {
            FieldError error = errors.getFieldErrors().get(0);
            model.addAttribute("error", error.getField() + ": " + error.getDefaultMessage());
        } else {
            try {
                studentsRepository.updateEntity(student);
                model.addAttribute("success", "Student was successfully updated!");
            } catch (Exception e) {
                model.addAttribute("error", "Group id or instructor id doesn't exist");
            }
        }
        model.addAttribute("id", student.getId());

        return "student/update_student";
    }
}
