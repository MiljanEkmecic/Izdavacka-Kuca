/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.klijent.ki;

import domen.Klijent;
import forme.klijent.model.KlijentModelTabeleIzmena;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class KontrolerKiVratiKlijente {
    public static void vratiKlijente(JTable tabela , JComboBox cmbKlijenti){
        try{
            //posalji podatke serveru
            ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
            KlijentTransferObjekat kto =new KlijentTransferObjekat();
            kto.setOperacija(Konstante.Vrati_Klijenta);
            out.writeObject(kto);
                    
            //primi podatke od servera
            ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
            ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
            
            ArrayList<Klijent>listaKlijenata=(ArrayList<Klijent>) sto.getPodaci();
            for (Klijent klijent : listaKlijenata) {
                cmbKlijenti.addItem(klijent);
            }
            
            
             KlijentModelTabeleIzmena kmti=new KlijentModelTabeleIzmena(listaKlijenata);
             tabela.setModel(kmti);
        }  catch(Exception ex){
                
            }
    }
}
