package com.springboot.restapi.repository;

import com.springboot.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
