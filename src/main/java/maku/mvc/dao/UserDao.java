package maku.mvc.dao;

import java.util.List;
import maku.mvc.domain.Role;
import maku.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserDao {

    List<User> getAll();

    User getUserByName(String name);

    User getUserById(Long id);
    
    void addUser(User user);

    void saveUser(User user);

    void deleteUser(User user);

    Role getRoleById(Long id);

    Role getRoleByAuthority(String authority);
    
    List<Role> getRolesByAuthority(String authority);

    void addRole(Role role);

    void saveRole(Role role);
}
