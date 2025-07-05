package io.github.cyprog.government_transparency_app.controller;

import io.github.cyprog.government_transparency_app.entity.Update;
import io.github.cyprog.government_transparency_app.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    // ✅ GET - Show form
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/updates/new")
    public String showAddForm(Model model) {
        model.addAttribute("update", new Update());
        return "add_update";
    }

    // ✅ POST - Save new update
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/updates/save")
    public String saveUpdate(@ModelAttribute Update update) {
        updateService.save(update);
        return "redirect:/updates";
    }
}

