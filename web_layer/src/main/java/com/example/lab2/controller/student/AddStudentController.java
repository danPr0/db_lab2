package com.example.lab2.controller.student;

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

@Controller
@RequestMapping("/students/add-student")
public class AddStudentController {

    private final StudentsRepository studentsRepository;

    @Autowired
    public AddStudentController(StudentsRepository studentsRepository) {

        this.studentsRepository = studentsRepository;
    }

    @GetMapping
    public String showPage() {

        return "student/add_student";
    }

    @PostMapping
    public String addStudent(@Valid Student student, Errors errors, Model model) {

        if (errors.hasErrors()) {
            FieldError error = errors.getFieldErrors().get(0);
            model.addAttribute("error", error.getField() + ": " + error.getDefaultMessage());
        } else if (studentsRepository.insertEntity(student)) {
            model.addAttribute("success", "Student was successfully added!");
        } else {
            model.addAttribute("error",
                    String.format("Either student with id = %s is already exists or group id, instructor id not found",
                            student.getId()));
        }

        return "student/add_student";
    }
}
