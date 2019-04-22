/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor.ki;

import domen.Autor;
import forme.autor.model.AutorModelTabeleIzmena;
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
public class KontrolerKiIzmeniAutora {
    public static void izmeniAutora(JTextField jtfSifra,JTextField jtfIme,JTextField jtfPrezime,JTextField jtfTelefon,JTextField jtfJmbg,JTextField jtfAdresa , JTable tabela, JComboBox cmbAutori){
        try{
        int sifra=Integer.parseInt(jtfSifra.getText());
        String ime =jtfIme.getText();
        String prezime=jtfPrezime.getText();
        String telefon=jtfTelefon.getText();
        String jmbg=jtfJmbg.getText();
        String adresa=jtfAdresa.getText();
        
        Autor autor=new Autor();
        autor.setSifraAutora(sifra);
        autor.setImeAutora(ime);
        autor.setPrezimeAutora(prezime);
        autor.setTelefon(telefon);
        autor.setJmbg(jmbg);
        autor.setAdresa(adresa);
        
        //posalji podatke serveru
           ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
           KlijentTransferObjekat kto=new KlijentTransferObjekat();
           kto.setOperacija(Konstante.Izmeni_Autora);
           kto.setPodaci(autor);
           out.writeObject(kto);
           
           
           //primi podatke sa servera
           ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
           ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
           JOptionPane.showMessageDialog(null, sto.getPoruka());
       
        
           AutorModelTabeleIzmena amt=(AutorModelTabeleIzmena) tabela.getModel();
           amt.izmeniRed(cmbAutori.getSelectedIndex(), autor);
       
    
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Greska pri izmeni autora");
        }           
    }
}
