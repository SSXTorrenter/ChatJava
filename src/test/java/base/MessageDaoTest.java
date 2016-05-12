/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.SQLException;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static org.mockito.Mockito.*;



/**
 *
 * @author thomas
 */
public class MessageDaoTest {
    private MessageDao messageDao;
    
    @BeforeMethod
    public void setupMock(){
        messageDao = mock(MessageDao.class);
    }
    
    @Test
    public void test_sendMessage(){
        doNothing().when(messageDao).sendMessage(1,3,"test");
    }
    
    @Test(enabled = false)
    public void test_sendMessage_throw_exception(){
        doThrow(SQLException.class).when(messageDao).sendMessage(-1,3,"test");
    }
    
    
    
}
