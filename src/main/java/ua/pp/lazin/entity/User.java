package ua.pp.lazin.entity;


import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;
import java.util.*;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    private String password;

    private String email;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> skills = new ArrayList<>();

    private Calendar birthday;

    private String address;

    private String phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Thought> thoughts = new ArrayList<>();

    private String pathToImage;

    @ManyToMany
    private Set<User> friends = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Thought> getThoughts() {
        return thoughts;
    }

    public void setThoughts(List<Thought> thoughts) {
        this.thoughts = thoughts;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User name= '" + name + "" ;
    }
}
