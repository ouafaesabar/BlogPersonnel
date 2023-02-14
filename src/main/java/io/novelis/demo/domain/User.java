package io.novelis.demo.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private String userName;

    @Column
    private String userPassword;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Comment> comments;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
