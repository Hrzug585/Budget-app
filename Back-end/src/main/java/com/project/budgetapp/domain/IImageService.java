package com.project.budgetapp.domain;

import com.project.budgetapp.models.Image;

public interface IImageService {
    Image createImage(Image image);
    Image getImage(long id);
}
