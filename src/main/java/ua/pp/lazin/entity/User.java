package ua.pp.lazin.entity;


import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {

    private String login;

    private String password;

    private String email = "churchiil@gov.uk";

    private String name = "Winston Spencer Churchill";

    private List<String> skills = new ArrayList<>();

    private Calendar birthday = new GregorianCalendar(1874, 10, 30);

    private String address = "10, Downing street, London";

    private String phone = "+10(852)545-55-88";

    private List<Thought> thoughts = new ArrayList<>();

    {
        thoughts.add(new Thought("Success is not final, failure is not fatal: " +
                "it is the courage to continue that counts."));
        thoughts.add(new Thought("A pessimist sees the difficulty in every opportunity;" +
                " an optimist sees the opportunity in every difficulty."));
        thoughts.add(new Thought("If you're going through hell, keep going."));

        skills.add("drink");
        skills.add("smoke");
        skills.add("speak");
        skills.add("win wars");
        skills.add("lead");
    }

    private String pathToImage = "/images/churchill.jpg";

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
        return "User{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", Name='" + name + '\'' +
                '}';
    }
}
