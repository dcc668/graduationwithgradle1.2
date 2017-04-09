package com.example.graduation.service;

import com.example.graduation.model.TeacherCourse;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;

public interface TeacherCourseService extends IService<TeacherCourse> {
    public List<TeacherCourse> findByTeacherId(Serializable id);
    public List<TeacherCourse> findByTeacherIdAndPage(Serializable id,Page page);
    public List<TeacherCourse> findByCourseId(Serializable id);
}
