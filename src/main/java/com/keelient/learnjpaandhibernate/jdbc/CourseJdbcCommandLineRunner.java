package com.keelient.learnjpaandhibernate.jdbc;

import com.keelient.learnjpaandhibernate.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Runs at the start of the application
@Component
@Slf4j
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1L, "Learn AWS Now!", "in28minutes"));
        repository.insert(new Course(2L, "Learn Azure Now!", "in28minutes"));
        repository.insert(new Course(3L, "Learn DevOps Now!", "in28minutes"));

        repository.deleteById(1L);

        log.info("Course: {}", repository.findById(2L));
    }
}
