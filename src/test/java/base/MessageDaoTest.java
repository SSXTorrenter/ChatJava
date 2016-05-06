/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.ArrayList;


/**
 *
 * @author thomas
 */
public class MessageDaoTest {
    
    @Test
    public void test_getListeMessage_false(){
        ArrayList listMessageTrue = MessageDao.getListeMessage(1, 3);
        ArrayList listMessage = MessageDao.getListeMessage(1, 1);
        assertNotEquals(listMessageTrue, listMessage);
    }
    
}
