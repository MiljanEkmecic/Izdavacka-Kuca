/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.delo;

import baza.DBKomunikacija;
import domen.Delo;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class IzmeniDeloSo extends OpstaSo{

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        DBKomunikacija.vratiObjekat().izmeniObjekat((Delo)o);
    }
    
}
