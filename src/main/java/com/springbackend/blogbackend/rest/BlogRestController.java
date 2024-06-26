package com.springbackend.blogbackend.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbackend.blogbackend.entity.Blog;
import com.springbackend.blogbackend.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    
    private BlogService blogService;

    @Autowired
    public BlogRestController(BlogService theBlogService){
        this.blogService = theBlogService;
    }

    @GetMapping("/blogs")
    public List<Blog> findAll(){
        return blogService.findAll();
    }

    @GetMapping("/blogs/{blogId}")
    public Blog getBlog(@PathVariable int blogId){
        Blog theBlog = blogService.findById(blogId);
        if (theBlog == null){
            throw new RuntimeException("Blog id not found - " + blogId);
        }
        return theBlog;
    }

    @PostMapping("/blogs")
    public Blog addBlog(@RequestBody Blog theBlog){
        Blog dbBlog = blogService.save(theBlog);
        return dbBlog;
    }

    @PutMapping("/blogs")
    public Blog updateBlog(@RequestBody Blog theBlog){
        Blog dbBlog = blogService.save(theBlog);
        return dbBlog;
    }

    @DeleteMapping("/blogs/{blogId}")
    public String deleteBlog(@PathVariable int blogId){
        Blog tempBlog = blogService.findById(blogId);

        if (tempBlog == null){
            throw new RuntimeException("Blog id not found - "+blogId);
        }
        blogService.deleteById(blogId);
        return "Deleted blog id - " + blogId;
    }

}
