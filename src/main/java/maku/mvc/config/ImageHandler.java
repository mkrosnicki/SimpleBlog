package maku.mvc.config;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageHandler {
    
    /**
     * Checks whether the file's format is JPG
     * @param file
     *        file to be validated
     * @return true if file's format is JPG
     */
    public static boolean validate(MultipartFile file) {
        return file.getContentType().equals("image/jpeg");
    }

    public static void save(String fileName, String path, MultipartFile image) throws ImageUploadException {
        try {
            File file = new File(path + "//" + fileName);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException ex) {
            throw new ImageUploadException("Nie udało się zapisać pliku!");
        }
    }

    public static boolean delete(String fileName, String path) {
        try {
            Files.delete(Paths.get(path + "//" + fileName));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean update(String fileName, String path, MultipartFile newImage) {
        delete(fileName, path);
        try {
            save(fileName, path, newImage);
            return true;
        } catch (ImageUploadException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
