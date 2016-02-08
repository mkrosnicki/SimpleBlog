package maku.mvc.controllers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import maku.mvc.config.ImageUploadException;
import maku.mvc.config.ImageHandler;
import maku.mvc.dao.UserDao;
import maku.mvc.entities.Post;
import maku.mvc.dao.PostDao;
import maku.mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/admin")
@Secured(value = "ROLE_ADMIN")
public class AdminController {

    @Autowired
    UserDao dao;

    @Autowired
    PostDao postDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("welcome", "Witaj adminie!");
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        System.out.println(dao.getAll().get(0).getRoles());
        ModelAndView model = new ModelAndView();
        model.addObject("users", dao.getAll());
        model.setViewName("users");
        return model;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView showPosts() {
        ModelAndView model = new ModelAndView();
        model.addObject("posts", postDao.getAllPosts());
        model.setViewName("posts");
        return model;
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String addPostForm(@Valid Post post,
            HttpServletRequest request,
            Model model,
            @RequestParam(value = "image", required = false) MultipartFile image,
            HttpSession session) {
        User loggedUser = dao.getUserByName(request.getUserPrincipal().getName());
        post.setPoster(loggedUser);
        post.setDateOfPublish(new Date());
        postDao.persistPost(post);
        post.setImageName("post" + post.getId() + ".jpg");
        postDao.mergePost(post);
        String uploadPath = session.getServletContext().getRealPath("/resources/upload/");
        if(!ImageHandler.validate(image)) {
            model.addAttribute("message", "Akceptowany jedynie format JPG!");
            return "addpost";
        }

        boolean ifDeleted = ImageHandler.delete(post.getImageName(), uploadPath);
        
        try {
            ImageHandler.save(post.getImageName(), uploadPath, image);
        } catch (ImageUploadException e) {
            model.addAttribute("message", e.getMessage());
            return "addpost";
        }
        
        postDao.mergePost(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, RedirectAttributes attributes) {
        postDao.removePost(id);
        attributes.addFlashAttribute("message", "Pomyślnie usunięto post!");
        return "redirect:/admin/posts";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPost(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView();
        System.out.println(postDao.getById(id) == null);
        model.addObject("post", postDao.getById(id));
        model.setViewName("editpost");
        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editPostForm(@Valid Post post,
            BindingResult result,
            @PathVariable("id") Long id,
            RedirectAttributes attributes) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            model.setViewName("/admin/edit/" + id);
            return model;
        }
        post.setId(id);
        postDao.mergePost(post);
        attributes.addFlashAttribute("message", "Pomyślnie zedytowano post!");
        model.setViewName("redirect:/admin/posts");
        return model;
    }



}
