package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.models.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "index";
    }

    @GetMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/";
    }

}
