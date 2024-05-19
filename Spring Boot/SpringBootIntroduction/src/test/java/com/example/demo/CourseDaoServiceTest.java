//package com.example.demo;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//import com.example.demo.courses.Bean.Course;
//import com.example.demo.courses.service.CourseDaoService;
//import jakarta.persistence.EntityManager;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//@ExtendWith(SpringExtension.class)
//public class CourseDaoServiceTest {
//
//    @Mock
//    private EntityManager entityManager;
//
//    @InjectMocks
//    private CourseDaoService courseDaoService;
//
//    @Test
//    public void testInsertCourse() {
//        Course course = new Course();
//        course.setName("Software Engineering");
//        when(entityManager.merge(any(Course.class))).thenReturn(course);
//
//        Course savedCourse = courseDaoService.insertCourse(course);
//        assertNotNull(savedCourse);
//        assertEquals(course.getName(), savedCourse.getName());
//    }
//
//    @Test
//    public void testGetCourseById() {
//        Course course = new Course();
//        course.setId(1);
//        when(entityManager.find(Course.class, 1L)).thenReturn(course);
//
//        Optional<Course> foundCourse = courseDaoService.getCourseById(1L);
//        assertTrue(foundCourse.isPresent());
//        assertEquals(1L, foundCourse.get().getId());
//    }
//
//    @Test
//    public void testDeleteCourse() {
//        doNothing().when(entityManager).remove(any(Course.class));
//        assertDoesNotThrow(() -> courseDaoService.deleteCourse(1L));
//    }
//}
