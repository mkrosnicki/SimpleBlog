/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.exceptions;

/**
 *
 * @author Maku
 */
public class PasswordNotValidException extends Exception {

    public PasswordNotValidException(String message) {
        super(message);
    }

}