package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

	public EmailValidator() {
		
	}

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent,
			Object object) throws ValidatorException {
		String email = (String) object;

		if (!email.contains("@")) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Email is not valid.");
			message.setDetail("Email is not valid.");
			facesContext.addMessage("userForm:Email", message);
			throw new ValidatorException(message);
		}
	}

}
