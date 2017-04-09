package com.example.graduation.serviceImp;


import com.example.graduation.dao.TeacherStudentDAO;
import com.example.graduation.model.TeacherStudent;
import com.example.graduation.service.TeacherStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TeacherStudentServiceImp implements TeacherStudentService{
	
	@Resource(name="teacherStudentDAOImp")
	TeacherStudentDAO teacherStudentDAO;
	
	public TeacherStudent  findById(Serializable id) {
		TeacherStudent t=(TeacherStudent)teacherStudentDAO.findById(id);
		return t;
	}

	@Override
	public void add(TeacherStudent t) {
		teacherStudentDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		teacherStudentDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<TeacherStudent> collection) {
		teacherStudentDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<TeacherStudent> findAllAndPage(int firstResult, int maxResults) {
		Collection<TeacherStudent> coll=teacherStudentDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(TeacherStudent t) {
		teacherStudentDAO.update(t);
	}

	@Override
	public Integer getCount(TeacherStudent teacherStudent) {
		return teacherStudentDAO.getCount(teacherStudent);
	}

	@Override
	public Collection<TeacherStudent> findAll() {
		Collection<TeacherStudent>coll=teacherStudentDAO.findAll();
		return coll;
	}

	@Override
	public List<Integer> queryScore(int sId) {
		 List<TeacherStudent>tss=teacherStudentDAO.queryScore(sId);
		 List<Integer> scores=new ArrayList<Integer>();
		 	for(TeacherStudent ts:tss){
		 		scores.add(ts.getScore());
		 	}
			return scores;
	}


}
