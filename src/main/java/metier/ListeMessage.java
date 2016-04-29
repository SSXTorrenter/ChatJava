/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package metier;

import domaine.Message;
import base.MessageDao;


public class ListeMessage extends ListeObjects{
  public ListeMessage (int idO, int idF) {liste = MessageDao.getListeMessage(idO,idF);}
  
  public Message get (int k) {return (Message)super.get(k);}
  
  public Message getCourant () {return (Message)super.getCourant();}
  
}
