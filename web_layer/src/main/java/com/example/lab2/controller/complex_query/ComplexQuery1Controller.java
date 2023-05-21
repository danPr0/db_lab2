package com.example.lab2.controller.complex_query;

import com.example.lab2.repository.ComplexQueryRepository;
import com.example.lab2.repository.SimpleQueryRepository;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/complex-query-1")
public class ComplexQuery1Controller {

    private final ComplexQueryRepository cqRepository;

    @Autowired
    public ComplexQuery1Controller(ComplexQueryRepository cqRepository) {

        this.cqRepository = cqRepository;
    }

    @GetMapping
    public String get(Model model) {

        model.addAttribute("teachers", cqRepository.query1());

        return "/complex_queries/complex_query_1";
    }
}
