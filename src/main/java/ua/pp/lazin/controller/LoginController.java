package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.dao.UserDao;
import ua.pp.lazin.dto.UserWrap;
import ua.pp.lazin.entity.Thought;
import ua.pp.lazin.entity.User;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping()
public class LoginController {

    private UserWrap userWrap;
    private UserDao userDao;

    @Autowired
    public LoginController(UserWrap userWrap, UserDao userDao) {
        this.userWrap = userWrap;
        this.userDao = userDao;
    }

    @RequestMapping("/")
    public String addUser() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username =
                    ((UserDetails) principal).getUsername();
            User user = userDao.findUserByLogin(username);
            userWrap.setUser(user);
        }
        return "redirect:profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginWelcome() {
        return "login";
    }
}