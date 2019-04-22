/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import baza.DBKomunikacija;
import domen.Autor;
import domen.Delo;
import domen.Klijent;
import domen.Narudzbenica;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.autor.IzmeniAutoraSo;
import so.autor.ObrisiAutoraSo;
import so.autor.SacuvajAutoraSo;
import so.autor.VratiAutoreSo;
import so.delo.IzmeniDeloSo;
import so.delo.ObrisiDeloSo;
import so.delo.SacuvajDeloSo;
import so.delo.VratiDeloSo;
import so.delo.VratiSvaDelaSo;
import so.klijent.IzmeniKlijentaSo;
import so.klijent.ObrisiKlijentaSo;
import so.klijent.SacuvajKlijentaSo;
import so.klijent.VratiKlijenteSo;
import so.narudzbenica.SacuvajNarudzbenicuSo;
import so.narudzbenica.VratiNarudzbenicuSo;
import zaposleni.so.PronadjiZaposlenogSo;

/**
 *
 * @author miljan
 */
public class Kontroler {
    private DBKomunikacija db;
    private static Kontroler k;
    
    private Kontroler(){
        db=new DBKomunikacija();
    }
   public static Kontroler vratiObjekat(){ 
    if(k==null){
        k=new Kontroler();
        
    }
    return k;
        }
   
   public void sacuvajAutora(Autor autor) throws ClassNotFoundException, SQLException, Exception{
      // db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.sacuvaj(autor);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       SacuvajAutoraSo sa=new SacuvajAutoraSo();
       sa.izvrsiOperaciju(autor);
   }
   public List<OpstiDomenskiObjekat> vratiAutore() throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
       //db.uspostaviKonekciju();
       //List<OpstiDomenskiObjekat> lm = db.vratiSveObjekte(new Autor());
      //ArrayList<Autor> lista= db.vratiAutore();
      //db.commitTransakcije();
      //db.zatvoriTransakciju();
      //return lm;
       
