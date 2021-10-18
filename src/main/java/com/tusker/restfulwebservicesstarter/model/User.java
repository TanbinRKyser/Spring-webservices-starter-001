package com.tusker.restfulwebservicesstarter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel( description = "API MODEL -- << No Useful description >>")
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 2, message = "Name should've at least 2 characters")
    @ApiModelProperty( notes = "Name can't be smaller than 2 char")
    private String name;

    @Past
    @ApiModelProperty( notes = "Birthday can't be in the future")
    private Date birthDate;

    public User() {
    }

    public User( int id, String name, Date birthDate ) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate( Date birthDate ) {
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
