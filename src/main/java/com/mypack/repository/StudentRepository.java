package com.mypack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mypack.model.*;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	

}
