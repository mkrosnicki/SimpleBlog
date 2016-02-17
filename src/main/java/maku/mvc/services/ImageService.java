/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import maku.mvc.config.ImageHandler;
import maku.mvc.config.ImageOperationException;
import maku.mvc.constants.Constants;
import maku.mvc.entities.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Maku
 */
public class ImageService {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    public static void updateAvatar(MultipartFile file, User user, String path) throws ImageOperationException {
        ImageService imageService = new ImageService();
        if (file.isEmpty()) {
            throw new ImageOperationException(Constants.FILE_NOT_CHOSEN);
        }
        if (!isJpeg(file)) {
            throw new ImageOperationException(Constants.UPDATE_AVATAR_ERROR);
        }
        if (!user.getImageName().equals(User.DEFAULT_IMAGE_NAME)) {
            if (delete(user.getImageName(), path)) {
                if (!save(user.getImageName(), path, file)) {
                    throw new ImageOperationException(Constants.UPDATE_AVATAR_ERROR);
                }
            } else {
                throw new ImageOperationException(Constants.UPDATE_AVATAR_ERROR);
            }
        }
        if (!save(user.getImageName(), path, file)) {
            throw new ImageOperationException(Constants.UPDATE_AVATAR_ERROR);
        }
        user.setImageName("user" + user.getId() + ".jpg");
        imageService.userService.merge(user);
    }

    public static void deleteAvatar(User user, String path) throws ImageOperationException {
        ImageService imageService = new ImageService();
        if (!user.getImageName().equals(User.DEFAULT_IMAGE_NAME) && !delete(user.getImageName(), path)) {
            throw new ImageOperationException(Constants.DELETE_AVATAR_ERROR);
        }
        user.setImageName(User.DEFAULT_IMAGE_NAME);
        imageService.userService.merge(user);
    }

    public static boolean isJpeg(MultipartFile file) {
        return file.getContentType().equals("image/jpeg");
    }

    private static boolean save(String fileName, String path, MultipartFile image) {
        try {
            File file = new File(path + "//" + fileName);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    private static boolean delete(String fileName, String path) {
        try {
            Files.delete(Paths.get(path + "//" + fileName));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private static boolean update(String fileName, String path, MultipartFile newImage) {
        if (delete(fileName, path)) {
            return save(fileName, path, newImage);
        } else {
            return false;
        }
    }

}
