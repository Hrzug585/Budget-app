package com.project.budgetapp.controllers;

import com.project.budgetapp.domain.IImageService;
import com.project.budgetapp.models.Image;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final IImageService imageService;

    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Image createImage(@RequestParam("image") MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        Image newImage = new Image(27, bytes);
        return imageService.createImage(newImage);
    }

    @GetMapping("get/{id}")
    public Image getImage(@PathVariable long id) {
        return imageService.getImage(id);
    }

}