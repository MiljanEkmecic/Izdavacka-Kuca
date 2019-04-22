/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.delo.ki;

import domen.Autor;
import forme.delo.FrmIzmeniDelo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import konstante.Konstante;
import sesija.Sesija;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class KontrolerKiVratiAutoreZaDelo {
    public static void popuniCmb(JComboBox jcmb){
         KlijentTransferObjekat kto=new KlijentTransferObjekat();
        kto.setOperacija(Konstante.Vrati_Autore);
    try {        
        ObjectOutputStream out =new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
        out.writeObject(kto);
        
        ObjectInputStream in =new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
        ServerTransferObjekat sto=(ServerTransferObjekat) in.readObject();
        ArrayList<Autor> lista=(ArrayList<Autor>) sto.getPodaci();
        for (Autor autor : lista) {
           jcmb.addItem(autor);
        }
                
    } catch (IOException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmIzmeniDelo.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }

