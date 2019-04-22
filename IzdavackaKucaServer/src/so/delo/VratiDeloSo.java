/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.delo;

import baza.DBKomunikacija;
import domen.Autor;
import domen.Delo;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class VratiDeloSo extends OpstaSo{
    List<OpstiDomenskiObjekat>lista;
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        lista= DBKomunikacija.vratiObjekat().vratiSlozenuListuObjekata((Autor)o);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
