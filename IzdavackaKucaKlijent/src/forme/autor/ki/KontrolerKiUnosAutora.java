/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor.ki;

import domen.Autor;
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
public class KontrolerKiUnosAutora {
    public static void sacuvajAutora(JTextField jtfsifraAutora,JTextField jtfIme,JTextField jtfPrezime,JTextField jtfTelefon,JTextField jtfJmbg,JTextField jtfAdresa, JLabel jlPoruka) {                                         
       try{
        
       int sifraAutora=Integer.valueOf(jtfsifraAutora.getText().trim());
       
           
       String ime=jtfIme.getText().trim();
       if(ime.isEmpty()){
           jlPoruka.setText("Unesite ime autora!");
           throw new Exception("Unesite ime autora");
       }
       else{
           jlPoruka.setText(" ");
       }
       
       String prezime=jtfPrezime.getText().trim();
       if(prezime.isEmpty()){
           jlPoruka.setText("Unesite prezime autora!");
           throw new Exception("Unesite prezime autora");
       }else{
           jlPoruka.setText(" ");
       }
       String telefon=jtfTelefon.getText().trim();
       if(telefon.isEmpty()){
           jlPoruka.setText("Unesite broj telefona!");
           throw new Exception("Niste uneli broj telefona");
       }else{
           jlPoruka.setText(" ");
       }
       
       if(jtfJmbg.getText().length()!=13){
           jlPoruka.setText("Pogresno unet JMBG");
           throw new Exception("JMBG mora imati 13 cifara");
       }else{
         jlPoruka.setText("");
       }
       
       String JMBG=jtfJmbg.getText().trim();
        
       
       String adresa=jtfAdresa.getText().trim();
       if(adresa.isEmpty()){
           jlPoruka.setText("Unesite adresu autora!");
           throw new Exception("Unesite adresu");
       }
      
       
       Autor a=new Autor();
       a.setSifraAutora(sifraAutora);
       a.setImeAutora(ime);
       a.setPrezimeAutora(prezime);
       a.setTelefon(telefon);
       a.setJmbg(JMBG);
       a.setAdresa(adresa);
       
           //posalji podatke serveru
           ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
           KlijentTransferObjekat kto=new KlijentTransferObjekat();
           kto.setOperacija(Konstante.Sacuvaj_Autora);
           kto.setPodaci(a);
           out.writeObject(kto);
           
           //primi podatke od servera
           ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
           ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
           JOptionPane.showMessageDialog(null, sto.getPoruka());
       
       
      
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"Greska",JOptionPane.ERROR_MESSAGE);
       }
}
}