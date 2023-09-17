package com.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.model.Student;
import com.mypack.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
	public StudentService studentservice;
    
    @RequestMapping(name="save" ,method = RequestMethod.POST)
    @PostMapping("save")
    public ResponseEntity<String> save1(@RequestBody Student st){
    	
    	Student student=studentservice.create(st);
    	return new ResponseEntity<String>("student save successfully", HttpStatus.OK);
    }
    @GetMapping("all")
    public List<Student> findAllStudent(){
    	
    	List<Student> findall=studentservice.findAll();
    	return findall;
    }
    
    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
    	
    	studentservice.delete(id);
    	return new ResponseEntity<String>("student delete successfully"+id, HttpStatus.OK);
    }
    @PutMapping("modify/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody Student st){
    	Student student=studentservice.getById(id);
    	student.setName(st.getName());
    	student.setEmail(st.getEmail());
    	student.setMobno(st.getMobno());
    	student.setMarks(st.getMarks());
    	studentservice.create(student);
    	return new ResponseEntity<String>("student"+id+" updated successfully", HttpStatus.OK);
    }
}
