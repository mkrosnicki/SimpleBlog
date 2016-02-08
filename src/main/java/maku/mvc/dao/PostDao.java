package maku.mvc.dao;

import java.util.List;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PostDao {
    
    public void persistPost(Post post);
    
    public void mergePost(Post post);
    
    public Post getById(Long id);
    
    public Post getByTitle(String title);
    
    public List<Post> getAllPosts();
    
    public List<Post> getByUser(User user);
    
    public void removePost(Post post);
    
    public void removePost(Long id);
    
}
