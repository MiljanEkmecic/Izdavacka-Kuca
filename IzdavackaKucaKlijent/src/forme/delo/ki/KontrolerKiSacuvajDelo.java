/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.delo.ki;

import domen.Autor;
import domen.Delo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class KontrolerKiSacuvajDelo {
    public static void sacuvajDelo(JTextField jtfSifra,JTextField jtfNaziv,JTextField jtfCena,JTextField jtfDatum, JComboBox cmbAutor, JLabel jlPoruka){
        
        
        try{
        int sifraDela=Integer.parseInt(jtfSifra.getText());
        Autor autor=(Autor) cmbAutor.getSelectedItem();
        
        String naziv=jtfNaziv.getText();
        if(naziv.isEmpty()){
           jlPoruka.setText("Unesite naziv dela!");
          throw new Exception("Unesite naziv dela");
       }
       else{
           jlPoruka.setText(" ");
       }
        
        String cena=jtfCena.getText();
        if(jtfCena.getText().isEmpty()){
           jlPoruka.setText("Unesite cenu!");
          throw new Exception("Unesite cenu");
       }
       else{
           jlPoruka.setText(" ");
       }
        String datumTxt=jtfDatum.getText();
        Date datum=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        try {
            datum=sdf.parse(datumTxt);
        } catch (Exception ex) {
        
        }
        
        Delo delo=new Delo();
        delo.setSifraDela(sifraDela);
        delo.setNaziv(naziv);
        delo.setCena(Double.parseDouble(cena));
        delo.setDatumPrijema(datum);
        delo.setSifraAutora(autor);
        
        KlijentTransferObjekat kto=new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Sacuvaj_Delo);
        kto.setPodaci(delo);
        
            ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
            out.writeObject(kto);
            
            ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
            ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
            JOptionPane.showMessageDialog(null, sto.getPoruka());
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Greska",JOptionPane.ERROR_MESSAGE);
        }
    }
}
