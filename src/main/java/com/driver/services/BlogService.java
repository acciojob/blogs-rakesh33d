package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        Blog blog = new Blog();
        User user = userRepository1.findById(userId).get();

        // updating the blog details
        blog.setUser(user);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());

        // updating the user information and changing its blogs
        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);


        userRepository1.save(user);

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        if(blogRepository1.findById(blogId).get() != null){
            blogRepository1.deleteById(blogId);
        }

    }
}
