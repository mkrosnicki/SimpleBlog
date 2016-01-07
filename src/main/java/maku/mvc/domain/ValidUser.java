/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.domain;

import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Maku
 */
public class ValidUser {

    @Size(min = 3, max = 20, message = "Nazwa użytkownika musi zawierać od 3 do 20 znaków")
    private String name;

    @Size(min = 3, max = 20, message = "Hasło musi składać się z 3 do 20 znaków")
    private String password;

    private String repeatPassword;

    private MultipartFile image;

    private String imageName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
