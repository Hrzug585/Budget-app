package com.project.budgetapp.domain;

import com.project.budgetapp.models.Image;
import io.swagger.v3.core.util.Json;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {
    Image createImage(MultipartFile file, String id) throws IOException;
    Image getImage(long id);
}
