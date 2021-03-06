/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.delo;

import domen.Autor;
import domen.Delo;
import forme.delo.ki.KontrolerKiVratiAutoreZaDelo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class FrmIzmeniDelo extends javax.swing.JFrame {
Delo d;
    /**
     * Creates new form FrmIzmeniDelo
     */
    

    FrmIzmeniDelo(Delo d) {
        initComponents();
        d=d;
       // srediCmb();
        KontrolerKiVratiAutoreZaDelo.popuniCmb(cmbAutor);
        txtSifra.setText(String.valueOf(d.getSifraDela()));
        txtNaziv.setText(d.getNaziv());
        txtCena.setText(String.valueOf(d.getCena()));
        txtDatumPrijema.setText(String.valueOf(d.getDatumPrijema()));
        
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtCena = new javax.swing.JTextField();
        txtDatumPrijema = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Izmena dela");

        jLabel2.setText("Odaberite autora:");

        jLabel3.setText("Sifra dela:");

        jLabel4.setText("Naziv:");

        jLabel5.setText("Cena:");

        jLabel6.setText("Datum prijema:(yyyy-MM-dd)");

        txtSifra.setEditable(false);
        txtSifra.setBackground(new java.awt.Color(204, 204, 204));

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbAutor, 0, 187, Short.MAX_VALUE)
                            .addComponent(txtSifra)
                            .addComponent(txtNaziv)
                            .addComponent(txtCena)
                            .addComponent(txtDatumPrijema)))
                    .addComponent(btnIzmeni))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDatumPrijema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnIzmeni)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int sifraDela=Integer.valueOf(txtSifra.getText());
        String naziv=txtNaziv.getText();
        double cena=Double.valueOf(txtCena.getText());
        Date datum=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    try {
        datum=sdf.parse(txtDatumPrijema.getText());
    } catch (ParseException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
    }
    Autor a=(Autor) cmbAutor.getSelectedItem();
    Delo d=new Delo();
    d.setSifraDela(sifraDela);
    d.setSifraAutora(a);
    d.setNaziv(naziv);
    d.setCena(cena);
    d.setDatumPrijema(datum);
    
    KlijentTransferObjekat kto=new KlijentTransferObjekat();
    kto.setOperacija(Konstante.Izmeni_Delo_Autora);
    kto.setPodaci(d);
    try {
        ObjectOutputStream out =new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        out.writeObject(kto);
        
        ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
      ServerTransferObjekat sto=  (ServerTransferObjekat) in.readObject();
        JOptionPane.showMessageDialog(this, sto.getPoruka());
    } catch (IOException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(FrmIzmeniDelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIzmeniDelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIzmeniDelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIzmeniDelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JComboBox cmbAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtDatumPrijema;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSifra;
    // End of variables declaration//GEN-END:variables

    private void srediCmb() {
        KlijentTransferObjekat kto=new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Vrati_Autore);
    try {        
        ObjectOutputStream out =new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        out.writeObject(kto);
        
        ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
        ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
        ArrayList<Autor> lista=(ArrayList<Autor>) sto.getPodaci();
        for (Autor autor : lista) {
            cmbAutor.addItem(autor);
        }
                
    } catch (IOException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

 

   
    
}
