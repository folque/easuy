/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {
    
    @Inject
    private UserEBean userEBean;
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
            "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
            "(\\.[A-Za-z]{2,})$";
    
    private Pattern pattern;
    private Matcher matcher;
    
    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIForm formComponent = (UIForm) component.getNamingContainer();
        UIInput otherEmailComp = (UIInput) formComponent.findComponent("confirmEmail");
        String otherEmail = (String) otherEmailComp.getSubmittedValue();
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){
            
            FacesMessage msg =
                    new FacesMessage("E-mail validation failed.",
                            "Invalid E-mail format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
        if(!value.toString().equals(otherEmail)){
            otherEmailComp.setValid(false);
            FacesMessage msg =
                    new FacesMessage("E-mail validation failed.",
                            "E-mail and E-mail repetition must match.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
        User user = userEBean.findByEmail(value.toString());
        if(user != null){
            FacesMessage msg =
                    new FacesMessage("E-validation failed.",
                            "E-mail already registered.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
