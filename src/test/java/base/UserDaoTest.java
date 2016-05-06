/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import domaine.User;
import java.util.ArrayList;


/**
 *
 * @author thomas
 */
public class UserDaoTest {
    
    @Test
    public void test_logUser(){
        User user = UserDao.logUser("thomas", "hello");
        assertNotNull(user);
    }
    
    @Test
    public void test_getListeUser_false(){
        ArrayList listUserTrue = UserDao.getListeUser(0);//true one
        ArrayList listUser = UserDao.getListeUser(1);
        assertNotEquals(listUserTrue, listUser);
    }
    
    
}
