package com.example.lab2.controller.group;

import com.example.lab2.entity.Group;
import com.example.lab2.repository.GroupRepository;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/groups/add-group")
public class AddGroupController {

    private final GroupRepository groupRepository;

    @Autowired
    public AddGroupController(GroupRepository groupRepository) {

        this.groupRepository = groupRepository;
    }

    @GetMapping
    public String showPage() {

        return "group/add_group";
    }

    @PostMapping
    public String addGroup(@Valid Group group, Errors errors, Model model) {

        if (errors.hasErrors()) {
            FieldError error = errors.getFieldErrors().get(0);
            model.addAttribute("error", error.getField() + ": " + error.getDefaultMessage());
        } else if (groupRepository.insertEntity(group)) {
            model.addAttribute("success", "Group was successfully added!");
        } else {
            model.addAttribute("error",
                    String.format("Either group with id = %s already exists or teacher id not found", group.getId()));
        }

        return "group/add_group";
    }
}
