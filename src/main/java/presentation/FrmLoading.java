/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package presentation;
import base.ConnexionBase;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import outils.Validation;

public class FrmLoading extends javax.swing.JFrame {

    private static FrmLoading uniqueInstance = null;
    FrmMain frmMain; 
    public String[] ADDRESSES = {"192.168.1.205","ssxtorrenter.ddns.net"};
    public int[] PORTS = {3306,3306};
    /**
     * Creates new form FrmLoading
     */
    public FrmLoading() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();

        setTitle("Chargement, attente du serveur");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label1.setText("Veuillez patienter. Recherche du serveur en cours.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (FrmMain.CONNECTION_ESTABLISHED==false) {
            ConnexionBase.close();
            System.exit(0);
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public static FrmLoading getInstance (FrmMain frmMain) {
        if (uniqueInstance == null) {uniqueInstance = new FrmLoading(); uniqueInstance.frmMain = frmMain;}
        return uniqueInstance;
    }
    
    public void tryConnection(int nbTries){
        if (nbTries < ADDRESSES.length) {
            System.out.print("(" + nbTries + ")Trying on : " + this.ADDRESSES[nbTries] + ":" + this.PORTS[nbTries]);
            if(!getConnection(this.ADDRESSES[nbTries], this.PORTS[nbTries])){
                tryConnection(nbTries+=1);
            }else{
                this.dispose();
            }
        }else{
                System.out.println(" failed, no known addresses left.");
                Object[] options = {"Fermer","Renseigner un serveur"};
                int result = JOptionPane.showOptionDialog(this,"Immpossible de joindre le serveur.\nL'application va maintenant se fermer.\n\nOu renseignez manuellement un serveur.","Erreur",
                       JOptionPane.PLAIN_MESSAGE,
                       JOptionPane.QUESTION_MESSAGE,
                       null,
                       options,
                       options[0]);
                if (result==1) {
                    FrmServer.getInstance(this).setVisible(true);
                }else if (result == JOptionPane.OK_OPTION || result == JOptionPane.CLOSED_OPTION) {
                    System.exit(0);
                }
            }   
    }
    
    public static boolean getConnection(String address, int port){
        FrmMain.setServer(address,port);
        if (Validation.pingHost(address, port)) {
            if (ConnexionBase.get()!=null) {
                System.out.println(" succed.");
                ConnexionBase.close();
                FrmMain.setServer(address, port);
                FrmMain.setConnectionStat(true);
                return true;
            }else{
                System.out.print(" failed, could not connect to server.");
                return false;
            }
        }else{
            System.out.println(" failed, could not ping.");
            return false;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLoading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
