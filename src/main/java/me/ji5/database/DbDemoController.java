package me.ji5.database;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class DbDemoController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("userdao", new UserDao());
        return "new";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String newUser(@ModelAttribute UserDao userDao, Model model) {
        userDao.insertNewContent();
        model.addAttribute("userdao", userDao);
        return "response";
    }
}