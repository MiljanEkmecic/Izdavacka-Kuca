/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.klijent.ki;

import domen.Klijent;
import forme.klijent.model.KlijentModelTabele;
import forme.klijent.model.KlijentModelTabeleIzmena;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class KontrolerKiObrisiKlijenta {
    public static void obrisiKlijenta(JComboBox cmbKlijenti, JTable tabela){
     
        try{
        //posalji podatke serveru   
        Klijent klijent=(Klijent) cmbKlijenti.getSelectedItem();
        ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        KlijentTransferObjekat kto= new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Obrisi_Klijenta);
        kto.setPodaci(klijent);
        out.writeObject(kto);
        
        //primi podatke od servera
        ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
       ServerTransferObjekat sto= (ServerTransferObjekat) in.readObject();
        
       JOptionPane.showMessageDialog(null, sto.getPoruka());
            KlijentModelTabeleIzmena kmt=(KlijentModelTabeleIzmena) tabela.getModel();
        kmt.obrisiKlijenta(cmbKlijenti.getSelectedIndex());
       
       
        
                
       }catch(Exception ex){
           
       }  
    }
}
