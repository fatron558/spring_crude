package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user, @RequestParam(name = "id") int id) {
        userService.editUser(user, id);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
