/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;
import java.util.*;

/**
 *
 * @author thomas
 */
public class User {
  private int id;        /* Identifiant */
  private String login;    /* Nom */

  /** Constructeur */
  public User (int id, String login) {
    this.id = id;
    this.login = login;
  } 

    // Constructeur

  /** Accesseurs */
  public int getId () {return id;}
  public String getLogin () {return login;}

  @Override
  public boolean equals (Object obj) {return ((User)obj).id == id;}
  
  @Override
  public String toString(){ return login;}
}
