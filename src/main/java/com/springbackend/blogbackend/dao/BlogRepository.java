package com.springbackend.blogbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbackend.blogbackend.entity.Blog;

// @RepositoryRestResource(path="blogs")
public interface BlogRepository  extends JpaRepository<Blog, Integer>{
    
}
