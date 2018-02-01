package com.training.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.training.jsf.validator.CustomValidator")
public class CustomValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value instanceof String) {
			String str = (String) value;
			if (str.contains(" ")) {
				throw new ValidatorException(new FacesMessage("soyad boþluk barýndýramaz", "soyad boþluk barýndýramaz. Bunu siliniz lütfen"));
			}
		}
	}

}
