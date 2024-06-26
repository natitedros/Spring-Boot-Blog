package com.springbackend.blogbackend.service;

import java.util.List;

import com.springbackend.blogbackend.entity.Blog;

public interface BlogService {
    
    List<Blog> findAll();

    Blog findById(int theId);

    Blog save(Blog theBlog);

    void deleteById(int theId);
}
