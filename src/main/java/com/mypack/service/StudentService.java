package com.mypack.service;

import java.util.List;

import com.mypack.model.*;
public interface StudentService {
	
	public Student create(Student st);
	public void delete(int id);
	public List<Student> findAll();
	public Student getById(Integer id);
	

}
