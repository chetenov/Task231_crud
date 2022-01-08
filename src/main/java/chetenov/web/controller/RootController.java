package chetenov.web.controller;

import chetenov.web.model.trash.TestForms;
import chetenov.web.service.trash.TestService;
import chetenov.web.service.UserService;
import chetenov.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    private Util util;


    @Autowired
    UserService userService;


    @GetMapping("")
    public String rootBoot(){
        System.out.println("rootBoot()");
        if (userService.getAllUsers().isEmpty()){
            util.fillDataBase();
        }
        return "redirect:/login";
    }

}
