package com.example.graduation.serviceImp;


import com.example.graduation.dao.StudentDAO;
import com.example.graduation.model.Student;
import com.example.graduation.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
	
	@Resource(name="studentDAOImp")
	StudentDAO studentDAO;
	
	public Student  findById(Serializable id) {
		Student t=(Student)studentDAO.findById(id);
		return t;
	}

	@Override
	public Serializable add(Student t) {
		return studentDAO.add(t);
	}

	@Override
	public void deleteById(Serializable id) {
		studentDAO.deleteById(id);
	}

	@Override
	public void deleteByCollection(Collection<Student> collection) {
		studentDAO.deleteByCollection(collection);
	}


	@Override
	public Collection<Student> findAllAndPage(int firstResult, int maxResults) {
		Collection<Student> coll=studentDAO.findAllAndPage(firstResult, maxResults);
		return coll;
	}

	@Override
	public void update(Student t) {
		studentDAO.update(t);
	}

	@Override
	public Integer getCount(Student student) {
		return studentDAO.getCount(student);
	}

	@Override
	public Collection<Student> findAll() {
		Collection<Student>coll=studentDAO.findAll();
		return coll;
	}

	@Override
	public List<Student> findByName(String name) {
		List<Student>coll=studentDAO.findByName(name);
		return coll;
	}


}
