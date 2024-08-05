package it.dkashtan.ticket_platform.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.dkashtan.ticket_platform.model.UserModel;
import it.dkashtan.ticket_platform.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public String userDetails(@PathVariable Integer id, Model model) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user/detail";
        } else {
            return "redirect:/tickets";
        }
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Integer id, Model model) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user/update";
        } else {
            return "redirect:/user/" + id;
        }
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute UserModel user) {
        user.setId(id);
        userRepository.save(user);
        return "redirect:/user/" + id;
    }
}
