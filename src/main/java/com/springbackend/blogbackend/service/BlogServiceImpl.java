package com.springbackend.blogbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.blogbackend.dao.BlogRepository;
import com.springbackend.blogbackend.entity.Blog;

@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository theBlogRepository){
        blogRepository = theBlogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int theId) {
        Optional<Blog> result = blogRepository.findById(theId);
        Blog theBlog = null;
        if (result.isPresent()){
            theBlog = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee with id - " + theId);
        }

        return theBlog;
    }

    @Override
    public Blog save(Blog theBlog) {
        return blogRepository.save(theBlog);
    }

    @Override
    public void deleteById(int theId) {
        blogRepository.deleteById(theId);
    }
    
}
