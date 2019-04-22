/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbenica;

import baza.DBKomunikacija;
import domen.Narudzbenica;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbenice;
import java.util.List;
import so.OpstaSo;

/**
 *
 * @author miljan
 */
public class SacuvajNarudzbenicuSo extends OpstaSo{

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        if (o instanceof StavkaNarudzbenice) {
            DBKomunikacija.vratiObjekat().sacuvaj((OpstiDomenskiObjekat) (o));
           

        } else if (o instanceof Narudzbenica) {
            
            DBKomunikacija.vratiObjekat().sacuvaj((OpstiDomenskiObjekat) (o));
            List<StavkaNarudzbenice> lista = ((Narudzbenica) o).getListaStavki();
            for (StavkaNarudzbenice s : lista) {
                s.setNarudzbenica(((Narudzbenica) o));
                this.proveriPreduslov(s);
                this.izvrsiKonkretnuOperaciju(s);
            }
        }

    }
    
}
