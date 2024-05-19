package com.example.demo.courses.service;

import com.example.demo.courses.Bean.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CourseDaoService {
    @PersistenceContext
    private EntityManager entityManager;

    public Course insertCourse(Course course) {
        try {
            entityManager.persist(course);
            return course;
        } catch (PersistenceException e) {
            // Log the exception, handle it, or rethrow it as a custom exception
            throw new RuntimeException("Failed to insert the course", e);
        }
    }

    public Optional<Course> getCourseById(long id) {
        return Optional.ofNullable(entityManager.find(Course.class, id));
    }

    public List<Course> getAllCourses() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c", Course.class);
        return query.getResultList();
    }

    public void deleteCourse(long id) {
        /*
        * WHERE c.id = :id: This part of the query specifies the condition under which a Course entity should be deleted.
        * The condition is that the entity's id attribute must equal the value specified by :id.
        * */
        int deletedCount = entityManager.createQuery("DELETE FROM Course c WHERE c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        if (deletedCount == 0) {
            throw new IllegalStateException("Course not found with ID: " + id);
        }
    }

    public Course updateCourse(Course course) {
        return entityManager.merge(course);
    }





}
