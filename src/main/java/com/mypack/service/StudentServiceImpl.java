package com.mypack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypack.exception.StudentNotFoundException;
import com.mypack.model.Student;
import com.mypack.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
	StudentRepository studentRepository;
	@Override
	public Student create(Student st) {
		System.out.println("****************** "+st.getName());
		return studentRepository.save(st);
	}

	@Override
	public void delete(int id) {
		 studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> findAll() {
	 return studentRepository.findAll();
		
	}

	@Override
	public Student getById(Integer id) {
		Optional<Student> findByid=studentRepository.findById(id);
		Student std = findByid.orElseThrow(()-> new StudentNotFoundException("not found"));
		return std;
		
	}

}
