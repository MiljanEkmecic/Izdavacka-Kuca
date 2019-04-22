/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autor;

import baza.DBKomunikacija;
import domen.Autor;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class SacuvajAutoraSo extends OpstaSo{

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
       System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().sacuvaj((Autor)o);
    }
    
}
