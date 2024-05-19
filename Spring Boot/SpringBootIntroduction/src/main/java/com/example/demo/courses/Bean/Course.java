package com.example.demo.courses.Bean;

import jakarta.persistence.*;

/*
I got this error.
* The error message you're encountering, org.springframework.beans.factory.BeanCreationException:
* Error creating bean with name 'courseRepository'... Not a managed type: class com.example.demo.courses.Bean.Course,
 * */
@Entity
@Table(name="Course")
public class Course {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="author")
    private String author;

    @Column(name="name")
    private String name;

    public Course() {

    }
    public Course(long id, String author, String name) {
        super();
        this.id = id;
        this.author = author;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
