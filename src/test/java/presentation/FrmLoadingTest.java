package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 *
 * @author thomas
 */
public class FrmLoadingTest {
    
    @Test
    public void test_connection_to_db_true(){
        boolean getCon = FrmLoading.getConnection("192.168.1.205",3306);
        assertTrue(getCon);
    }
    
    @Test
    public void test_connection_to_db_false(){
        boolean getCon = FrmLoading.getConnection("192.168.1.206",3306);
        assertFalse(getCon);
    }
}
