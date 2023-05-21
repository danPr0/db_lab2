package com.example.lab2.controller.student;

import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/students/get-student")
public class GetStudentController {

    private final StudentsRepository studentsRepository;

    @Autowired
    public GetStudentController(StudentsRepository studentsRepository) {

        this.studentsRepository = studentsRepository;
    }

    @GetMapping
    public String showPage() {

        return "student/get_student";
    }

    @PostMapping
    public String getStudent(@RequestParam Long id, Model model) {

        Optional<Student> student = studentsRepository.getEntity(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        } else {
            model.addAttribute("error", "No student found with id = " + id);
        }

        return "student/get_student";
    }
}
