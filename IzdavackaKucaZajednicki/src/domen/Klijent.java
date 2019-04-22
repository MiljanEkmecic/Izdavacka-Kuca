/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miljan
 */
public class Klijent implements Serializable, OpstiDomenskiObjekat{
int idKlijenta;
String ime;
String prezime;
String telefon;
String adresa;
String JMBG;

  

    

    public int getIdKlijenta() {
        return idKlijenta;
    }

    public void setIdKlijenta(int idKlijenta) {
        this.idKlijenta = idKlijenta;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }
@Override
public String toString (){
    return ime+" "+prezime;
}

    @Override
    public String vratiImeTabele() {
       return "TKlijent";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return idKlijenta+",'"+ime+"'"+",'"+prezime+"',"+"'"+telefon+"','"+adresa+"','"+JMBG+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRezultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lk=new ArrayList<>();
        try{
            while (rs.next()){
           int idKlijenta= rs.getInt(1);
           String ime=rs.getString(2);
           String prezime=rs.getString(3);
           String telefon=rs.getString(4);
           String adresa=rs.getString(5);
           String jmbg=rs.getString(6);
          Klijent k=new Klijent();
          k.setIdKlijenta(idKlijenta);
          k.setIme(ime);
          k.setPrezime(prezime);
          k.setTelefon(telefon);
          k.setAdresa(adresa);
          k.setJMBG(jmbg);
           lk.add(k);
        }
        }catch(Exception ex){
            
        }
        return lk;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "Ime=" + "'" + ime + "'" + " , Prezime= " + "'" + prezime + "'" + ", "
                    + "Telefon = " + "'" + telefon + "'" + ", Adresa=" + "'" + adresa + "'" +",JMBG=" + "'" +JMBG+"'";
    }

    @Override
    public String vratiUslovZaIzmenu() {
       return "IDKlijenta= " +idKlijenta +" ";
    }

    @Override
    public String vratiUslovZaBrisanje() {
       return "IDKlijenta= " +idKlijenta +" ";
    }

    @Override
    public String vratiVrednostiZaListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeTabeleZaListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiDodatniUslovZaListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSlozenuListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeTabeleZaSlozenuListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaSlozenuListuObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSlozenuListuIzRezultSeta(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
