package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping()
public class WallController {

    private UserWrap userWrap;

    @Autowired
    public WallController(UserWrap userWrap) {
        this.userWrap = userWrap;
    }

    @RequestMapping("/wall")
    public ModelAndView viewWall() {
        User user = userWrap.getUser();
        if (user == null) {
            ModelAndView error = new ModelAndView("error");
            error.addObject("message", "Session has expired. Please login");
            return error;
        }
        ModelAndView wall = new ModelAndView("wall");
        List<Thought> wallOfThoughts = new ArrayList<>();
        wallOfThoughts.addAll(user.getThoughts());
        for (User friend : user.getFriends()) {
            wallOfThoughts.addAll(friend.getThoughts());
        }
        Collections.sort(wallOfThoughts);
        wall.addObject("wallOfThoughts", wallOfThoughts);
        return wall;
    }
}
