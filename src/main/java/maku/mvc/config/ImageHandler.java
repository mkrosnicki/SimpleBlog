package maku.mvc.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageHandler {

    public static void validate(Object o) throws ImageUploadException{
        MultipartFile file = (MultipartFile) o;
        if (!file.getContentType().equals("image/jpeg"))
            throw new ImageUploadException("Akceptowany jedynie format JPG!");
    }
    
    public static void save(String fileName, String path, MultipartFile image) throws ImageUploadException {
        try {
            File file = new File(path + "/upload/" + fileName);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException ex) {
            throw new ImageUploadException("Nie udało się zapisać pliku!");
        }
        
    }
    
}
