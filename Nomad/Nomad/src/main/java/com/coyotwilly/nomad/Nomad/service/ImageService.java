package com.coyotwilly.nomad.Nomad.service;

import com.coyotwilly.nomad.Nomad.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    Long addImgBackground(MultipartFile image, Long userId) throws IOException;
    List<Long> addSeveralImg(MultipartFile[] images, Long userId) throws IOException;
    byte[] getBackgroundImg(Long id);
    Iterable<Image> getAllImg();
}
