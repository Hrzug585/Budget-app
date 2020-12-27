package com.project.budgetapp.services;

import com.project.budgetapp.domain.IImageService;
import com.project.budgetapp.models.Image;
import com.project.budgetapp.repositories.IExpenseRepository;
import com.project.budgetapp.repositories.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    private final IImageRepository imageRepository;
    private final IExpenseRepository expenseRepository;

    @Autowired
    public ImageService(IImageRepository imageRepository, IExpenseRepository expenseRepository) {
        this.imageRepository = imageRepository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Image getImage(long id) {
        return imageRepository.findImagesByExpenseId(id);
    }

    @Override
    public Image createImage(Image image) {
        return imageRepository.saveAndFlush(image);
    }
}
