package com.example.test.micro.stubs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All Details about the user")
public class User {

    private Integer id;

    @Size(min=2, message = "Name should be atleast 2 characters long")
    @ApiModelProperty(notes= "size of the name should be atleast 2")
    private String name;
    @Past
    private Date birthDate;

    public User(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.birthDate = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
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
}
