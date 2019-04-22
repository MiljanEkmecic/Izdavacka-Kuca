/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor.ki;

import domen.Autor;
import forme.autor.FObrisiAutora;
import forme.autor.model.AutorModelTabele;
import forme.autor.model.AutorModelTabeleIzmena;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class KontrolerKiObrisiAutora {
    public static void obrisiAutora(JComboBox cmbAutori, JTable tabela){
        try {
            
            Autor autor=(Autor) cmbAutori.getSelectedItem();
            
            //posalji podatke serveru
            ObjectOutputStream out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
            KlijentTransferObjekat kto=new KlijentTransferObjekat();
            kto.setOperacija(Konstante.Obrisi_Autora);
            kto.setPodaci(autor);
            out.writeObject(kto);
            
            
            //primi podatke od servera
            ObjectInputStream in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
            ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
            
            JOptionPane.showMessageDialog(null, sto.getPoruka());
            AutorModelTabeleIzmena amt=(AutorModelTabeleIzmena) tabela.getModel();
            amt.obrisiAutora(cmbAutori.getSelectedIndex());
            
            //AutorModelTabele amt=(AutorModelTabele) tabela.getModel();
            //amt.obrisiAutora(cmbAutori.getSelectedIndex());
            
            
           // ArrayList<Autor> listaAutora=kontroler.Kontroler.vratiObjekat().vratiAutore();
       // Autor autor=listaAutora.get(jtblAutori.getSelectedRowCount());
       
            
            
       // kontroler.Kontroler.vratiObjekat().izmeniAutora(autor);
        
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FObrisiAutora.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (Exception ex) {
            Logger.getLogger(FObrisiAutora.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    } 
}
