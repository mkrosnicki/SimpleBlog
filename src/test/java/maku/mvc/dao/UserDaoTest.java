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

        userDao.deleteAllUsers();
        userDao.deleteAllRoles();
        postDao.deleteAllPosts();
        
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

        Assert.assertEquals("Size of users", 3, users.size());

    }

    /**
     * Test of getUserByName method, of class UserDao.
     */
    @Test
    public void testGetUserByName() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistUser method, of class UserDao.
     */
    @Test
    public void testPersistUser() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergeUser method, of class UserDao.
     */
    @Test
    public void testMergeUser() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleById method, of class UserDao.
     */
    @Test
    public void testGetRoleById() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleByAuthority method, of class UserDao.
     */
    @Test
    public void testGetRoleByAuthority() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRolesByAuthority method, of class UserDao.
     */
    @Test
    public void testGetRolesByAuthority() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistRole method, of class UserDao.
     */
    @Test
    public void testPersistRole() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergeRole method, of class UserDao.
     */
    @Test
    public void testMergeRole() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDao.
     */
    @Test
    public void testDeleteUser() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserDao.
     */
    @Test
    public void testGetUserById() {
        fail("The test case is a prototype.");
    }

}
