package com.springboot.restapi.repository;

import java.util.Map;

public interface PostService {
    Map<String, Object> getPostById(int id);
}
