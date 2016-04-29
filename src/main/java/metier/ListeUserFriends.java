/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import domaine.User;
import base.UserDao;

/**
 *
 * @author thomas
 */
public class ListeUserFriends extends ListeObjects{
    public ListeUserFriends (int id) {liste = UserDao.getListeUser(id);}
  
    public User get (int k) {return (User)super.get(k);}
  
    public User getCourant () {return (User)super.getCourant();}
}
