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

//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getAll method, of class PostDao.
//     */
//    @Test
//    public void testGetAll() {
//        ;
//    }
//
//    /**
//     * Test of persistPost method, of class PostDao.
//     */
//    @Test
//    public void testPersistPost() {
//        ;
//    }
//
//    /**
//     * Test of mergePost method, of class PostDao.
//     */
//    @Test
//    public void testMergePost() {
//        ;
//    }
//
//    /**
//     * Test of getPostById method, of class PostDao.
//     */
//    @Test
//    public void testGetPostById() {
//        ;
//    }
//
//    /**
//     * Test of getPostByTitle method, of class PostDao.
//     */
//    @Test
//    public void testGetPostByTitle() {
//        ;
//    }
//
//    /**
//     * Test of getPostsByUser method, of class PostDao.
//     */
//    @Test
//    public void testGetPostsByUser() {
//        ;
//    }
//
//    /**
//     * Test of deletePost method, of class PostDao.
//     */
//    @Test
//    public void testDeletePost_Post() {
//        ;
//    }
//
//    /**
//     * Test of deletePost method, of class PostDao.
//     */
//    @Test
//    public void testDeletePost_Long() {
//        ;
//    }
//
//    /**
//     * Test of deleteAll method, of class PostDao.
//     */
//    @Test
//    public void testDeleteAll() {
//        ;
//    }

}
