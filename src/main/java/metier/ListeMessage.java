/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import domaine.Message;
import base.MessageDao;

/**
 *
 * @author thomas
 */
public class ListeMessage extends ListeObjects{
  public ListeMessage (int idO, int idF) {liste = MessageDao.getListeMessage(idO,idF);}
  
  public Message get (int k) {return (Message)super.get(k);}
  
  public Message getCourant () {return (Message)super.getCourant();}
  
}
