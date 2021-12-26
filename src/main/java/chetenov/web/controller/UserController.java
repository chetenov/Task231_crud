package chetenov.web.controller;

import chetenov.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import chetenov.web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String showAllUsers(Model model){
        List<User>allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);
        model.addAttribute("allUsers", allUsers);
        return "all-users-t";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user-info";
    }


    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") Long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("userId") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}

