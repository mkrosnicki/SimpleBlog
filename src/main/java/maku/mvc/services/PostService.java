/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.services;

import java.util.Collections;
import java.util.List;
import maku.mvc.dao.PostDao;
import maku.mvc.entities.Comment;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maku
 */
@Service
@Transactional
public class PostService {

    @Autowired
    PostDao postDao;

    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    public List<Post> getPostsSortedByDate(boolean reversed) {
        List<Post> posts = getAllPosts();
        Collections.sort(posts,
                (Post p1, Post p2) -> {
                    return p1.getDateOfPublish().compareTo(p2.getDateOfPublish());
                }
        );
        if (reversed)
            Collections.reverse(posts);
        return posts;
    }

    public void persistPost(Post post) {
        postDao.persistPost(post);
    }

    public void mergePost(Post post) {
        postDao.mergePost(post);
    }

    public Post getPostById(Long id) {
        return postDao.getPostById(id);
    }

    public Post getPostByTitle(String title) {
        return postDao.getPostByTitle(title);
    }

    public List<Post> getPostsByUser(User user) {
        return postDao.getPostsByUser(user);
    }

    public void removePost(Post post) {
        postDao.deletePost(post);
    }

    public void removePost(Long id) {
        postDao.deletePost(id);
    }

}
