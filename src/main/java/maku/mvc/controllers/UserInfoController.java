/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import maku.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserInfoController {
    
    @Autowired
    UserDao userDao;
    
    @ModelAttribute
    public void userInfo(Model model, HttpServletRequest request) {
        String appContextPath = request.getContextPath();
        String loggedUserName;
        boolean isUserLogged;
        if (isUserLogged = request.getUserPrincipal() != null) {
            loggedUserName = request.getUserPrincipal().getName();
            model.addAttribute("loggedUserName", loggedUserName);
            model.addAttribute("isUserLogged", isUserLogged);
            try {
            model.addAttribute("loggedUserId", userDao.getUserByName(loggedUserName).getId());
            } catch (NullPointerException e) {
                model.addAttribute("loggedUserId", 0);
            }
        }   
        model.addAttribute("isAdminLogged", request.isUserInRole("ROLE_ADMIN"));
        model.addAttribute("appContextPath", appContextPath);
        
    }
    
}