       VratiAutoreSo va=new VratiAutoreSo();
       va.izvrsiOperaciju(new Autor());
             return va.getLista();
   }
   public void izmeniAutora(Autor autor) throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.izmeniObjekat(autor);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       IzmeniAutoraSo ia=new IzmeniAutoraSo();
       ia.izvrsiOperaciju(autor);
   }
   public void obrisiAutora(Autor autor) throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.obrisiObjekat(autor);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       ObrisiAutoraSo oa=new ObrisiAutoraSo();
       oa.izvrsiOperaciju(autor);
   }
   public void sacuvajKlijenta(Klijent klijent) throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.sacuvaj(klijent);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       SacuvajKlijentaSo sk=new SacuvajKlijentaSo();
       sk.izvrsiOperaciju(klijent);
       
   }
   public List<OpstiDomenskiObjekat> vratiKlijente() throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
      // db.uspostaviKonekciju();
       //ArrayList<Klijent> lista=db.vratiKlijente();
      // List<OpstiDomenskiObjekat> lista=db.vratiSveObjekte(new Klijent());
      // db.commitTransakcije();
      //db.zatvoriTransakciju();
      // return lista;
       VratiKlijenteSo vk=new VratiKlijenteSo();
      vk.izvrsiOperaciju(new Klijent());
       return vk.getLista();
   }
   public void obrisiKlijenta(Klijent klijent) throws ClassNotFoundException, SQLException, Exception{
      // db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.obrisiObjekat(klijent);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       ObrisiKlijentaSo ok=new ObrisiKlijentaSo();
       ok.izvrsiOperaciju(klijent);
   }
   public void izmeniKlijenta(Klijent klijent) throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.izmeniObjekat(klijent);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       IzmeniKlijentaSo ik=new IzmeniKlijentaSo();
       ik.izvrsiOperaciju(klijent);
   }
   public List<OpstiDomenskiObjekat> vratiDelo(Autor autor) throws ClassNotFoundException, SQLException, Exception{
      // db.ucitajDriver();
      // db.uspostaviKonekciju();
       //db.commitTransakcije();
      // List<OpstiDomenskiObjekat> lista=db.vratiSlozenuListuObjekata(autor);
      // db.commitTransakcije();
      // db.zatvoriTransakciju();
      // return lista;
       VratiDeloSo vd=new VratiDeloSo();
       vd.izvrsiOperaciju(autor);
       return vd.getLista();
   }
   public List<OpstiDomenskiObjekat> vratiSvaDela() throws ClassNotFoundException, SQLException, Exception{
      // db.ucitajDriver();
    //   db.uspostaviKonekciju();
       //List<Delo> listaDela=db.vratiSvaDela();
     // List<OpstiDomenskiObjekat> listaDela=db.vratiListuObjekata(new Delo());
     // db.commitTransakcije();
    //   db.zatvoriTransakciju();
     // return listaDela;
      
       VratiSvaDelaSo vsd=new VratiSvaDelaSo();
       vsd.izvrsiOperaciju(new Delo());
      return  vsd.getLista();
   }
   public List<OpstiDomenskiObjekat> vratiKorinika(Zaposleni zaposleni) throws ClassNotFoundException, SQLException, Exception{
     //  db.ucitajDriver();
       //db.uspostaviKonekciju();
      // List <OpstiDomenskiObjekat> lista= db.vratiListuObjekata(zaposleni);
     //  db.commitTransakcije();
      // db.zatvoriTransakciju();
     //  return lista;     
       PronadjiZaposlenogSo pz=new PronadjiZaposlenogSo();
       pz.izvrsiOperaciju(zaposleni);
       return pz.getLista();
   }
   public void SacuvajDelo(Delo delo) throws ClassNotFoundException, SQLException, Exception{
      // db.ucitajDriver();
      // db.uspostaviKonekciju();
       //db.sacuvaj(odo);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       
       SacuvajDeloSo sd=new SacuvajDeloSo();
       sd.izvrsiOperaciju(delo);
       
   }
   public void obrisiDelo(Delo delo) throws ClassNotFoundException, SQLException, Exception{
      // db.ucitajDriver();
       //db.uspostaviKonekciju();
       //db.obrisiObjekat(delo);
       //db.commitTransakcije();
       //db.zatvoriTransakciju();
       ObrisiDeloSo od=new ObrisiDeloSo();
       od.izvrsiOperaciju(delo);
   }
   public void sacuvajNarudzbenicu(Narudzbenica narudzbenica) throws ClassNotFoundException, SQLException, Exception{
       //db.ucitajDriver();
       //db.uspostaviKonekciju();
      // db.sacuvaj(narudzbenica);
       //db.commitTransakcije();
      // db.zatvoriTransakciju();
       SacuvajNarudzbenicuSo sn=new SacuvajNarudzbenicuSo();
       sn.izvrsiOperaciju(narudzbenica);
   }
  public List<OpstiDomenskiObjekat> vratiNarudzbenice() throws ClassNotFoundException, SQLException, Exception{
      //db.ucitajDriver();
     // db.uspostaviKonekciju();
      //List<OpstiDomenskiObjekat> lista= db.vratiListuObjekata(new Narudzbenica());
    //  db.commitTransakcije();
    //  db.zatvoriTransakciju();
    //  return lista;
      VratiNarudzbenicuSo vn=new VratiNarudzbenicuSo();
      vn.izvrsiOperaciju(new Narudzbenica());
      return vn.getLista();
   }
  
  public void obrisiNarudzbenicu(Narudzbenica n) throws ClassNotFoundException, SQLException, Exception{
      db.ucitajDriver();
      db.uspostaviKonekciju();
      db.obrisiNarudzbenicu(n);
      db.commitTransakcije();
      db.zatvoriTransakciju();
  }
  
  public void izmeniDelo(Delo d) throws ClassNotFoundException, SQLException, Exception{
     //db.ucitajDriver();
     //db.uspostaviKonekciju();
     //db.izmeniObjekat(d);
     //db.commitTransakcije();
     //db.zatvoriTransakciju();
      IzmeniDeloSo id=new IzmeniDeloSo();
      id.izvrsiOperaciju(d);
  }
  
}
