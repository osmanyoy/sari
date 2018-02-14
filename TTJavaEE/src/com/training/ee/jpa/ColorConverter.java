package com.training.ee.jpa;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.training.ee.model.Color;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        return color.toString();
    }

    @Override
    public Color convertToEntityAttribute(String colorStr) {
        String[] split = colorStr.split(",");
        Color color = new Color();
        color.setRed(Integer.parseInt(split[0]));
        color.setGreen(Integer.parseInt(split[1]));
        color.setBlue(Integer.parseInt(split[2]));
        return color;
    }

}
