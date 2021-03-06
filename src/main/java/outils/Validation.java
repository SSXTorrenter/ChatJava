/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package outils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.apache.log4j.Logger;

public class Validation {
    
    private Validation(){
    }
    
    private final static Logger LOG = Logger.getLogger(Validation.class.getName());

    /* Retourne true ssi le String str est un int valide */
    public static boolean isIntValid(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    } // isIntValid

    /* Retourne true ssi le String str est un double valide */
    public static boolean isDoubleValid(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    } // isDoubleValid

    public static boolean pingHost(String host, int port) {
        try {
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(host, port);
            socket.connect(socketAddress, 1000);
            socket.close();
            return true;
        } catch (IOException e) {
            LOG.error(e);
        }
        return false;
    }

} // Validation
