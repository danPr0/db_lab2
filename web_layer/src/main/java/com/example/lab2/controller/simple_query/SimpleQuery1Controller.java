package com.example.lab2.controller.simple_query;

import com.example.lab2.repository.SimpleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple-query-1")
public class SimpleQuery1Controller {

    private final SimpleQueryRepository sqRepository;

    @Autowired
    public SimpleQuery1Controller(SimpleQueryRepository sqRepository) {

        this.sqRepository = sqRepository;
    }

    @GetMapping()
    public String get(@RequestParam(required = false) Long instructorId, Model model) {

        if (instructorId != null) {
            model.addAttribute("groups", sqRepository.query1(instructorId));
        }

        return "/simple_queries/simple_query_1";
    }
}
