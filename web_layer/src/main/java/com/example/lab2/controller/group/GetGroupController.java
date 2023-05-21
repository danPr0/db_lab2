package com.example.lab2.controller.group;

import com.example.lab2.entity.Group;
import com.example.lab2.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/groups/get-group")
public class GetGroupController {

    private final GroupRepository groupRepository;

    @Autowired
    public GetGroupController(GroupRepository groupRepository) {

        this.groupRepository = groupRepository;
    }

    @GetMapping
    public String showPage() {

        return "group/get_group";
    }

    @PostMapping
    public String getGroup(@RequestParam Long id, Model model) {

        Optional<Group> group = groupRepository.getEntity(id);
        if (group.isPresent()) {
            model.addAttribute("student", group.get());
        } else {
            model.addAttribute("error", "No group found with id = " + id);
        }

        return "group/get_group";
    }
}
