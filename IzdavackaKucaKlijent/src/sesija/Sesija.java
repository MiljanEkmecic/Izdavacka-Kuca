/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class Sesija {
    public static Sesija sesija;
    Socket soket;
   
    ObjectOutputStream out;
    ObjectInputStream in;
    
    private Sesija(){             
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
        
    }
    
    public static Sesija dajObjekat(){
        if(sesija==null){
            sesija=new Sesija();
        }
        return sesija;
    }
        
    //upisi
    public void upisiKlijentTransferObjekat(KlijentTransferObjekat kto){
         try {
            out=new ObjectOutputStream(Sesija.dajObjekat().getSoket().getOutputStream());
            out.writeObject(kto);
        } catch (IOException ex) {
            Logger.getLogger(Sesija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //procitaj
    public ServerTransferObjekat vratiServerTransferObjekat(){
       ServerTransferObjekat sto=new ServerTransferObjekat();
        //procitaj
        try {
             in=new ObjectInputStream(Sesija.dajObjekat().getSoket().getInputStream());
             sto=(ServerTransferObjekat) in.readObject();
           
        } catch (IOException ex) {
            Logger.getLogger(Sesija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sesija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sto;
    }
}
