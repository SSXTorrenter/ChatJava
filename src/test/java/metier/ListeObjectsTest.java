/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;


/**
 *
 * @author thomas
 */
public class ListeObjectsTest {
    private List liste = new ArrayList();
    private ListeObjects listeObjects;
    
    @BeforeMethod
    public void testSetUp(){
        for (int i = 0; i < 20; i++) {
            liste.add(i);
        }
        listeObjects = new ListeObjects(liste);
    }
    
    @Test
    public void test_getCourant(){
        assertNull(listeObjects.getCourant());
    }
    
    @Test
    public void test_contains(){
        assertTrue(listeObjects.contains(6));
    }
    
    @Test
    public void test_contains_false(){
        assertFalse(listeObjects.contains(60));
    }
    
    @Test
    public void test_size(){
        assertEquals(listeObjects.size(), 99);
    }
    
    
    @Test
    public void test_del(){
        int listeObjectSize = listeObjects.size();
        listeObjects.del(5);
        assertEquals(listeObjects.size(), listeObjectSize - 1);
    }
    
}
