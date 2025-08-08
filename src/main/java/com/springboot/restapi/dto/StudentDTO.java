package com.springboot.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Data
public class StudentDTO {
    private Long nationalId;
    private String name;
    private String email;
    private String contactNumber;
    private Map<String, Object> post;

    public StudentDTO(Long nationalId, String name, String email, String contactNumber, Map<String, Object> post) {
        this.nationalId = nationalId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.post = post;
    }
}
