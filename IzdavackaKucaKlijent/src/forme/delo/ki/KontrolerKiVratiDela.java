/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.delo.ki;

import domen.Delo;
import forme.delo.FormaObrisiDelo;
import forme.delo.model.DeloModelTabeleObrisi;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class KontrolerKiVratiDela {
    public static void vratiDela(JTable tabela , JComboBox cmbDelo){
        KlijentTransferObjekat kto=new KlijentTransferObjekat();
       kto.setOperacija(Konstante.Vrati_SvaDela);
        try {
            ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
            out.writeObject(kto);
            
            ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
            ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
            ArrayList<Delo> listaDela=(ArrayList<Delo>) sto.getPodaci();
            for (Delo delo : listaDela) {
                cmbDelo.addItem(delo);
            }
            DeloModelTabeleObrisi dmt=new DeloModelTabeleObrisi(listaDela);
            tabela.setModel(dmt);
            
            
        } catch (IOException ex) {
            Logger.getLogger(FormaObrisiDelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaObrisiDelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
