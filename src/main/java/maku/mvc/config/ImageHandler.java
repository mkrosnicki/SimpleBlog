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

    public static void validate(Object o) throws ImageUploadException {
        MultipartFile file = (MultipartFile) o;
        if (!file.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Akceptowany jedynie format JPG!");
        }
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
            Files.delete(Paths.get(path + fileName));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public static boolean update(String fileName, String path, MultipartFile newImage) {
        BufferedImage oldImage = null;
        try {    
            URL url = new URL(path + fileName);
            oldImage = ImageIO.read(url);
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        if (delete(fileName, path)) {
            try {
                save(fileName, path, newImage);
                return true;
            } catch (ImageUploadException ex) {
                try {
                    ImageIO.write(oldImage, "jpg", new File(path));
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }
}
