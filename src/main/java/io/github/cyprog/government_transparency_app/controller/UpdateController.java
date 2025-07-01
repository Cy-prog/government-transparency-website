package io.github.cyprog.government_transparency_app.controller;

import io.github.cyprog.government_transparency_app.entity.Update;
import io.github.cyprog.government_transparency_app.repository.UpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UpdateController {

    private final UpdateRepository updateRepository;

    @GetMapping("/updates")
    public String listUpdates(Model model) {
        List<Update> updates = updateRepository.findAll();
        model.addAttribute("updates", updates);
        return "updates";  // Will create updates.html next
    }
}
