/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Autor;
import domen.Delo;
import domen.Klijent;
import domen.Narudzbenica;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author miljan
 */
public class DBKomunikacija {
    Connection konekcija;
     private static DBKomunikacija objekat;
    
     public static DBKomunikacija vratiObjekat() throws FileNotFoundException, IOException {
        if (objekat == null) {
            objekat = new DBKomunikacija();
        }
        return objekat;
    }
    public void ucitajDriver() throws ClassNotFoundException{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    }
    
    
    public void uspostaviKonekciju() throws SQLException{
        konekcija=DriverManager.getConnection("jdbc:odbc:bazaIzKuca");
        konekcija.setAutoCommit(false);
        
    }
    public void commitTransakcije()throws Exception{
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollbackTransakcije() throws Exception{
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void zatvoriTransakciju() throws SQLException{
        konekcija.close();
    }
    
   
  
    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "INSERT INTO " + odo.vratiImeTabele() + " VALUES " + "(" + odo.vratiVrednostZaInsert() + ")";
        System.out.println(sql);
        Statement sqlNaredba=konekcija.createStatement();
        sqlNaredba.executeUpdate(sql);
        sqlNaredba.close();
    }
     // public void SacuvajAutora(Autor autor) throws SQLException{
     //   String sql="INSERT INTO TAutor VALUES(?,?,?,?,?,?)";
     //   PreparedStatement ps=konekcija.prepareStatement(sql);
    //   ps.setInt(1, vratiMaxSifraAutora());
     //  ps.setString(2, autor.getImeAutora());
    //   ps.setString(3, autor.getPrezimeAutora());
     //  ps.setString(4, autor.getTelefon());
     //  ps.setString(5, autor.getJmbg());
     //  ps.setString(6, autor.getAdresa());
     //  ps.executeUpdate();
      // ps.close();
   // }
  //  public int vratiMaxSifraAutora() throws SQLException{
      //  String sql="SELECT MAX (SifraAutora) AS AMAX FROM TAutor";
      //  Statement st=konekcija.createStatement();
     //   ResultSet rs=st.executeQuery(sql);
   //    int sifra=0;
   //     while(rs.next()){
    //        sifra=rs.getInt("AMAX")+1;   
    //    }
   //     return sifra;
    
   // }
   /*     String sql="INSERT INTO TKlijent VALUES(?,?,?,?,?,?)";
        PreparedStatement st=konekcija.prepareStatement(sql);
        st.setInt(1, vratiMaxSifraKlijenta());
        st.setString(2, klijent.getIme());
        st.setString(3, klijent.getPrezime());
        st.setString(4, klijent.getTelefon());
        st.setString(5, klijent.getAdresa());
        st.setString(6, klijent.getJMBG());
        st.executeUpdate();
        st.close();
    }
    public int vratiMaxSifraKlijenta() throws SQLException{
        String sql="SELECT MAX(IDKlijenta) AS KMAX FROM TKlijent";
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
        int broj=0;
        while(rs.next()){
          broj=rs.getInt("KMAX")+1;
        }
        return broj;
    }
    * 
    * 
    * public void SacuvajDelo(Delo delo) throws SQLException{
        String datum=new SimpleDateFormat("dd/MM/yyyy").format(delo.getDatumPrijema());
        String sql="INSERT INTO TDelo VALUES("+vratiMaxSifruDela()+",'"+delo.getNaziv()+"',"+delo.getCena()+",#"+datum+"#,"+delo.getSifraAutora().getSifraAutora()+")";
       
        
        Statement st=konekcija.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        st.executeUpdate(sql);
        
        
    }
   */ 
    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws SQLException{
         String sql="SELECT * FROM "+odo.vratiImeTabele();
        Statement sqlNaredba=konekcija.createStatement();
        ResultSet rs=sqlNaredba.executeQuery(sql);
        
        return odo.vratiListuIzRezultSeta(rs);
        
    }
    public List<OpstiDomenskiObjekat> vratiListuObjekata(OpstiDomenskiObjekat odo) throws SQLException{
        //String sql="SELECT D.SifraDela,D.Naziv,D.Cena,D.DatumPrijema,A.SifraAutora,A.Ime,A.Prezime FROM TDelo D,TAutor A WHERE D.SifraAutora=A.SifraAutora";
        
        String sql = "SELECT " + odo.vratiVrednostiZaListuObjekata() + " FROM " + odo.vratiImeTabeleZaListuObjekata() + " WHERE " + odo.vratiUslovZaListuObjekata();
         Statement sqlNaredba=konekcija.createStatement();
        ResultSet rs=sqlNaredba.executeQuery(sql);
        
        return odo.vratiListuIzRezultSeta(rs);
        
        
        
    }
    
   /* public ArrayList<Delo> vratiSvaDela() throws SQLException{
        ArrayList<Delo> listaDela=new ArrayList<Delo>();
        String sql="SELECT * FROM TDelo d INNER JOIN TAutor a ON d.SifraAutora=a.SifraAutora ";
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
       
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
            listaDela.add(delo);
        }
        return listaDela;
    }
   /* 
    */ 
   /* 
    * 
    * 
    * public ArrayList<Autor> vratiAutore() throws Exception{
        ArrayList<Autor> listaAutora=new ArrayList<Autor>();
       try{
        String sql="SELECT * FROM TAutor";
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
            int sifraAutora=rs.getInt(1);
            String ime=rs.getString(2);
            String prezime=rs.getString(3);
            String telefon=rs.getString(4);
            String JMBG=rs.getString(5);
            String adresa=rs.getString(6);
           Autor autor=new Autor(sifraAutora, ime, prezime, telefon, JMBG, adresa);
         
           /*
           a.setSifraAutora(sifraAutora);
           a.setImeAutora(ime);
           a.setPrezimeAutora(prezime);
           a.setTelefon(telefon);
           a.setJmbg(JMBG);
           a.setAdresa(adresa);
           */ 
    /*
            listaAutora.add(autor);
        }
       }catch(Exception ex){
             ex.printStackTrace();
            throw new Exception("Greska pri ucitavanju mesta!");
       }
        return listaAutora;
        }
    */
    /* public ArrayList<Klijent> vratiKlijente(){
        ArrayList<Klijent>listaKlijenata=new ArrayList<>();
        try{
        String sql="SELECT * FROM TKlijent";
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
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
           listaKlijenata.add(k);
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Doslo je do greske");
            
        }
        return listaKlijenata;
    }
    */ 
    
    
  /*  public ArrayList<Narudzbenica> vratiNarudzbenice() throws SQLException{
        ArrayList<Narudzbenica> listaNarudzbenica=new ArrayList<Narudzbenica>();
        //String sql="SELECT N.SifraNarudzvenice,N.DatumKreiranja,N.IDKlijenta,K.Ime,K.Prezime FROM TNarudzbenica N,TKlijent K WHERE N.IDKlijenta=K.IDKlijenta ";
      String sql="SELECT n.SifraNarudzvenice,n.DatumKreiranja,k.IDKlijenta,k.Ime,k.Prezime FROM TNarudzbenica n INNER JOIN TKlijent k ON n.IDKlijenta=k.IDKlijenta";
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
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
            listaNarudzbenica.add(n);
        }
        return listaNarudzbenica;
              
    }
    */ 
    public void izmeniObjekat(OpstiDomenskiObjekat odo) throws SQLException{
       String upit1 = "UPDATE "+odo.vratiImeTabele()+" SET "+odo.vratiVrednostiZaUpdate()+""
                        + " WHERE "+odo.vratiUslovZaIzmenu()+";";
                PreparedStatement sqlNaredba = konekcija.prepareStatement(upit1);
                sqlNaredba.executeUpdate();
                sqlNaredba.close();
                         
    }
     public List<OpstiDomenskiObjekat> vratiSlozenuListuObjekata(OpstiDomenskiObjekat odo) throws SQLException{
       // String sql="SELECT D.SifraDela,D.Naziv,D.Cena,D.DatumPrijema,A.SifraAutora,A.Ime,A.Prezime FROM TDelo D,TAutor A WHERE D.SifraAutora=A.SifraAutora";
        
        String sql = "SELECT " + odo.vratiVrednostiZaSlozenuListuObjekata() + " FROM " + odo.vratiImeTabeleZaSlozenuListuObjekata() + " ON "+odo.vratiUslovZaSlozenuListuObjekata()+" WHERE " + odo.vratiDodatniUslovZaListuObjekata();
         Statement sqlNaredba=konekcija.createStatement();
        ResultSet rs=sqlNaredba.executeQuery(sql);
        
        return odo.vratiSlozenuListuIzRezultSeta(rs);
        
        
        
    }
     /*public ArrayList<Delo> vratiDelo(Autor autor) throws SQLException{
      ArrayList<Delo> lista=new ArrayList<Delo>();
        String sql="SELECT *FROM TDelo  WHERE SifraAutora="+autor.getSifraAutora();
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
            int sifraDela=rs.getInt("SifraDela");
            String naziv=rs.getString("Naziv");
            double cena=rs.getDouble("Cena");
            Date datum=rs.getDate("DatumPrijema");
            int sifraAutora=rs.getInt("SifraAutora");
            Autor a=new Autor();
            a.setSifraAutora(sifraAutora);
            
            Delo d=new Delo();
            d.setSifraDela(sifraDela);
            d.setNaziv(naziv);
            d.setCena(cena);
            d.setDatumPrijema(datum);
            d.setSifraAutora(autor);
            lista.add(d);
        }
        return lista;
    }     
    */
    /*
    public void izmeniAutora(Autor autor) throws SQLException{
        String sql="UPDATE TAutor SET  Ime=? , Prezime=? , Telefon=? , JMBG=? , Adresa=? WHERE SifraAutora=? " ;
    PreparedStatement ps=konekcija.prepareStatement(sql);
    
    ps.setString(1, autor.getImeAutora());
    ps.setString(2, autor.getPrezimeAutora());
    ps.setString(3, autor.getTelefon());
    ps.setString(4, autor.getJmbg());
    ps.setString(5, autor.getAdresa());
    ps.setInt(6, autor.getSifraAutora());
    
    ps.executeUpdate();
   
    }
    */ 
    /*
      public void izmeniKlijenta(Klijent klijent) throws SQLException{
      String sql="UPDATE TKlijent SET Ime=?,Prezime=?,Telefon=?,Adresa=?,JMBG=? WHERE IDKlijenta=?"; 
        PreparedStatement ps=konekcija.prepareStatement(sql);
        ps.setString(1, klijent.getIme());
        ps.setString(2,klijent.getPrezime());
        ps.setString(3, klijent.getTelefon());
        ps.setString(4, klijent.getAdresa());
        ps.setString(5, klijent.getJMBG());
        ps.setInt(6, klijent.getIdKlijenta());
        ps.executeUpdate();
        
    
        
}
      
    public void izmeniKlijenta(Klijent klijent) throws SQLException{
      String sql="UPDATE TKlijent SET Ime=?,Prezime=?,Telefon=?,Adresa=?,JMBG=? WHERE IDKlijenta=?"; 
        PreparedStatement ps=konekcija.prepareStatement(sql);
        ps.setString(1, klijent.getIme());
        ps.setString(2,klijent.getPrezime());
        ps.setString(3, klijent.getTelefon());
        ps.setString(4, klijent.getAdresa());
        ps.setString(5, klijent.getJMBG());
        ps.setInt(6, klijent.getIdKlijenta());
        ps.executeUpdate();
         
    
        
    public void obrisiAutora(Autor autor) throws SQLException{
        String sql="DELETE FROM TAutor  WHERE SifraAutora=?";
        PreparedStatement ps=konekcija.prepareStatement(sql);
        ps.setInt(1, autor.getSifraAutora());
        ps.executeUpdate();
    }
     public void izmeniDelo(Delo delo) throws SQLException{
           String sql="UPDATE TDelo SET  Naziv=? , Cena=? , DatumPrijema=? , SifraAutora=? WHERE SifraDela=?" ;
           PreparedStatement ps=konekcija.prepareStatement(sql);
           ps.setString(1, delo.getNaziv());
           ps.setDouble(2, delo.getCena());
           ps.setDate(3, new java.sql.Date(delo.getDatumPrijema().getTime()));
           ps.setInt(4, delo.getSifraAutora().getSifraAutora());
           ps.setInt(5, delo.getSifraDela());
           ps.executeUpdate();
           
           
      }
   */
   
    public void obrisiObjekat(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "DELETE FROM "+odo.vratiImeTabele()+" WHERE "+odo.vratiUslovZaBrisanje()+";";
                PreparedStatement sqlNaredba = konekcija.prepareStatement(upit);
                sqlNaredba.executeUpdate();
                sqlNaredba.close();
        
    }
    
    /*  public void obrisiKlijenta(Klijent klijent) throws SQLException{
   String sql="DELETE FROM TKlijent WHERE IDKlijenta=?";
   PreparedStatement ps=konekcija.prepareStatement(sql);
   ps.setInt(1, klijent.getIdKlijenta());
   ps.executeUpdate();
    }
    * 
    *  
    public void obrisiDelo(Delo delo) throws SQLException{
         String sql="DELETE FROM TDelo WHERE SifraDela="+delo.getSifraDela();
         PreparedStatement ps=konekcija.prepareStatement(sql);
         ps.executeUpdate();
     }
      
    * 
    */ 
    
  
   
   
   
   /* public Zaposleni vratiKorisnika(Zaposleni zaposleni) throws SQLException{
        
        String sql="SELECT * FROM TZaposleni WHERE KorisnickoIme='"+zaposleni.getKorisnickoIme()+"' AND Lozinka='"+zaposleni.getLozinka()+"'";
        Statement st=konekcija.createStatement();
        ResultSet rs=st.executeQuery(sql);
        Zaposleni korisnik=new Zaposleni();
        while(rs.next()){
            int sifra=rs.getInt(1);
            String ime =rs.getString(2);
            String prezime=rs.getString(3);
            String telefon=rs.getString(4);
            String korisnikoIme=rs.getString(5);
            String lozinka=rs.getString(6);
            korisnik.setSifraZaposlenog(sifra);
            korisnik.setIme(ime);
            korisnik.setPrezime(prezime);
            korisnik.setTelefon(telefon);
            korisnik.setKorisnickoIme(korisnikoIme);
            korisnik.setLozinka(lozinka);
        }
        return korisnik;
    }
   */ 
    /*
     public int  vratiMaxSifruDela() throws SQLException{
            String sql="SELECT MAX(SifraDela) AS DMAX FROM TDelo";
            Statement st=konekcija.createStatement();
            ResultSet rs= st.executeQuery(sql);
            int broj=0;
            while(rs.next()){
                broj=rs.getInt("DMAX")+1;
            }
            return broj;
           
            
        }
  */  
   /*
     public void sacuvajSlozeniObjekat(OpstiDomenskiObjekat odo,OpstiDomenskiObjekat st) throws Exception {
        try {
            String sql = "INSERT into " + odo.vratiImeTabele() + " VALUES (" + odo.vratiVrednostZaInsert() + ")";
            Statement sqlNaredba = konekcija.createStatement();
            sqlNaredba.executeUpdate(sql);
            Narudzbenica nar=(Narudzbenica) odo;
            ArrayList<StavkaNarudzbenice> lista=nar.getListaStavki();
            String sqlStavka="INSERT into"+st.vratiImeTabeleSlabogObjekta()+ "VALUES ("+st.vratiVrednostiZaInsertSlabogObjekta()+")";
            PreparedStatement prepStat=konekcija.prepareStatement(sqlStavka);
            for (StavkaNarudzbenice stavkaNarudzbenice : lista) {
                prepStat.executeUpdate();
            }
            
        } catch (SQLException ex) {
            throw new Exception("Greška pri čuvanju u tabeli "+odo.vratiImeTabele());
        }
    }
    */
   
    
     public void obrisiNarudzbenicu(Narudzbenica nar) throws SQLException{
        String sql="DELETE FROM TNarudzbenica  WHERE SifraNarudzvenice="+nar.getBrojNarudzbenice();
        PreparedStatement ps=konekcija.prepareStatement(sql);
        ArrayList<StavkaNarudzbenice> lista=nar.getListaStavki();
        
        //String sql1="DELETE FROM TStavkaNarudzbenice WHERE RedniBrojStavke="+nar.getBrojNarudzbenice();
        //PreparedStatement ps2=konekcija.prepareStatement(sql1);
        ps.executeUpdate();
        //ps2.executeUpdate();
    
}
    
     
}