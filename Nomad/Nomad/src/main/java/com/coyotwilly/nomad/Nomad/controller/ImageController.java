package com.coyotwilly.nomad.Nomad.controller;

import com.coyotwilly.nomad.Nomad.model.Image;
import com.coyotwilly.nomad.Nomad.service.ImageService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/img")
public class ImageController{
    @Autowired
    private ImageService imageService;
    private final Logger logger = LoggerFactory.getLogger(Image.class);

    @GetMapping(value = "/get/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable Long id){
        logger.info("GET request for image with ID=" + id);
        return imageService.getBackgroundImg(id);
    }
    @PostMapping("/add/{userId}")
    public Long postBackgroundImage(@RequestParam @NonNull MultipartFile image, @PathVariable Long userId) throws IOException {
        logger.info("Adding IMG to DB. Image name= " + image.getName());
        logger.info("Adding user= " + userId);
        return imageService.addImgBackground(image, userId);
    }
    @PostMapping("/add/{userId}/few")
    public List<Long> postListOfImages(@RequestParam MultipartFile[] files, @PathVariable Long userId) throws IOException{
        return imageService.addSeveralImg(files, userId);
    }
}
