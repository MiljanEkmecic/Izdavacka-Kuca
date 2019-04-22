/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.klijent.ki;

import domen.Klijent;
import forme.klijent.model.KlijentModelTabeleIzmena;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class KontrolerKiIzmeniKlijenta {
    public static void izmeniKlijenta(JTextField jtfSifra,JTextField jtfIme,JTextField jtfPrezime,JTextField jtfTelefon,JTextField jtfJmbg,JTextField jtfAdresa, JTable tabela, JComboBox cmbKlijenti){
        try{
        int sifraKlijenta=Integer.parseInt(jtfSifra.getText());
        String ime=jtfIme.getText();
        String prezime=jtfPrezime.getText();
        String telefon=jtfTelefon.getText();
        String jmbg=jtfJmbg.getText();
        String adresa=jtfAdresa.getText();
        
        Klijent klijent=new Klijent();
        klijent.setIdKlijenta(sifraKlijenta);
        klijent.setIme(ime);
        klijent.setPrezime(prezime);
        klijent.setTelefon(telefon);
        klijent.setJMBG(jmbg);
        klijent.setAdresa(adresa);
        
        //poslji podatke serveru
        ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        KlijentTransferObjekat kto=new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Izmeni_Klijenta);
        kto.setPodaci(klijent);
        out.writeObject(kto);
        
        //primi podatke od servera
        ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
        ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
        JOptionPane.showMessageDialog(null, sto.getPodaci());
        
        KlijentModelTabeleIzmena kmti=(KlijentModelTabeleIzmena) tabela.getModel();
        kmti.izmeniRed(cmbKlijenti.getSelectedIndex(), klijent);
          
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Doslo je od greske pri izmeni klijenta");
        }  
        
    }                                        

  
}
