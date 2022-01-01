package chetenov.web.controller;

import chetenov.web.model.DefaultRoles;
import chetenov.web.model.TestForms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class RootController {
    @Autowired
    private TestForms testForms;

    private final DefaultRoles[] defaultRoles = DefaultRoles.values();


    @GetMapping("")
    public String home(Model model){
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("White");
        colors.add("Black");

        List<String> roles = new ArrayList<>();
        roles.add("User");
        roles.add("Admin");
        roles.add("Moderator");
        testForms.setName("Happy new Year!");
        testForms.setLegenda("This is legenda from TestForms");
        testForms.setOptionsSet(colors);
        testForms.setOptionsList(roles);

        model.addAttribute("options", testForms);
        model.addAttribute("default_roles", defaultRoles);
        return "test";
    }

    @PostMapping("testAction")
    public String someAction (@RequestParam(required = false) String s,
                              @RequestBody(required = false) String ss,
                              @ModelAttribute("tst") TestForms testForms) {
//        Arrays.stream(roles).forEach(System.out::println);
        System.out.println("s - " + s);
        System.out.println("ss - " + ss);

        System.out.println(testForms);
        return "redirect:/";
    }


}
