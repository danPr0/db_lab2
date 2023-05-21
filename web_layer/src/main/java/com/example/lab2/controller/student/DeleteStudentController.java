package com.example.lab2.controller.student;

import com.example.lab2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students/delete-student")
public class DeleteStudentController {

    private final StudentsRepository studentsRepository;

    @Autowired
    public DeleteStudentController(StudentsRepository studentsRepository) {

        this.studentsRepository = studentsRepository;
    }

    @GetMapping
    public String showPage() {

        return "student/delete_student";
    }

    @PostMapping
    public String deleteStudent(@RequestParam Long id, Model model) {

        if (studentsRepository.deleteEntity(id) > 0) {
            model.addAttribute("success", "Student was successfully deleted!");
        } else {
            model.addAttribute("error", "No student found with id = " + id);
        }

        return "student/delete_student";
    }
}
