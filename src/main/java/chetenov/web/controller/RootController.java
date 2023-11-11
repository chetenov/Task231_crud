package chetenov.web.controller;

import chetenov.web.service.UserService;
import chetenov.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RootController {

    private Util util;
    private UserService userService;

    @Autowired
    public RootController(Util util, UserService userService) {
        this.util = util;
        this.userService = userService;
    }

    @GetMapping("")
    public String rootBoot(){
        if (userService.getAllUsers().isEmpty()){
            util.addUsersToDB();
        }
        return "redirect:/login";
    }

}
