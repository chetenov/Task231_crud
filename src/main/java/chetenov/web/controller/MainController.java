package chetenov.web.controller;

import chetenov.web.model.Role;
import chetenov.web.model.User;
import chetenov.web.model.UserForm;
import chetenov.web.service.RoleService;
import chetenov.web.util.Errors;
import chetenov.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import chetenov.web.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class MainController {



    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private Util util;

    private Set<String> defRoles = new HashSet<>();

    @Autowired
    public MainController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        System.out.println("Main controller created....");
    }

    @GetMapping("")
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        if (allUsers == null || allUsers.isEmpty()) {
            util.fillDataBase();
            allUsers = userService.getAllUsers();
        }
        model.addAttribute("allUsers", allUsers);

        if (defRoles.isEmpty()) {
            for (Role r : roleService.getAllRoles()) {
                defRoles.add(r.getRole());
            }
        }

        return "all-users";
    }


    @RequestMapping("updateInfo")
    public String updateUser(@RequestParam(value = "userId", required = false) Long id, Model model) {

        User user;
        //если нет id, значит это создание нового пользователя
        if (id == null || id == 0) {
            user = new User();
        } else {
            user = userService.getUser(id);
        }

        //получаем Set текущих активных ролей пользователя для проставления флажков в форме
        Set<String> activeRoles = user.getRoles().stream().map(Role::getRole).collect(Collectors.toSet());

        //добавляем в форму активные роли
        UserForm userForm = new UserForm();
        userForm.setActiveRoles(activeRoles);

        //Заполняем мапу всеми ролями, проставляя флажки true, если роль активна
        Map<String, Boolean> rolesMap = new HashMap<>();
        for (String role : defRoles) {
            rolesMap.put(role, activeRoles.contains(role));
        }

        //Добавляем мапу в форму
        userForm.setCheckBoxes(rolesMap);

        //добавляем пользователя в форму
        userForm.setUser(user);

        model.addAttribute("def_roles", defRoles);
        model.addAttribute("user_form", userForm);
        model.addAttribute("pathName", "/admin/saveUser");

        return "user-info1";
    }

    @PostMapping(value = "saveUser")
    public String saveUser(
            @ModelAttribute("user_form") UserForm userForm,
            @RequestParam(value = "checkRoles", required = false) String[] checkRoles,
            Model model) {

        //Извлекаем пользователя из формы
        User user = userForm.getUser();

        //Переводим наши флажки в новый Set ролей и обновляем их пользователю
        Set<Role> newSetRole = new HashSet<>();
        if (checkRoles != null) {
            for (String r : checkRoles) {
                newSetRole.add(roleService.getRoleByName(r));
            }
            user.setRoles(newSetRole);
        }
        if (!userForm.getNewPassword().isEmpty()){
            System.out.println("Будет зашифрован новый пароль");
            user.setPassword(passwordEncoder.encode(userForm.getNewPassword()));
        } else {
            System.out.println("Будет сохранен старый пароль");
            user.setPassword(userService.getUser(user.getId()).getPassword());
        }

        try {
            userService.saveUser(user);
        }catch (Exception e){
            System.out.println("Ошибка сохранения пользователя. Проверьте данные.");
            return "redirect:/admin/error/saveError";
        }

        return "redirect:/admin";
    }

    @GetMapping("error/{id}")
    public String errorPage(@PathVariable() String id, Model model){

        String err = Errors.valueOf(id).getMessage();
        model.addAttribute("err", err);
        return "error-page";
    }


    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}

