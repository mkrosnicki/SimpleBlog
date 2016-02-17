/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maku.mvc.dao;

import java.util.List;
import maku.mvc.entities.Post;
import maku.mvc.entities.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Maku
 */
public class PostDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private RoleDao roleDao;

    public PostDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

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
     * Test of getAll method, of class PostDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        PostDao instance = new PostDao();
        List<Post> expResult = null;
        List<Post> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistPost method, of class PostDao.
     */
    @Test
    public void testPersistPost() {
        System.out.println("persistPost");
        Post post = null;
        PostDao instance = new PostDao();
        instance.persistPost(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergePost method, of class PostDao.
     */
    @Test
    public void testMergePost() {
        System.out.println("mergePost");
        Post post = null;
        PostDao instance = new PostDao();
        instance.mergePost(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostById method, of class PostDao.
     */
    @Test
    public void testGetPostById() {
        System.out.println("getPostById");
        Long id = null;
        PostDao instance = new PostDao();
        Post expResult = null;
        Post result = instance.getPostById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostByTitle method, of class PostDao.
     */
    @Test
    public void testGetPostByTitle() {
        System.out.println("getPostByTitle");
        String title = "";
        PostDao instance = new PostDao();
        Post expResult = null;
        Post result = instance.getPostByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostsByUser method, of class PostDao.
     */
    @Test
    public void testGetPostsByUser() {
        System.out.println("getPostsByUser");
        User user = null;
        PostDao instance = new PostDao();
        List<Post> expResult = null;
        List<Post> result = instance.getPostsByUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePost method, of class PostDao.
     */
    @Test
    public void testDeletePost_Post() {
        System.out.println("deletePost");
        Post post = null;
        PostDao instance = new PostDao();
        instance.deletePost(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePost method, of class PostDao.
     */
    @Test
    public void testDeletePost_Long() {
        System.out.println("deletePost");
        Long id = null;
        PostDao instance = new PostDao();
        instance.deletePost(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class PostDao.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        PostDao instance = new PostDao();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
