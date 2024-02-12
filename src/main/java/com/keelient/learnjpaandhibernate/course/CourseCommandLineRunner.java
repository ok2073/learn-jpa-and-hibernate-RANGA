package com.keelient.learnjpaandhibernate.course;


import com.keelient.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.keelient.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import com.keelient.learnjpaandhibernate.jdbc.CourseJdbcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Runs at the start of the application
@Component
@Slf4j
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJdbcRepository repository;
    @Autowired
    CourseJpaRepository courseJPARepository;

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        //CourseJdbcRepository
        repository.insert(new Course(1L, "Learn AWS Now!", "in28minutes"));
        repository.insert(new Course(2L, "Learn Azure Now!", "in28minutes"));
        repository.insert(new Course(3L, "Learn DevOps Now!", "in28minutes"));

        repository.deleteById(1L);

        log.info("Course JdbcTemplate: {}", repository.findById(2L));

        //CourseJdbcRepository
        courseJPARepository.insert(new Course(1L, "Learn AWS Now!", "in28minutes"));
        courseJPARepository.insert(new Course(2L, "Learn Azure Now!", "in28minutes"));
        courseJPARepository.insert(new Course(3L, "Learn DevOps Now!", "in28minutes"));

        courseJPARepository.deleteById(1L);

        log.info("Course JPA: {}", courseJPARepository.findById(2L));

        //CourseSpringDataJpaRepository
        courseSpringDataJpaRepository.save(new Course(10L, "Learn AWS Spring Data JPA!", "in28minutes"));
        courseSpringDataJpaRepository.save(new Course(20L, "Learn Azure Spring Data JPA!", "in28minutes"));
        courseSpringDataJpaRepository.save(new Course(30L, "Learn DevOps Spring Data JPA!", "in28minutes"));

        courseSpringDataJpaRepository.deleteById(10L);

        log.info("Course Spring Data JPA: {}", courseSpringDataJpaRepository.findById(2L));

        log.info("All courses Spring Data JPA: {} ", courseSpringDataJpaRepository.findAll());
        log.info("All courses Spring Data JPA count: {} ", courseSpringDataJpaRepository.count());

        log.info("findByAuthor Spring Data JPA count: {} ", courseSpringDataJpaRepository.findByAuthor("in28minutes"));
        log.info("findByAuthor Spring Data JPA count: {} ", courseSpringDataJpaRepository.findByAuthor(""));

        log.info("findByAuthor Spring Data JPA count: {} ", courseSpringDataJpaRepository.findByName("Learn Azure Spring Data JPA!"));
        log.info("findByAuthor Spring Data JPA count: {} ", courseSpringDataJpaRepository.findByName(""));



    }
}
