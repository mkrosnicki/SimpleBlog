/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.config;

import maku.mvc.domain.ValidUser;

/**
 *
 * @author Maku
 */
public class UserValidator {
    
    public static boolean valid(ValidUser user) {
        
        return user.getPassword().equals(user.getRepeatPassword());
    }
    
}
