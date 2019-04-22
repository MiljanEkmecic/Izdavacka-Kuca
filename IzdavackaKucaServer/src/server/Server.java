/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Autor;
import domen.Delo;
import domen.Klijent;
import domen.Narudzbenica;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import kontroler.Kontroler;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author miljan
 */
public class Server {

    ServerSocket ss;
    Socket soketS;
    ObjectOutputStream outSoket;
    ObjectInputStream inSoket;

    public static void main(String args[]) {
        try {
            new Server().start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void start() throws Exception {
        ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut");
        soketS = ss.accept();
        System.out.println("Klijent se povezao sa serverom");
        opsluziKlijenta(soketS);
    }

    private void opsluziKlijenta(Socket soketS) throws IOException, ClassNotFoundException {


        while (true) {
            inSoket = new ObjectInputStream(soketS.getInputStream());
            outSoket = new ObjectOutputStream(soketS.getOutputStream());

            KlijentTransferObjekat kto = (KlijentTransferObjekat) inSoket.readObject();
            int operacija = kto.getOperacija();

            ServerTransferObjekat sto = new ServerTransferObjekat();

            switch (operacija) {
                case Konstante.Sacuvaj_Autora:
                    try {
                        Kontroler.vratiObjekat().sacuvajAutora((Autor) kto.getPodaci());
                        sto.setSignal(false);
                        sto.setPoruka("Autor je sacuvan");
                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Autor nije sacuvan");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Izmeni_Autora:
                    try {
                        Kontroler.vratiObjekat().izmeniAutora((Autor) kto.getPodaci());
                        sto.setSignal(true);
                        sto.setPoruka("Autor je uspesno izmenjen");
                    } catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Obrisi_Autora:
                    try {
                        Kontroler.vratiObjekat().obrisiAutora((Autor) kto.getPodaci());
                        sto.setSignal(true);
                        sto.setPoruka("Autor je uspesno obrisan");
                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Autor nije obrisan");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Vrati_Autore:
                    try {
                        List<OpstiDomenskiObjekat> listaAutora = Kontroler.vratiObjekat().vratiAutore();
                        sto.setPodaci(listaAutora);
                        sto.setSignal(true);
                        sto.setPoruka("Autori su vraceni");
                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Podaci nisu vraceni");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Sacuvaj_Klijenta:
                    try {
                        Kontroler.vratiObjekat().sacuvajKlijenta((Klijent) kto.getPodaci());
                        sto.setSignal(true);
                        sto.setPoruka("Klijent je uspesno sacuvan");
                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Klijent nije sacuvan");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Vrati_Klijenta:
                    try {
                        List<OpstiDomenskiObjekat> listaKlijenata = Kontroler.vratiObjekat().vratiKlijente();
                        sto.setSignal(true);
                        sto.setPodaci(listaKlijenata);
                        sto.setPoruka("Klijenti su vraceni ");
                    } catch (SQLException ex) {
                        sto.setPoruka("Klijenti nisu vraceni");
                        sto.setSignal(false);
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Obrisi_Klijenta:
                    try {
                        Kontroler.vratiObjekat().obrisiKlijenta((Klijent) kto.getPodaci());
                        sto.setSignal(true);
                        sto.setPoruka("Klijent je uspesno obrisan");
                    } catch (SQLException ex) {

                        sto.setSignal(false);
                        sto.setPoruka("Klijent nije obrisan");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Izmeni_Klijenta:
                    try {
                        Kontroler.vratiObjekat().izmeniKlijenta((Klijent) kto.getPodaci());
                        sto.setSignal(true);
                        sto.setPodaci("Klijent je uspesno izmenjen");

                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Autor nije izmenjen");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }


                case Konstante.Vrati_Delo:
                    try {
                        List<OpstiDomenskiObjekat> lista = Kontroler.vratiObjekat().vratiDelo((Autor) kto.getPodaci());
                        sto.setPodaci(lista);
                        sto.setSignal(true);
                        sto.setPoruka("Dela autora su vracena");
                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Autori nisu vraceni");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Vrati_SvaDela:
                    try {
                        List<OpstiDomenskiObjekat> listaDela = Kontroler.vratiObjekat().vratiSvaDela();
                        sto.setSignal(true);
                        sto.setPodaci(listaDela);
                        sto.setPoruka("Vraceni su klijenti");
                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Klijenti nisu vraceni");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Login:
                    try {
                        List<OpstiDomenskiObjekat> zaposleni = Kontroler.vratiObjekat().vratiKorinika((Zaposleni) kto.getPodaci());
                        sto.setPodaci(zaposleni);
                        sto.setSignal(true);
                        sto.setPoruka("Korisnik je ulogovan");

                    } catch (SQLException ex) {
                        sto.setSignal(false);
                        sto.setPoruka("Korisnik nije ulogovan");
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Konstante.Sacuvaj_Narudzbenicu:
            try {
               
                Kontroler.vratiObjekat().sacuvajNarudzbenicu((Narudzbenica) kto.getPodaci());
                sto.setPoruka("Narudzbenica je sacuvana");
                sto.setSignal(true);
            } catch (SQLException ex) {
                sto.setPoruka("Narudzbenica nije sacuvana");
                sto.setSignal(false);
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case Konstante.Sacuvaj_Delo:
            try {
                Kontroler.vratiObjekat().SacuvajDelo((Delo) kto.getPodaci());
                sto.setSignal(true);
                sto.setPoruka("Delo je uspesno sacuvano");
            } catch (SQLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case Konstante.Obrisi_Delo:
            try {
                Kontroler.vratiObjekat().obrisiDelo((Delo) kto.getPodaci());
                sto.setSignal(true);
                sto.setPoruka("Delo je uspesno obrisano");
            } catch (SQLException ex) {
                sto.setPoruka("Delo nije obrisano");
                sto.setSignal(false);
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case Konstante.Vrati_Narudzbenice:
            try {
                List<OpstiDomenskiObjekat> listaNarudzbenica=Kontroler.vratiObjekat().vratiNarudzbenice();
                sto.setPodaci(listaNarudzbenica);
                sto.setPoruka("Podaci su vraceni");
           } catch (SQLException ex) {
               sto.setPoruka("Podaci nisu vraceni");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                case Konstante.Obrisi_Narudbenicu:
            try {
                Kontroler.vratiObjekat().obrisiNarudzbenicu((Narudzbenica) kto.getPodaci());
                sto.setPoruka("Narudzbenica je uspesno obrisana");
            } catch (SQLException ex) {
                sto.setPoruka("Narudzbenica nije obrisana");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case Konstante.Izmeni_Delo_Autora:
            try {
                Kontroler.vratiObjekat().izmeniDelo((Delo) kto.getPodaci());
                sto.setPoruka("Delo je izmenjeno");
            } catch (SQLException ex) {
                sto.setPoruka("Delo nije izmenjeno");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

            outSoket.writeObject(sto);
        }
    }
}
