package maku.mvc.dao;

import java.util.List;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserDao {
    
    
    public List<User> getAll();
    
    public User getUserByName(String name);
    
    public void addUser(User user);
    
    public void saveUser(User user);
    
    public void deleteUser(User user);
    
}
