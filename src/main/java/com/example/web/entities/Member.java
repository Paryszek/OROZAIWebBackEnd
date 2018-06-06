package com.example.web.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Date birthDate;

    public Member() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName;}

    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName;}

    public String getLogin() {
        return this.login;
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
}
