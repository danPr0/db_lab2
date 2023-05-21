package com.example.lab2.controller.simple_query;

import com.example.lab2.repository.SimpleQueryRepository;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple-query-3")
public class SimpleQuery3Controller {

    private final SimpleQueryRepository sqRepository;

    @Autowired
    public SimpleQuery3Controller(SimpleQueryRepository sqRepository) {

        this.sqRepository = sqRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) String categoryId, Model model) {

        if (categoryId != null) {
            model.addAttribute("teachers", sqRepository.query3(categoryId));
        }

        return "/simple_queries/simple_query_3";
    }
}
