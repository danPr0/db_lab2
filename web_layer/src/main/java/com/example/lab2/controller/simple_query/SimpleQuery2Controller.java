package com.example.lab2.controller.simple_query;

import com.example.lab2.repository.SimpleQueryRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple-query-2")
public class SimpleQuery2Controller {

    private final SimpleQueryRepository sqRepository;

    @Autowired
    public SimpleQuery2Controller(SimpleQueryRepository sqRepository) {

        this.sqRepository = sqRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) String carBrand, Model model) {

        if (carBrand != null) {
            model.addAttribute("students", sqRepository.query2(carBrand));
        }

        return "/simple_queries/simple_query_2";
    }
}
