package com.training.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.training.jsf.model.Address;

@FacesConverter("com.training.jsf.converter.AddressConverter")
public class AddressConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String[] split = value.split(",");
		if (split.length != 4) {
			FacesMessage facesMessage= new FacesMessage("Girdi yanlýþ",  "street,town,city,postcode þeklinde giriniz");
			throw new ConverterException(facesMessage);
		}
		Address address = new Address();
		address.setStreet(split[0]);
		address.setTown(split[1]);
		address.setCity(split[2]);
		address.setPostcode(Integer.parseInt(split[3]));
		
		return address;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Address address = (Address) value;
			String str = address.getStreet() + "," + address.getTown() + "," + address.getCity() +"," + address.getPostcode();
			return str;
		}
		return null;
	}

}
