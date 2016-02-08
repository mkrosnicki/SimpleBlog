/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import java.util.List;
import junit.framework.Assert;
import maku.mvc.entities.Role;
import maku.mvc.entities.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:**mvc-dispatcher-servlet.xml", "classpath:**security-context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@WebAppConfiguration
public class UserDaoImplTest {
    
    @Autowired
    UserDao userDao;
    
    public UserDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        userDao.deleteAll();
        
        User u1 = new User();
        u1.setName("User 1");
        userDao.saveUser(u1);
        
        User u2 = new User();
        u2.setName("User 2");
        userDao.saveUser(u2);
        
        User u3 = new User();
        u3.setName("User 3");
        userDao.saveUser(u3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class UserDaoImpl.
     */
    @Test
    public void testGetAll() {
        
        List<User> users = userDao.getAll();
        
        assertEquals("Size of users", 3, users.size());
    }

    /**
     * Test of getUserByName method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserByName() {
        System.out.println("getUserByName");
        String name = "";
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.getUserByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserDaoImpl.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.addUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveUser method, of class UserDaoImpl.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.saveUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class UserDaoImpl.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        User person = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.deletePerson(person);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleById method, of class UserDaoImpl.
     */
    @Test
    public void testGetRoleById() {
        System.out.println("getRoleById");
        Long id = null;
        UserDaoImpl instance = new UserDaoImpl();
        Role expResult = null;
        Role result = instance.getRoleById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleByAuthority method, of class UserDaoImpl.
     */
    @Test
    public void testGetRoleByAuthority() {
        System.out.println("getRoleByAuthority");
        String authority = "";
        UserDaoImpl instance = new UserDaoImpl();
        Role expResult = null;
        Role result = instance.getRoleByAuthority(authority);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRolesByAuthority method, of class UserDaoImpl.
     */
    @Test
    public void testGetRolesByAuthority() {
        System.out.println("getRolesByAuthority");
        String authority = "";
        UserDaoImpl instance = new UserDaoImpl();
        List<Role> expResult = null;
        List<Role> result = instance.getRolesByAuthority(authority);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRole method, of class UserDaoImpl.
     */
    @Test
    public void testAddRole() {
        System.out.println("addRole");
        Role role = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.addRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveRole method, of class UserDaoImpl.
     */
    @Test
    public void testSaveRole() {
        System.out.println("saveRole");
        Role role = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.saveRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDaoImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.deleteUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        Long id = null;
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
