/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Diogo
 */
@FacesValidator("PasswordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIForm formComponent = (UIForm) component.getNamingContainer();
        UIInput otherPasswordComp = (UIInput) formComponent.findComponent("confirmPassword");
        String otherPassword = (String) otherPasswordComp.getSubmittedValue();
        
        if(!otherPassword.equals(value.toString())){
            FacesMessage msg = 
                    new FacesMessage("Password validation failed.",
                    "Password and Password repetition must be equal.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
