package chetenov.web.controller;

import chetenov.web.model.User;
import chetenov.web.model.UserForm;
import chetenov.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("")
    public String userPage(@AuthenticationPrincipal User user, Model mdl){
        mdl.addAttribute(userService.getUser(user.getId()));
        return "user-page";
    }


//    @GetMapping("updateInfo")
//    public String updateUserInfo(@AuthenticationPrincipal User user, Model model){
//        user = userService.getUser(user.getId());
//        String password = user.getPassword();
//        System.out.println("userPage pass: " + password);
//
//        UserForm userForm = new UserForm();
//        userForm.setUser(user);
//
//        model.addAttribute("user_form", userForm);
//        model.addAttribute("pathName", "/user/save");
//        model.addAttribute("password", password);
//        return "user-info1";
//    }
//
//    @PostMapping("save")
//    public String saveUser(@AuthenticationPrincipal User principal,
//                           @ModelAttribute("user_form") UserForm userForm){
//        User user = userService.getUser(principal.getId());
//        user.setName(userForm.getUser().getName());
//        user.setUsername(userForm.getUser().getUsername());
//        user.setPhone(userForm.getUser().getPhone());
//        user.setEmail(userForm.getUser().getEmail());
//
//        System.out.println("save: " + user.getPassword());
//        userService.saveUser(user);
//        return "redirect:/user";
//    }
}
