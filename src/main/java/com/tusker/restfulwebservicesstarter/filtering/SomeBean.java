package com.tusker.restfulwebservicesstarter.filtering;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( value =  {"id"} )
public class SomeBean {
    private int id;
    private String name;
    private String title;
    @JsonIgnore
    private String details;

    public SomeBean() {
    }

    public SomeBean( int id, String name, String title, String details ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.details = details;
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

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails( String details ) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
