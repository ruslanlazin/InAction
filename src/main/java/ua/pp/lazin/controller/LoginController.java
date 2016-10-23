package ua.pp.lazin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.pp.lazin.dao.UserDao;
import ua.pp.lazin.dto.UserWrap;


@Controller
@RequestMapping
public class LoginController {

    private UserWrap userWrap;
    private UserDao userDao;

    @Autowired
    public LoginController(UserWrap userWrap, UserDao userDao) {
        this.userWrap = userWrap;
        this.userDao = userDao;
    }

    @RequestMapping("/")
    public String welcome() {
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView login(@RequestParam String login, @RequestParam String password) {
//        System.out.println("in login");                 // todo remove
//        userDto = userDao.findUserByLogin(login);
//        System.out.println("userInLogin" + userDto);
//        ModelAndView profile = new ModelAndView("redirect:/profile");
//        profile.addObject("userDto", userDto);
//        return profile;
//    }
}
