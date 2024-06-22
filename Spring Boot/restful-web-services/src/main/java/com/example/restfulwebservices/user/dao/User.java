package com.example.restfulwebservices.user.dao;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;
/*
* Not a managed type: class com.example.restfulwebservices.user.
* User indicates that the User entity is not being recognized as a JPA entity.
 * */
//@ApiModel(description = "Contains all details of the user")
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min=2, message="Name should be atleast 2 characters")
    //@ApiModelProperty(notes = "Name should have atleast 2 characters")
    private String name;

    @Past
    //@ApiModelProperty(notes = "Birth Date should be in the past")
    private Date birthDate;

    protected  User() {

    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
