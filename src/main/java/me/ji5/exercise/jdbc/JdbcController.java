package me.ji5.exercise.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("userdao", new UserDao());
        return "new";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String newUser(@ModelAttribute UserDao userDao, Model model) {
        userDao.insertNewContent(jdbcTemplate);
        model.addAttribute("userdao", userDao);
        return "response";
    }
}