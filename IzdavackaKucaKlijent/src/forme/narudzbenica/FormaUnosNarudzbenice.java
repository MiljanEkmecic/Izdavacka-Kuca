/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.narudzbenica;

import domen.Delo;
import domen.Klijent;
import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import forme.glavna.GlavnaForma;
import forme.narudzbenica.model.NarudzbenicaModelTabele;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class FormaUnosNarudzbenice extends javax.swing.JDialog {
Zaposleni korisnik;
    /**
     * Creates new form FormaUnosNarudzbenice
     */
    public FormaUnosNarudzbenice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediTabelu();
        srediFormu();
    }

    public FormaUnosNarudzbenice(GlavnaForma aThis, boolean b, Zaposleni korisnik) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    korisnik=new Zaposleni();
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
        txtBrojNarudzbenice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDatumKreiranja = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblNarudzbenica = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        btnNovaStavka = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Broj narudzbenice:");

        jLabel2.setText("Datum kreiranja:");

        jLabel3.setText("Klijent:");

        jtblNarudzbenica.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblNarudzbenica);

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnNovaStavka.setText("Nova stavka");
        btnNovaStavka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaStavkaActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSacuvaj)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBrojNarudzbenice)
                            .addComponent(txtDatumKreiranja)
                            .addComponent(cmbKlijent, 0, 163, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnObrisiStavku)
                            .addComponent(btnNovaStavka, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBrojNarudzbenice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumKreiranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovaStavka)
                        .addGap(33, 33, 33)
                        .addComponent(btnObrisiStavku)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnSacuvaj)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
     try{
       NarudzbenicaModelTabele nmt=(NarudzbenicaModelTabele) jtblNarudzbenica.getModel();
       Narudzbenica narudzbenica=nmt.vratiNarudzbenicu();
       
       Zaposleni zaposleni=korisnik;
       Klijent klijent=(Klijent) cmbKlijent.getSelectedItem();
    
       if(txtBrojNarudzbenice.getText().isEmpty()){
           throw new Exception("Morate uneti broj otpremnice");
       }
        int brojNarudzbenice=Integer.parseInt(txtBrojNarudzbenice.getText());
    
        String datumKreiranja=txtDatumKreiranja.getText();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date datum=sdf.parse(txtDatumKreiranja.getText());
        
        narudzbenica.setBrojNarudzbenice(brojNarudzbenice);
        narudzbenica.setDatumKreiranja(datum);
        narudzbenica.setSifraZaposlenog(zaposleni);
        narudzbenica.setIdKlijenta(klijent);
        
        //posalji podatke serveru
        KlijentTransferObjekat kto=new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Sacuvaj_Narudzbenicu);
        kto.setPodaci(narudzbenica);
        ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        out.writeObject(kto);
    
        // primi podatke od servera
        ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
        ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
        JOptionPane.showMessageDialog(this, sto.getPoruka());
    }catch(Exception ex){
        
    }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnNovaStavkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaStavkaActionPerformed
        // TODO add your handling code here:
        NarudzbenicaModelTabele ntm=(NarudzbenicaModelTabele) jtblNarudzbenica.getModel();
        StavkaNarudzbenice stavka=new StavkaNarudzbenice();
        Narudzbenica narudzbenica=ntm.vratiNarudzbenicu();
        stavka.setRb(narudzbenica.getListaStavki().size()+1);
        ntm.dodajRed(stavka);
    }//GEN-LAST:event_btnNovaStavkaActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        int index=jtblNarudzbenica.getSelectedRow();
        NarudzbenicaModelTabele nmt=(NarudzbenicaModelTabele) jtblNarudzbenica.getModel();
        Narudzbenica narudzbenica=nmt.vratiNarudzbenicu();
        if(index==-1){
            JOptionPane.showMessageDialog(this, "Morate selektovati red");
        }
        if(narudzbenica.getListaStavki().size()==0){
            JOptionPane.showMessageDialog(this, "Morate uneti stavku");
        }
        
        nmt.obrisiRed(index);
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

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
            java.util.logging.Logger.getLogger(FormaUnosNarudzbenice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaUnosNarudzbenice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaUnosNarudzbenice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaUnosNarudzbenice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormaUnosNarudzbenice dialog = new FormaUnosNarudzbenice(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNovaStavka;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblNarudzbenica;
    private javax.swing.JTextField txtBrojNarudzbenice;
    private javax.swing.JTextField txtDatumKreiranja;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        Narudzbenica nar=new Narudzbenica();
        NarudzbenicaModelTabele nmt=new NarudzbenicaModelTabele(nar);
        jtblNarudzbenica.setModel(nmt);
        JComboBox cmbDelo=new JComboBox();
        try {
             
            ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
            KlijentTransferObjekat kto=new KlijentTransferObjekat();
            kto.setOperacija(Konstante.Vrati_SvaDela);
            out.writeObject(kto);
            
            ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
            ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
            ArrayList<Delo> listaDela=(ArrayList<Delo>) sto.getPodaci();
            for (Delo delo : listaDela) {
              cmbDelo.addItem(delo);
            }
        } catch (IOException ex) {
            Logger.getLogger(FrmNarudzbenica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmNarudzbenica.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        TableColumnModel tcm=jtblNarudzbenica.getColumnModel();
        TableColumn tc=tcm.getColumn(1);
        tc.setCellEditor(new DefaultCellEditor( cmbDelo));
    }

    private void srediFormu() {
         try {
        ObjectOutputStream out =new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        KlijentTransferObjekat kto=new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Vrati_Klijenta);
        out.writeObject(kto);
        
        ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
        
        ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
        ArrayList<Klijent> listaKlijenata=(ArrayList<Klijent>) sto.getPodaci();
        for (Klijent klijent : listaKlijenata) {
            cmbKlijent.addItem(klijent);
        }
    } catch (IOException ex) {
        Logger.getLogger(FrmNarudzbenica.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmNarudzbenica.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }

