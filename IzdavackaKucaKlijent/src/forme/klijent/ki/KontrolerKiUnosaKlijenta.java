/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.klijent.ki;

import domen.Klijent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class KontrolerKiUnosaKlijenta {
  public static void sacuvajKlijenta(JTextField jtfSifraAutora,JTextField jtfIme,JTextField jtfPrezime,JTextField jtfTelefon,JTextField jtfAdresa,JTextField jtfJmbg, JLabel jlPoruka){
      try{
          
          int idKlijenta=Integer.valueOf(jtfSifraAutora.getText().trim());
          
          String ime=jtfIme.getText().trim();
          if(ime.isEmpty()){
              jlPoruka.setText("Unesite ime klijenta!");
              throw new Exception("Unesite ime klijenta!");
          }else{
         jlPoruka.setText("");
       }
          
          String prezime=jtfPrezime.getText().trim();
          if(prezime.isEmpty()){
              jlPoruka.setText("Unesite ime prezime!");
              throw new Exception("Unesite prezime klijenta!");
          }else{
         jlPoruka.setText("");
       }
          
          String telefon=jtfTelefon.getText().trim();
          if(telefon.isEmpty()){
              jlPoruka.setText("Unesite telefon klijenta!");
            throw new Exception("Unesite telefon klijenta!");
          }else{
         jlPoruka.setText("");
       }
          
          String adresa=jtfAdresa.getText().trim();
                  if(adresa.isEmpty()){
                      jlPoruka.setText("Unesite adresu klijenta!");
                      throw new Exception("Unesite adresu klijenta!");
                  }else{
         jlPoruka.setText("");
       }
                  
          if(jtfJmbg.getText().length()!=13){
              jlPoruka.setText(" JMBG mora imati 13 cifara");
              throw new Exception("JMBG mora imati 13 cifara");
          }else{
         jlPoruka.setText("");
       }
          
          String jmbg=jtfJmbg.getText().trim();
          
         
          
          Klijent klijent=new Klijent();
          klijent.setIdKlijenta(idKlijenta);
          klijent.setIme(ime);
          klijent.setPrezime(prezime);
          klijent.setTelefon(telefon);
          klijent.setAdresa(adresa);
          klijent.setJMBG(jmbg);
         
          //posalji podatke serveru
          ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
          KlijentTransferObjekat kto=new KlijentTransferObjekat();
          kto.setOperacija(Konstante.Sacuvaj_Klijenta);
          kto.setPodaci(klijent);
          out.writeObject(kto);
          
          //primi podatke od servera
          ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
          ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
          JOptionPane.showMessageDialog(null, sto.getPoruka());
          
         
          }catch(Exception ex){
          JOptionPane.showMessageDialog(null, "Klijent nije uspesno sacuvan");
      }
  }  
}
