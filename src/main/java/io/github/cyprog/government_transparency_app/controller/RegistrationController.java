package io.github.cyprog.government_transparency_app.controller;



import io.github.cyprog.government_transparency_app.dto.UserDto;
import io.github.cyprog.government_transparency_app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {


    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        if (userService.existsByEmail(userDto.getEmail())) {
            result.rejectValue("email", null, "Email already exists!");
        }

        if (result.hasErrors()) {
            return "register";
        }

        userService.registerUser(userDto);
        return "redirect:/register?success";
    }
}
