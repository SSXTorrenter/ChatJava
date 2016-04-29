
package outils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import static presentation.FrmLoading.getConnection;
import presentation.FrmServer;


/**
 * Outils de validation de nombres
 *
 * @author RODRIGUEZ-VELDHUIS Thomas
 * @version Version 1.1
*/
public class Validation {

  /* Retourne true ssi le String str est un int valide */
  public static boolean isIntValid (String str) {
    try {Integer.parseInt(str);} catch (NumberFormatException e) {return false;}
    return true;
  } // isIntValid

  /* Retourne true ssi le String str est un double valide */
  public static boolean isDoubleValid (String str) {
    try {Double.parseDouble(str);} catch (NumberFormatException e) {return false;}
    return true;
  } // isDoubleValid
  
  public static boolean pingHost(String host, int port) throws UnknownHostException {
    try {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(host, port);
        socket.connect(socketAddress, 1000);
        socket.close();
        return true;
    } catch (IOException e) {
        return false;
    }
  }

} // Validation