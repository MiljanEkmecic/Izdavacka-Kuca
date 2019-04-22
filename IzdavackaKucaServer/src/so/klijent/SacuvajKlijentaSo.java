/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import baza.DBKomunikacija;
import domen.Klijent;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class SacuvajKlijentaSo extends OpstaSo{

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().sacuvaj((Klijent)o);
    }
    
}
