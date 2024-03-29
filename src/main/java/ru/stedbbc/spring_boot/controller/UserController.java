package ru.stedbbc.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.stedbbc.spring_boot.model.User;
import ru.stedbbc.spring_boot.service.RoleService;
import ru.stedbbc.spring_boot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "loginpage";
    }

    @GetMapping(value = "/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userpage";
    }

    @GetMapping(value = "/admin")
    public String listUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "adminpage";
    }

//    @GetMapping(value = "/admin/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "new";
//    }
//
//    @PostMapping(value = "/admin/add-user")
//    public String addUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String role : checkBoxRoles) {
//            roleSet.add(roleService.getRoleByName(role));
//        }
//        user.setRoles(roleSet);
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "/admin")
//    public String editUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String roles : checkBoxRoles) {
//            roleSet.add(roleService.getRoleByName(roles));
//        }
//        user.setRoles(roleSet);
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "/admin/delete/{id}")
//    public String removeUser(@PathVariable("id") long id) {
//        userService.removeUserById(id);
//        return "redirect:/admin";
//    }
}