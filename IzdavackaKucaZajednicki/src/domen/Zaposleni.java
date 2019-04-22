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
public class Zaposleni implements Serializable, OpstiDomenskiObjekat{
    private int sifraZaposlenog;
    private String ime;
    private String prezime;
    private String telefon;
    private String korisnickoIme;
    private String lozinka;

    public int getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(int sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String vratiImeTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRezultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> la=new ArrayList<>();
        Zaposleni z=new Zaposleni();
        try{
        while(rs.next()){
            int sifra=rs.getInt(1);
            String ime =rs.getString(2);
            String prezime=rs.getString(3);
            String telefon=rs.getString(4);
            String korisnikoIme=rs.getString(5);
            String lozinka=rs.getString(6);
            z.setSifraZaposlenog(sifra);
            z.setIme(ime);
            z.setPrezime(prezime);
            z.setTelefon(telefon);
            z.setKorisnickoIme(korisnikoIme);
            z.setLozinka(lozinka);
            la.add(z);
        }
        }catch(Exception ex){
            
        }
        return la;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaListuObjekata() {
        return "*";
    }

    @Override
    public String vratiUslovZaListuObjekata() {
      return "KorisnickoIme='"+korisnickoIme+"' AND Lozinka='"+lozinka+"'";
    }

    @Override
    public String vratiImeTabeleZaListuObjekata() {
      return "TZaposleni" ; 
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
