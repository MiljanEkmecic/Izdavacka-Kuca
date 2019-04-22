/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.delo;

import baza.DBKomunikacija;
import domen.Delo;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class VratiSvaDelaSo extends OpstaSo {
    List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
      System.out.println("Nema preduslova");  
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista= DBKomunikacija.vratiObjekat().vratiListuObjekata((Delo)o);
    }
    
}
