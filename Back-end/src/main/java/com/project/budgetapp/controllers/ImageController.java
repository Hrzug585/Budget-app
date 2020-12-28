package com.project.budgetapp.controllers;

import com.project.budgetapp.domain.IImageService;
import com.project.budgetapp.models.Image;
import com.sun.istack.NotNull;
import io.swagger.v3.core.util.Json;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    public Image createImage(@RequestPart("image") @Valid @NotNull @NotBlank MultipartFile file) throws IOException {
        return imageService.createImage(file);
    }

    @GetMapping("get/{id}")
    public Image getImage(@PathVariable long id) {
        return imageService.getImage(id);
    }

}