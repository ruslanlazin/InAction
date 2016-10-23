package ua.pp.lazin.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ua.pp.lazin.entity.User;

@Component
@SessionScope
public class UserWrap {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
