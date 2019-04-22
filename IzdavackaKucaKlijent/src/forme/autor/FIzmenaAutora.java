/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor;

import domen.Autor;
import forme.autor.model.AutorModelTabele;
import forme.autor.model.AutorModelTabeleIzmena;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author miljan
 */
public class FIzmenaAutora extends javax.swing.JDialog {

    /**
     * Creates new form FIzmenaAutora
     */
    public FIzmenaAutora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAutori = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtblAutori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblAutori);

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        jLabel1.setText("Izmeni autora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzmeni)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnIzmeni)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
     try{
  //   ArrayList<Autor>listaAutora=kontroler.Kontroler.vratiObjekat().vratiAutore();
     //Autor autor =listaAutora.get(jtblAutori.getSelectedRow());
        
       // autor.setSifraAutora((int) jtblAutori.getValueAt(jtblAutori.getSelectedRow(), 0));
       // autor.setImeAutora((String) jtblAutori.getValueAt(jtblAutori.getSelectedRow(), 1));
      // autor.setPrezimeAutora((String)jtblAutori.getValueAt(jtblAutori.getSelectedRow(), 2));
       // autor.setTelefon((String) jtblAutori.getValueAt(jtblAutori.getSelectedRow(), 3));
       // autor.setJmbg((String) jtblAutori.getValueAt(jtblAutori.getSelectedRow(), 4));
       // autor.setAdresa((String) jtblAutori.getValueAt(jtblAutori.getSelectedRow(), 5));
      
        
        //kontroler.Kontroler.vratiObjekat().izmeniAutora(autor);
        JOptionPane.showMessageDialog(rootPane, "Autor je izmenjen");
     }catch(Exception ex){
         JOptionPane.showMessageDialog(rootPane,"Dogodila se greska");
     }
    }//GEN-LAST:event_btnIzmeniActionPerformed

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
            java.util.logging.Logger.getLogger(FIzmenaAutora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FIzmenaAutora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FIzmenaAutora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FIzmenaAutora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FIzmenaAutora dialog = new FIzmenaAutora(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblAutori;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        try{
        //    ArrayList<Autor> listaAutora=kontroler.Kontroler.vratiObjekat().vratiAutore();
         //   AutorModelTabele amt=new AutorModelTabele(listaAutora);  
       // jtblAutori.setModel(amt);
        
            
    
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"Greska pri vracanju autora");
        }
}
}
