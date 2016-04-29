/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author thomas
 */
public class Message {
  private User autor;        /* Identifiant */
  private String text;    /* Nom */

  /** Constructeur */
  public Message (User autor, String text) {
    this.autor = autor;
    this.text = text;
  } // Constructeur

  /** Accesseurs */
  public User getAutor () {return autor;}
  public String getText () {return text;}
  
  @Override
  public String toString(){ return autor.getLogin() + " : " + text;}
}
