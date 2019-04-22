/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import baza.DBKomunikacija;

/**
 *
 * @author miljan
 */
public abstract class OpstaSo {
    
     public final void izvrsiOperaciju(Object o) throws Exception{
        try{
            DBKomunikacija.vratiObjekat().ucitajDriver();
            DBKomunikacija.vratiObjekat().uspostaviKonekciju();
            
            proveriPreduslov(o);
            izvrsiKonkretnuOperaciju(o);
            
            DBKomunikacija.vratiObjekat().commitTransakcije();
        }catch(Exception e){
            DBKomunikacija.vratiObjekat().rollbackTransakcije();
            throw e;
        }
        finally{
            DBKomunikacija.vratiObjekat().zatvoriTransakciju();
        }
    }

    protected abstract void proveriPreduslov(Object o) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object o) throws Exception;


    
}
