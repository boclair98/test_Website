package com.example.CarSite.Controller.User;

import com.example.CarSite.Entity.User;
import com.example.CarSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/collections")
public class UserContoller {
    @Autowired
    private final UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("user",all);
        return "user/collections";
    }

    @GetMapping("/{userId}/informations")
    public String people(@PathVariable("userId") Long userId, Model model){
        List<User> users = userService.findByAllId(userId);
        model.addAttribute("users",users);
        return "user/users";
    }
}
