package com.example.web.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String birthDate;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

    public Member() {}

    public Member(String login, String password, List<Role> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

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
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() { return this.birthDate; }
    public void setBirthDate(String  birthDate) { this.birthDate = birthDate; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }
}
