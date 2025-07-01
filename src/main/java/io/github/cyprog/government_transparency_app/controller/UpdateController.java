package io.github.cyprog.government_transparency_app.controller;

import io.github.cyprog.government_transparency_app.entity.Update;
import io.github.cyprog.government_transparency_app.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UpdateController {

    private final UpdateService updateService;

    @GetMapping("/updates")
    public String listUpdates(Model model) {
        model.addAttribute("updates", updateService.getAllUpdates());
        return "updates";
    }

    @GetMapping("/updates/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        Update update = updateService.getUpdateById(id);
        model.addAttribute("update", update);
        return "update-details";  // New HTML page you will create next
    }
}

