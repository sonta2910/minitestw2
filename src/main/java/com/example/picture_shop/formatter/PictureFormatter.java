package com.example.picture_shop.formatter;

import com.example.picture_shop.model.Picture;
import com.example.picture_shop.service.IPictureService;
import org.springframework.format.Formatter;

import java.util.Locale;

public class PictureFormatter implements Formatter<Picture> {
    private IPictureService iPictureService;

    public PictureFormatter(IPictureService iPictureService) {
        this.iPictureService = iPictureService;
    }

    @Override
    public Picture parse(String text, Locale locale) {
        return iPictureService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Picture object, Locale locale) {
        return null;
    }
}
