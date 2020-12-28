package com.project.budgetapp.services;

import com.project.budgetapp.domain.IImageService;
import com.project.budgetapp.models.Image;
import com.project.budgetapp.repositories.IExpenseRepository;
import com.project.budgetapp.repositories.IImageRepository;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class ImageService implements IImageService {
    private final IImageRepository imageRepository;

    @Autowired
    public ImageService(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image getImage(long id) {
        return imageRepository.findImagesByExpenseId(id);
    }

    @Override
    @Transactional
    public Image createImage(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());

        long expenseId = 27;
        byte[] bytes = file.getBytes();
        Image newImage = new Image(expenseId, bytes);
        imageRepository.deleteAllByExpenseId(expenseId);
        //imageRepository.flush();
        return imageRepository.saveAndFlush(newImage);
    }
}
