package com.mypack.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mypack.exception.StudentNotFoundException;

@RestControllerAdvice
public class CustomException {
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException stex){
		return new ResponseEntity<String>(stex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
