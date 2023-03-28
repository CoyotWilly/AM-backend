package com.coyotwilly.nomad.Nomad.service.Implementation;

import com.coyotwilly.nomad.Nomad.model.Image;
import com.coyotwilly.nomad.Nomad.repository.ImageRepo;
import com.coyotwilly.nomad.Nomad.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageImpl implements ImageService {
    @Autowired
    private ImageRepo imageRepo;

    @Override
    public byte[] getBackgroundImg(Long id) {
        Optional<Image> img = imageRepo.findById(id);
        return img.map(Image::getContent).orElse(null);
    }

    @Override
    public List<Long> addSeveralImg(MultipartFile[] images, Long userId) throws IOException{
        List<Long> savedId = new ArrayList<>();
        for (MultipartFile file : images) {
            Image imgToAdd = new Image();
            imgToAdd.setName(file.getName());
            imgToAdd.setContent(file.getBytes());
            imgToAdd.setUserId(userId);

            // return List elements and imgRepo object saving
            imageRepo.save(imgToAdd);
            savedId.add(imgToAdd.getId());
        }
        return savedId;
    }

    @Override
    public Long addImgBackground(MultipartFile image, Long userId) throws IOException {
        Image img = new Image();
        img.setName(image.getName());
        img.setContent(image.getBytes());
        img.setUserId(userId);
        return imageRepo.save(img).getId();
    }
}
