package com.example.lab2.controller.complex_query;

import com.example.lab2.repository.ComplexQueryRepository;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/complex-query-3")
public class ComplexQuery3Controller {

    private final ComplexQueryRepository cqRepository;

    @Autowired
    public ComplexQuery3Controller(ComplexQueryRepository cqRepository) {

        this.cqRepository = cqRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) Long teacherId, Model model) {

        if (teacherId != null) {
            model.addAttribute("teachers", cqRepository.query3(teacherId));
        }

        return "/complex_queries/complex_query_3";
    }
}
