/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import java.util.List;
import maku.mvc.config.DataConfig;
import maku.mvc.config.Initializer;
import maku.mvc.config.RootConfig;
import maku.mvc.config.WebMvcConfig;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, DataConfig.class, WebMvcConfig.class, Initializer.class})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@WebAppConfiguration
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;
    
    @Autowired
    private RoleDao roleDao;

    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

//        Role admin = new Role();
//        admin.setAuthority("ROLE_ADMIN");
//        userDao.persistRole(admin);

        roleDao.deleteAll();
        userDao.deleteAll();
        postDao.deleteAll();
        
        User u1 = new User();
        u1.setName("User 1");
        userDao.persist(u1);

        User u2 = new User();
        u2.setName("User 2");
        userDao.persist(u2);

        User u3 = new User();
        u3.setName("User 3");
        userDao.persist(u3);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class UserDao.
     */
    @Test
    public void testGetAll() {

        List<User> users = userDao.getAll();

        assertEquals("Size of users", 3, users.size());

    }

    /**
     * Test of getUserByName method, of class UserDao.
     */
    @Test
    public void testGetByName() {
        String userName = "User 1";
        User user = userDao.getByName(userName);
        Assert.assertEquals("User name:", userName, user.getName());
    }

    /**
     * Test of persistUser method, of class UserDao.
     */
    @Test
    public void testPersist() {
        User user4 = new User();
        user4.setName("User 4");
        userDao.persist(user4);
        List<User> users = userDao.getAll();
        Assert.assertEquals(4, users.size());
    }

    /**
     * Test of mergeUser method, of class UserDao.
     */
    @Test
    public void testMerge() {
        User user = userDao.getByName("User 1");
        String newName = "User 1 CHANGED";
        user.setName(newName);
        userDao.merge(user);
        assertEquals("User 1 CHANGED", userDao.getByName(newName).getName());
        assertEquals(null, userDao.getByName("User 1"));
    }


    /**
     * Test of delete method, of class UserDao.
     */
    @Test
    public void testDelete() {
//        User user = userDao.getUserById(1L);
//        userDao.delete(user);
//        List<User> users = userDao.getAll();
//        Assert.assertEquals(2, users.size());
    }
    
    @Test
    public void testDeleteAllUsers() {
        userDao.deleteAll();
        Assert.assertEquals(0, userDao.getAll().size());
    }

    /**
     * Test of getUserById method, of class UserDao.
     */
    @Test
    public void testGetUserById() {
        List<User> users = userDao.getAll();
        User user = users.get(1);
        long expectedId = user.getId();
        Assert.assertEquals(expectedId, (long) userDao.getUserById(expectedId).getId());
    }

}
