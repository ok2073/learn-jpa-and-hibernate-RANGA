package com.keelient.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Course_Details")
public class Course {

    @Id
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="author")
    private String author;

}
