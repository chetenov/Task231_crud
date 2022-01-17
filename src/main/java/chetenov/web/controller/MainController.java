package chetenov.web.controller;

import chetenov.web.model.User;
import chetenov.web.service.RoleService;
import chetenov.web.service.UserService;
import chetenov.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin/users")
public class MainController {

    private final UserService userService;
    private final RoleService roleService;
    private final Util util;

    @Autowired
    public MainController(UserService userService, RoleService roleService, Util util) {
        this.userService = userService;
        this.roleService = roleService;
        this.util = util;
        System.out.println("Main controller created....");
    }

    //--------------------------------FORMS------------------------------------

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {

        return "user-info2";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("user", userService.getUser(id));
        return "user-info2";
    }

    // -------------------------------CREATE-----------------------------------

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "selectedRoles", required = false) Set<Long> selectedRoles,
                             Model model) {

        if (!selectedRoles.isEmpty()) {
            for (Long l : selectedRoles) {
                user.addRoleToUser(roleService.getRole(l));
            }
        }
        try {
            userService.saveUser(user);
        }catch (Exception e){
            model.addAttribute("err", e.getMessage());
            return "error-page";
        }


        return "redirect:/admin/users";
    }

    // --------------------------------READ------------------------------------

    @GetMapping()
    public String readAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/{id}")
    public String readOneUser(@PathVariable(value = "id") Long id, Model model) {

        model.addAttribute("user", userService.getUser(id));
        return "user-page";
    }

    // -------------------------------UPDATE-----------------------------------

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable(value = "id") Long id,
                             @ModelAttribute("user") User user,
                             @RequestParam(value = "selectedRoles", required = false) Set<Long> selectedRoles,
                             Model model) {

        if (!selectedRoles.isEmpty()) {
            for (Long r : selectedRoles) {
                user.addRoleToUser(roleService.getRole(r));
            }
        }

        try {
            userService.updateUser(user, id);
        }catch (Exception e){
            model.addAttribute("err", e.getMessage());
            return "error-page";
        }

        return "redirect:/admin/users";
    }

    // -------------------------------DELETE-----------------------------------

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {

        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}

