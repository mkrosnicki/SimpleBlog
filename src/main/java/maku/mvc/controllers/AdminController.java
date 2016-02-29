package maku.mvc.controllers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import maku.mvc.config.ImageOperationException;
import maku.mvc.config.ImageHandler;
import maku.mvc.constants.Constants;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import maku.mvc.services.PostService;
import maku.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/admin")
//@Secured(value = "ROLE_ADMIN")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("welcome", "Witaj adminie!");
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        System.out.println(userService.getAll().get(0).getRoles());
        ModelAndView model = new ModelAndView();
        model.addObject("users", userService.getAll());
        model.setViewName("admin_users");
        return model;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView showPosts() {
        ModelAndView model = new ModelAndView();
        model.addObject("posts", postService.getAll());
        model.setViewName("admin_posts");
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
            Model model) {
        User loggedUser = userService.getByName(request.getUserPrincipal().getName());
        post.setPoster(loggedUser);
        post.setDateOfPublish(new Date());
        postService.persist(post);
        return "redirect:/";
    }
   
    
    

//    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
//    public String addPostForm(@Valid Post post,
//            HttpServletRequest request,
//            Model model,
//            @RequestParam(value = "image", required = false) MultipartFile image,
//            HttpSession session) {
//        
//        User loggedUser = userService.getByName(request.getUserPrincipal().getName());
//        post.setPoster(loggedUser);
//        post.setDateOfPublish(new Date());
//        postService.persist(post);
//        post.setImageName("post" + post.getId() + ".jpg");
//        postService.merge(post);
//        String uploadPath = session.getServletContext().getRealPath(Constants.UPLOAD_PATH);
//        try {
//            ImageHandler.validate(image);
//        } catch (ImageOperationException e) {
//            model.addAttribute("message", e.getMessage());
//            return "addpost";
//        }
//
//        boolean ifDeleted = ImageHandler.delete(post.getImageName(), uploadPath);
//        
//        try {
//            ImageHandler.save(post.getImageName(), uploadPath, image);
//        } catch (ImageOperationException e) {
//            model.addAttribute("message", e.getMessage());
//            return "addpost";
//        }
//        
//        postService.merge(post);
//        return "redirect:/";
//    }
    
    

//    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
//    public String addPostForm(@Valid Post post,
//            HttpServletRequest request,
//            Model model,
//            HttpSession session) {
//        User loggedUser = userService.getByName(request.getUserPrincipal().getName());
//        post.setPoster(loggedUser);
//        post.setDateOfPublish(new Date());
//        postService.persist(post);
//        post.setImageName("post" + post.getId() + ".jpg");
//        postService.merge(post);
//        return "redirect:/";
//    }
    
    @RequestMapping(value = "delete/post/{id}")
    public String deletePost(@PathVariable("id") Long id, RedirectAttributes attributes) {
        postService.delete(id);
        attributes.addFlashAttribute("message", "Pomyślnie usunięto post!");
        return "redirect:/admin/posts";
    }

    @RequestMapping(value = "/edit/post/{id}", method = RequestMethod.GET)
    public ModelAndView editPost(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView();
        Post post = postService.getById(id);
        model.addObject("post", post);
        model.setViewName("editpost");
        return model;
    }

    @RequestMapping(value = "/edit/post/{id}", method = RequestMethod.POST)
    public ModelAndView editPostForm(@Valid Post post,
            BindingResult result,
            @PathVariable("id") Long id,
            RedirectAttributes attributes) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            model.setViewName("/admin/edit/" + id);
            return model;
        }
        post.setDateOfPublish(new Date());
        postService.merge(post);
        attributes.addFlashAttribute("message", "Pomyślnie zedytowano post!");
        model.setViewName("redirect:/admin/posts");
        return model;
    }



}
