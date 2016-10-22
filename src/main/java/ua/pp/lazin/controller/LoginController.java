package ua.pp.lazin.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.dao.UserDao;
import ua.pp.lazin.entity.User;

import javax.inject.Inject;

@Controller
@RequestMapping
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginController {

    private User user;
    private UserDao userDao;

    @Inject
    public LoginController(User user, UserDao userDao) {
        this.user = user;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String login, @RequestParam String password) {
        System.out.println("in login");                 // todo remove
        user = userDao.findUserByLogin(login);
        ModelAndView profile = new ModelAndView("redirect:/profile");
//        profile.addObject("user", user);
        return profile;
    }
}
