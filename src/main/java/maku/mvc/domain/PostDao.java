package maku.mvc.domain;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface PostDao {
    
    public void persistPost(Post post);
    
    public void mergePost(Post post);
    
    public Post getPostById(Long id);
    
    public Post getPostByTitle(String title);
    
    public List<Post> getAllPosts();
    
    public List<Post> getByUser(User user);
    
    public void removePost(Post post);
    
    public void removePost(Long id);
    
    public void persistComment(Comment comment);
    
    public void mergeComment(Comment comment);
    
    public Comment getCommentById(Long id);
    
    public List<Comment> getCommentsByUser(User user);
    
    public List<Comment> getCommentsByPost(Post post);
    
    public void removeComment(Long id);
    
    public void removeComment(Comment comment);
}
