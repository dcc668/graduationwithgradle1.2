package com.example.graduation.service;

import com.example.graduation.model.Course;

import java.util.List;

public interface CourseService extends IService<Course>{
    List<Course> findBySchool(String school);
}
