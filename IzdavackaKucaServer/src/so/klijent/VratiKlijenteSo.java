/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import baza.DBKomunikacija;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class VratiKlijenteSo extends OpstaSo {
List<OpstiDomenskiObjekat> lista;
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
       System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista=DBKomunikacija.vratiObjekat().vratiSveObjekte((Klijent)o);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
