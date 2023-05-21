package com.example.lab2.controller.group;

import com.example.lab2.entity.Group;
import com.example.lab2.repository.GroupRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/groups/update-group")
public class UpdateGroupController {

    private final GroupRepository groupRepository;

    @Autowired
    public UpdateGroupController(GroupRepository groupRepository) {

        this.groupRepository = groupRepository;
    }

    @GetMapping
    public String get(@RequestParam(required = false) Long id, Model model) {

        if (id != null) {

            Optional<Group> group = groupRepository.getEntity(id);
            if (group.isPresent()) {
                model.addAttribute("id", id);
                model.addAttribute("lecturesCovered", group.get().getLecturesCovered());
                model.addAttribute("startDate", group.get().getStartDate());
                model.addAttribute("categoryId", group.get().getCategoryId());
                model.addAttribute("teacherId", group.get().getTeacherId());
            } else {
                model.addAttribute("error", "No group found with id = " + id);
            }
        }

        return "group/update_group";
    }

    @PostMapping
    public String updateGroup(@Valid Group group, Errors errors, Model model) {

        if (errors.hasErrors()) {
            FieldError error = errors.getFieldErrors().get(0);
            model.addAttribute("error", error.getField() + ": " + error.getDefaultMessage());
        } else {
            try {
                if (groupRepository.updateEntity(group) > 0) {
                    model.addAttribute("success", "Group was successfully updated!");
                }
            } catch (Exception e) {
                model.addAttribute("error", "Teacher id doesn't exist");
            }
        }
        model.addAttribute("id", group.getId());

        return "group/update_group";
    }
}
