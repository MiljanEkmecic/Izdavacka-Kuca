/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor.ki;

import domen.Autor;
import forme.autor.model.AutorModelTabeleIzmena;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class KontrolerKiVratiAutora {
   public static void vratiAutore(JTable tabela, JComboBox cmbAutori) {
        try{
           //posalji podatke serveru
          
          
           KlijentTransferObjekat kto=new KlijentTransferObjekat();
           kto.setOperacija(Konstante.Vrati_Autore);
            ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
           out.writeObject(kto);
           
           
           //primi podakte od servera
           ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
           
           ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
           
           
        ArrayList<Autor> listaAutora=(ArrayList<Autor>) sto.getPodaci();
           for (Autor autor : listaAutora) {
               cmbAutori.addItem(autor);
           }
           
            AutorModelTabeleIzmena amt=new AutorModelTabeleIzmena(listaAutora);
           tabela.setModel(amt);
        
          
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "doslo je do greske");
    }
    }
}
