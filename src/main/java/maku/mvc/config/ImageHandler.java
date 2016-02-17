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

    public static void validate(Object o) throws ImageOperationException {
        MultipartFile file = (MultipartFile) o;
        if (!file.getContentType().equals("image/jpeg")) {
            throw new ImageOperationException("Akceptowany jedynie format JPG!");
        }
    }

    public static void save(String fileName, String path, MultipartFile image) throws ImageOperationException {
        try {
            File file = new File(path + "//" + fileName);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException ex) {
            throw new ImageOperationException("Nie udało się zapisać pliku!");
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
        } catch (ImageOperationException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
