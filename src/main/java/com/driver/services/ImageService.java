package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    @Autowired
    BlogRepository blogRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog


        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        Blog blog = findById(blogId).getBlog();
        image.setBlog(blog);
        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){

        Image image =imageRepository2.findById(id).get();
        imageRepository2.delete(image);
    }

    public Image findById(Integer id) {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
return 0;

    }
}