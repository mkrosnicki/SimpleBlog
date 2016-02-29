/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.validators;

import maku.mvc.exceptions.PasswordNotValidException;
import maku.mvc.handlers.PasswordFormHandler;

/**
 *
 * @author Maku
 */
public class PasswordFormValidator {

    public static void valid(String oldPassword, PasswordFormHandler handler) throws PasswordNotValidException {
        if (!handler.getOldPassword().equals(oldPassword))
            throw new PasswordNotValidException("Niepoprawne stare hasło!");
        if (!handler.getNewPassword().equals(handler.getNewPasswordRepeat()))
            throw new PasswordNotValidException("Wpisane hasła nie są identyczne!");
    }

}
