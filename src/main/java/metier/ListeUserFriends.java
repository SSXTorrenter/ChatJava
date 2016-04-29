/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package metier;
import domaine.User;
import base.UserDao;

public class ListeUserFriends extends ListeObjects{
    public ListeUserFriends (int id) {liste = UserDao.getListeUser(id);}
  
    public User get (int k) {return (User)super.get(k);}
  
    public User getCourant () {return (User)super.getCourant();}
}
