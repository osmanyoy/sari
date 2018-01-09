package com.training.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.training.model.Color;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

	@Override
	public String convertToDatabaseColumn(Color attribute) {
		return attribute.getColorName() + "," + attribute.getAmount();
	}

	@Override
	public Color convertToEntityAttribute(String dbData) {
		String[] split = dbData.split(",");
		Color color = new Color();
		color.setColorName(split[0]);
		color.setAmount(Integer.parseInt(split[1]));
		return color;
	}

}
