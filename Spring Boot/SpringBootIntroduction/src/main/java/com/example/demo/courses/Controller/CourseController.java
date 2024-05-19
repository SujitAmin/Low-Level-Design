package com.example.demo.courses.Controller;

import com.example.demo.courses.Bean.Course;
import com.example.demo.courses.service.CourseDaoService;
import com.example.demo.courses.service.CourseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;

@RestController
public class CourseController {
    private static final Logger logger = LoggerFactory.getLogger(CourseDaoService.class);

    @Autowired
    private CourseRepository repository;

    @Autowired
    private CourseDaoService courseDaoService;

    CourseController(CourseRepository repository, CourseDaoService courseDaoService) {
        this.repository = repository;
        this.courseDaoService = courseDaoService;
    }

    // http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseDaoService.getAllCourses();
    }



    //// http://localhost:8080/courses/1
    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseDetails(@PathVariable long id) {
        return courseDaoService.getCourseById(id);
    }

    /*
	POST http://localhost:8080/courses
	{
		  "name": "Learn DevOps",
		  "author": "in28minutes"
	}*/
    //POST - Create a new resource (/courses)
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseDaoService.insertCourse(course);
    }

    /*
	PUT - http://localhost:8080/courses/100001
	{
		 "id": 100001,
		 "name": "Learn Microservices 2",
		 "author": "in28minutes"
		}
	*/
    //PUT - Update/Replace a resource (/courses/1)
    @PutMapping("/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable long id, @RequestBody Course course) {
        Optional<Course> courseToUpdateOpt = courseDaoService.getCourseById(id);
        if (courseToUpdateOpt.isPresent()) {
            Course courseToUpdate = courseToUpdateOpt.get();
            courseToUpdate.setAuthor(course.getAuthor());
            courseToUpdate.setName(course.getName());
            Course updatedCourse = courseDaoService.updateCourse(courseToUpdate);
            return ResponseEntity.ok(updatedCourse);
        } else {
            // Handle the case where no course is found with the given ID
            Map<String, String> errorResponse = Collections.singletonMap("error", "No course found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

    }

    //DELETE - Delete a resource (/courses/1)
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id) {
        repository.deleteById(id);
    }

    @GetMapping("/")
    public String seeHelloWorld() {
        return "Hello World";
    }


}
