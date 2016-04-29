/************************************************/
/**** CETTE CLASSE NE DOIT PAS ÊTRE MODIFIÉE ****/
/************************************************/
package base.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connexion à la base MySQL.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 2.0
*/
public class Outils {

  /** Retourne une connexion avec une base de données MySQL. */
  public static Connection connect (String nomBase, String address, int port) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Properties props = new Properties();
    props.put("user", "user"); props.put("password", "password"); props.put("charSet", "UTF-8");
    return DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + nomBase, props);
  } // connect

} // Outils
