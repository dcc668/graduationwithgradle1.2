package com.example.graduation.dao;


import com.example.graduation.model.Course;

import java.util.List;


public interface CourseDAO extends IDAO<Course>{
    List<Course> findBySchool(String school);
}
