/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autor;

import baza.DBKomunikacija;
import domen.Autor;
import domen.Delo;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class ObrisiAutoraSo extends OpstaSo {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
       System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().obrisiObjekat((Autor)o);
    }
    
}
