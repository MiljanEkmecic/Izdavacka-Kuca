/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author miljan
 */
public interface OpstiDomenskiObjekat  {
    String vratiImeTabele();
    String vratiVrednostZaInsert();
    List<OpstiDomenskiObjekat> vratiListuIzRezultSeta(ResultSet rs);
    String vratiVrednostiZaUpdate();
    String vratiUslovZaIzmenu();
    String vratiUslovZaBrisanje();
    String vratiVrednostiZaListuObjekata();
    String vratiUslovZaListuObjekata();
    String vratiImeTabeleZaListuObjekata();

     String vratiDodatniUslovZaListuObjekata();

    String vratiUslovZaSlozenuListuObjekata();

     String vratiImeTabeleZaSlozenuListuObjekata();

     String vratiVrednostiZaSlozenuListuObjekata();

    public List<OpstiDomenskiObjekat> vratiSlozenuListuIzRezultSeta(ResultSet rs);

    

    

     

    
}
