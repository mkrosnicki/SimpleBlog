package maku.mvc.dao;

import java.util.List;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserDao {
    
    
    public List<User> getAll();
    
    public User getPersonById(Long id);
    
    public void addPerson(User person);
    
    public void savePerson(User person);
    
    public void deletePerson(User person);
    
    public void deletePerson(Long id);
    
}
