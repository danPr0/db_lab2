package com.example.lab2.controller.group;

import com.example.lab2.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/groups/delete-group")
public class DeleteGroupController {

    private final GroupRepository groupRepository;

    @Autowired
    public DeleteGroupController(GroupRepository groupRepository) {

        this.groupRepository = groupRepository;
    }

    @GetMapping
    public String showPage() {

        return "group/delete_group";
    }

    @PostMapping
    public String deleteGroup(@RequestParam Long id, Model model) {

        if (groupRepository.deleteEntity(id) > 0) {
            model.addAttribute("success", "Group was successfully deleted!");
        } else {
            model.addAttribute("error", "No group found with id = " + id);
        }

        return "group/delete_group";
    }
}
