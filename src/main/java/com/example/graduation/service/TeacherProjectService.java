package com.example.graduation.service;

import com.example.graduation.model.TeacherProject;
import com.example.graduation.vo.Page;

import java.io.Serializable;
import java.util.List;

public interface TeacherProjectService extends IService<TeacherProject> {
    public List<TeacherProject> findByTeacherId(Serializable id);
    public List<TeacherProject> findByTeacherIdAndPage(Serializable id,Page page);
    public List<TeacherProject> findByProjectId(Serializable id);
    public TeacherProject findByPrIdAndTeId(Serializable prId, Serializable teId);
}
