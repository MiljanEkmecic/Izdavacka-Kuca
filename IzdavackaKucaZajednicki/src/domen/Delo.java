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
public class Delo implements Serializable,OpstiDomenskiObjekat{
    private int sifraDela;
    private String naziv;
    private double cena;
    private Date datumPrijema;
    private Autor sifraAutora;

    public int getSifraDela() {
        return sifraDela;
    }

    public void setSifraDela(int sifraDela) {
        this.sifraDela = sifraDela;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatumPrijema() {
        return datumPrijema;
    }

    public void setDatumPrijema(Date datumPrijema) {
        this.datumPrijema = datumPrijema;
    }

    public Autor getSifraAutora() {
        return sifraAutora;
    }

    public void setSifraAutora(Autor sifraAutora) {
        this.sifraAutora = sifraAutora;
    }
    @Override
   public String toString(){
       return naziv;
   }

    @Override
    public String vratiImeTabele() {
       return "TDelo";
    }

    @Override
    public String vratiVrednostZaInsert() {
        
        String datum=new SimpleDateFormat("dd/MM/yyyy").format(datumPrijema);
    return sifraDela+",'"+naziv+"',"+cena+",#"+datum+"#,"+sifraAutora.getSifraAutora()+"";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRezultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> ld=new ArrayList<>();
        try{
             while(rs.next()){
             Delo delo=new Delo();
             Autor a=new Autor();
           delo.setSifraDela(rs.getInt("SifraDela"));
            delo.setNaziv(rs.getString("Naziv"));
            delo.setCena(rs.getDouble("Cena"));
            delo.setDatumPrijema(rs.getDate("DatumPrijema"));
            a.setSifraAutora(rs.getInt("SifraAutora"));
            a.setImeAutora(rs.getString("Ime"));
            a.setPrezimeAutora(rs.getString("Prezime"));
            delo.setSifraAutora(a);
            ld.add(delo);
        }
        
            
        }catch(Exception ex){
            
        }
        return ld;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        String datum=new SimpleDateFormat("dd/MM/yyyy").format(datumPrijema);
         return "Naziv=" + "'" + naziv +"'" + " , Cena= "  + cena + ",DatumPrijema =" +  "#"  +datum+ "#,SifraAutora="+sifraAutora.getSifraAutora()+"";
        //            + "Telefon = " + "'" + telefon + "'" + ", JMBG=" + "'" + jmbg + "'" +",Adresa=" + "'" +adresa+"'";
       // return Naziv=? , Cena=? , DatumPrijema=? , SifraAutora=?
        
    }

    @Override
    public String vratiUslovZaIzmenu() {
       return "SifraDela= " +sifraDela +" ";
    }

    @Override
    public String vratiUslovZaBrisanje() {
         return "SifraDela="+sifraDela+" ";
    }

    @Override
    public String vratiVrednostiZaListuObjekata() {
      return "D.SifraDela,D.Naziv,D.Cena,D.DatumPrijema,A.SifraAutora,A.Ime,A.Prezime";
    }

    @Override
    public String vratiUslovZaListuObjekata() {
       return  "D.SifraAutora=A.SifraAutora";
    }

    @Override
    public String vratiImeTabeleZaListuObjekata() {
     return "TDelo D,TAutor A";  
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
