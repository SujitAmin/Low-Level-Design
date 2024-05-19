package com.example.demo.courses.service;

import com.example.demo.courses.Bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
