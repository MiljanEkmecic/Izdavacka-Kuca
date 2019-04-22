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
public class Autor implements Serializable ,OpstiDomenskiObjekat{
    private int sifraAutora;
    private String imeAutora;
    private String prezimeAutora;
    private String telefon;
    private String adresa;
    private String jmbg;

    public Autor(int sifraAutora, String ime, String prezime, String telefon, String JMBG, String adresa) {
       this.sifraAutora=sifraAutora;
       this.imeAutora=ime;
       this.prezimeAutora=prezime;
       this.telefon=telefon;
       this.jmbg=JMBG;
       this.adresa=adresa;
    }

    public Autor() {
       
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
    }

    public int getSifraAutora() {
        return sifraAutora;
    }

    public void setSifraAutora(int sifraAutora) {
        this.sifraAutora = sifraAutora;
    }

    public String getPrezimeAutora() {
        return prezimeAutora;
    }

    public void setPrezimeAutora(String prezimeAutora) {
        this.prezimeAutora = prezimeAutora;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    @Override
    public String toString(){
        return imeAutora+" "+prezimeAutora;
    }

    @Override
    public String vratiImeTabele() {
        return "TAutor";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return sifraAutora+",'"+imeAutora+"'"+",'"+prezimeAutora+"',"+"'"+telefon+"','"+jmbg+"','"+adresa+"'";
       // return getIdKupca() + "," + "'" + getImeKupca() + "', '" + getPrezimeKupca() + "', '" + getAdresaKupca() + "', '" + getGradKupca() + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRezultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> la=new ArrayList<>();
        try{
            while(rs.next()){
                int sifraAutora=rs.getInt(1);
            String ime=rs.getString(2);
            String prezime=rs.getString(3);
            String telefon=rs.getString(4);
            String JMBG=rs.getString(5);
            String adresa=rs.getString(6);
           Autor autor=new Autor(sifraAutora, ime, prezime, telefon, JMBG, adresa); 
           la.add(autor);
            }
            
        }catch(Exception ex){
                
    }
        return la;
}

    @Override
    public String vratiVrednostiZaUpdate() {
          return "Ime=" + "'" + imeAutora + "'" + " , Prezime= " + "'" + prezimeAutora + "'" + ", "
                    + "Telefon = " + "'" + telefon + "'" + ", JMBG=" + "'" + jmbg + "'" +",Adresa=" + "'" +adresa+"'";
   
    }

    @Override
    public String vratiUslovZaIzmenu() {
        return "SifraAutora= " +sifraAutora +" ";
    }

    @Override
    public String vratiUslovZaBrisanje() {
       return "SifraAutora="+sifraAutora+" ";
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
        return "D.SifraAutora="+getSifraAutora();
    }

    @Override
    public String vratiUslovZaSlozenuListuObjekata() {
        return  "D.SifraAutora=A.SifraAutora";
    }

    @Override
    public String vratiImeTabeleZaSlozenuListuObjekata() {
        return "TDelo D INNER JOIN TAutor A";  
    }

    @Override
    public String vratiVrednostiZaSlozenuListuObjekata() {
         return "D.SifraDela,D.Naziv,D.Cena,D.DatumPrijema,A.SifraAutora,A.Ime,A.Prezime";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSlozenuListuIzRezultSeta(ResultSet rs) {
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
            System.out.println("Greska pri vracanju iz baze");
        }
        return ld;
    
    }

  
}