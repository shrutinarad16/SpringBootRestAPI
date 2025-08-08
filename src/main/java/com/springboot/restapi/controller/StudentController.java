package com.springboot.restapi.controller;

import com.springboot.restapi.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.restapi.entity.Student;


import java.util.*;

import com.springboot.restapi.repository.StudentRepository;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/{nationalId}")
    public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable("nationalId") Long nationalId) {
        Optional<Student> studentOptional = repo.findById(nationalId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            long postId = (nationalId % 10) + 1;

            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://jsonplaceholder.typicode.com/posts/" + postId;

            Map<String, Object> externalPost = new HashMap<>();
            try {
                ResponseEntity<Map> postResponse = restTemplate.getForEntity(apiUrl, Map.class);
                if (postResponse.getStatusCode() == HttpStatus.OK) {
                    externalPost = postResponse.getBody();
                }
            }
                catch(Exception e){
                    externalPost.put("error", "Failed to fetch external post data");
                }

//            StudentDTO dto = new StudentDTO(
//                    student.getNationalId(),
//                    student.getName(),
//                    student.getEmail(),
//                    student.getContactNumber(),
//                    externalPost
//            );
//
//            Map<String, Object> response = new LinkedHashMap<>();
//            response.put("statusCode", 200);
//            response.put("statusMessage", "User fetched successfully");
//            response.put("data", dto);
//
//            return ResponseEntity.ok(response);
//        } else {
//            Map<String, Object> errorResponse = new LinkedHashMap<>();
//            errorResponse.put("statusCode", 404);
//            errorResponse.put("statusMessage", "User not found");
//            errorResponse.put("data", null);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//        }

            Map<String, Object> response = new HashMap<>();
            response.put("statusCode", 200);
            response.put("statusMessage", "Success");
            response.put("data", Map.of(
                    "nationalId", student.getNationalId(),
                    "name", student.getName(),
                    "email", student.getEmail(),
                    "contactNumber", student.getContactNumber(),
                    "post", externalPost
            ));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("statusCode", 404);
            errorResponse.put("statusMessage", "Student Not Found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}