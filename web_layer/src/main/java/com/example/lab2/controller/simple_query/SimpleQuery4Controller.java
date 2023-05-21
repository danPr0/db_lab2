package com.example.lab2.controller.simple_query;

import com.example.lab2.repository.SimpleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple-query-4")
public class SimpleQuery4Controller {

    private final SimpleQueryRepository sqRepository;

    @Autowired
    public SimpleQuery4Controller(SimpleQueryRepository sqRepository) {

        this.sqRepository = sqRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) Integer studentsQuantity, Model model) {

        if (studentsQuantity != null) {
            model.addAttribute("teachers", sqRepository.query4(studentsQuantity));
        }

        return "/simple_queries/simple_query_4";
    }
}
