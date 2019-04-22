/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import forme.glavna.GlavnaForma;
import forme.login.FrmLogin;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sesija.Sesija;

/**
 *
 * @author miljan
 */
public class Klijent {
    public static void main(String args[]){
        try {
            Socket soketK=new Socket("127.0.0.1", 9000);
            System.out.println("Klijent je pokrenut");
            Sesija.dajObjekat().setSoket(soketK);
            FrmLogin forma=new FrmLogin();
            forma.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
