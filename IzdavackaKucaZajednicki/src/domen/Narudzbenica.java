/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author miljan
 */
public class Narudzbenica implements Serializable ,OpstiDomenskiObjekat{
   private int brojNarudzbenice;
   private Date datumKreiranja;
    private ArrayList<StavkaNarudzbenice> listaStavki;
    private Zaposleni sifraZaposlenog;
    private Klijent idKlijenta;
  

    public Zaposleni getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(Zaposleni sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public Klijent getIdKlijenta() {
        return idKlijenta;
    }

    public void setIdKlijenta(Klijent idKlijenta) {
        this.idKlijenta = idKlijenta;
    }

    public int getBrojNarudzbenice() {
        return brojNarudzbenice;
    }

    public void setBrojNarudzbenice(int brojNarudzbenice) {
        this.brojNarudzbenice = brojNarudzbenice;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public ArrayList<StavkaNarudzbenice> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaNarudzbenice> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public Narudzbenica(ArrayList<StavkaNarudzbenice> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public Narudzbenica() {
     listaStavki = new ArrayList<StavkaNarudzbenice>();
    }
    
   @Override
    public String toString(){
        return String.valueOf(brojNarudzbenice);
    }

    @Override
    public String vratiImeTabele() {
      return "TNarudzbenica";
    }

    @Override
    public String vratiVrednostZaInsert() {
        String sDatum = new SimpleDateFormat("dd/MM/yyyy").format(getDatumKreiranja());
     return getBrojNarudzbenice()+",#"+sDatum+"#,"+getSifraZaposlenog().getSifraZaposlenog()+","+getIdKlijenta().getIdKlijenta(); 
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRezultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> la=new ArrayList<>();
       try{
        while(rs.next()){
            int sifra=rs.getInt("SifraNarudzvenice");
            Date datum=rs.getDate("DatumKreiranja");
            int idKlijenta=rs.getInt("IDKlijenta");
            String ime=rs.getString("Ime");
            String prezime=rs.getString("Prezime");
            Klijent k =new Klijent();
            k.setIdKlijenta(idKlijenta);
            k.setIme(ime);
            k.setPrezime(prezime);
            Narudzbenica n=new Narudzbenica();
            n.setBrojNarudzbenice(sifra);
            n.setDatumKreiranja(datum);
            n.setIdKlijenta(k);
            la.add(n);
        }
       }catch(Exception e){
           System.out.println("Greska pri vracanju iz baze");
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
        return "n.SifraNarudzvenice,n.DatumKreiranja,k.IDKlijenta,k.Ime,k.Prezime";
    }

    @Override
    public String vratiUslovZaListuObjekata() {
     return "n.IDKlijenta=k.IDKlijenta";   
    }

    @Override
    public String vratiImeTabeleZaListuObjekata() {
       return "TNarudzbenica n,TKlijent k";
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
