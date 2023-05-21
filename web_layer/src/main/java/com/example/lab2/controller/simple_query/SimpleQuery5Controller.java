package com.example.lab2.controller.simple_query;

import com.example.lab2.repository.SimpleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple-query-5")
public class SimpleQuery5Controller {

    private final SimpleQueryRepository sqRepository;

    @Autowired
    public SimpleQuery5Controller(SimpleQueryRepository sqRepository) {

        this.sqRepository = sqRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) String teacherName, Model model) {

        if (teacherName != null) {
            model.addAttribute("students", sqRepository.query5(teacherName));
        }

        return "/simple_queries/simple_query_5";
    }
}
