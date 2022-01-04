package chetenov.web.controller;

import chetenov.web.model.Role;
import chetenov.web.model.Test;
import chetenov.web.model.User;
import chetenov.web.model.Wanna_Roles;
import chetenov.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import chetenov.web.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class MainController {

    private final UserService userService;
    private boolean isFilledDb;

    @Autowired
    private Util util;

    private List<Role> defRoles;

    private Map<Long,Role> mapRoles;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        if (allUsers == null || allUsers.isEmpty()){
            util.fillDataBase();
            System.out.println("Заполнили пустую базу данных");
            allUsers = userService.getAllUsers();
        }
        model.addAttribute("allUsers", allUsers);
        allUsers.forEach(System.out::println);
        this.defRoles = userService.getAllRoles();
        mapRoles = new HashMap<>();
        for (Role r : defRoles){
            mapRoles.put(r.getId(),r);
        }

        System.out.println("Def roles = " + defRoles);
        return "all-users";
    }

//    @GetMapping("fill_db")
//    public String redirect(Model model){
//        util.fillDataBase();
//        return "redirect:/admin";
//    }


    @PostMapping(value = "saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println("Попытка сохранить user " + user);
        System.out.println("Выбраны роли: ");
        Set<Role> roles = new HashSet<>();
        for (Long r : user.getWantRoles()){
            System.out.println("===================");
            System.out.println("ID - " + r);
            roles.add(mapRoles.get(r));
        }
        user.setRoles(roles);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @RequestMapping("updateInfo")
    public String updateUser(@RequestParam(value = "userId", required = false) Long id, Model model) {
        User user;
        if (id == null || id == 0) {
            user = new User();
        } else {
            user = userService.getUser(id);
        }
        model.addAttribute("user", user);
        model.addAttribute("def_roles", defRoles);
        return "user-info1";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


}

