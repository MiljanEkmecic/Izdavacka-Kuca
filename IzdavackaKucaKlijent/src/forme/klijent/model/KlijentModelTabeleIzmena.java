/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.klijent.model;

import domen.Klijent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miljan
 */
public class KlijentModelTabeleIzmena extends AbstractTableModel{
    
      ArrayList<Klijent>listaKlijenata;
    
  public KlijentModelTabeleIzmena(ArrayList<Klijent>lista){
      listaKlijenata=lista;
  }
    @Override
    public int getRowCount() {
       return listaKlijenata.size();
        
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent klijent=listaKlijenata.get(rowIndex);
        switch(columnIndex){
            case 0:return klijent.getIdKlijenta();
            case 1:return klijent.getIme();
            case 2: return klijent.getPrezime();
            case 3: return klijent.getTelefon();
            case 4:return klijent.getJMBG();
            case 5:return klijent.getAdresa();
            default :return "Greska";
        }
    }
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:return "Šifra Klijenta";
            case 1: return "Ime";
            case 2:return "Prezime";
            case 3:return "Telefon";
            case 4:return "JMBG";
            case 5:return "Adresa";
            default :return "Greska";
        }
    }
    @Override
    public void setValueAt(Object aValue,int rowIndex,int columnIndex){
        Klijent klijent=listaKlijenata.get(rowIndex);
        switch(columnIndex){
            case 0: klijent.setIdKlijenta(Integer.parseInt(aValue.toString()));
            case 1: klijent.setIme((String) aValue);
            case 2:klijent.setPrezime((String)aValue);
            case 3:klijent.setTelefon((String)aValue);
            case 4:klijent.setJMBG((String)aValue);
            case 5:klijent.setAdresa((String)aValue);
            
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex){
        return false;
        
    }
    public void obrisiKlijenta(int rb){
        listaKlijenata.remove(rb);
         fireTableDataChanged();
    }
    public void izmeniRed(int rb,Klijent klijent){
        listaKlijenata.remove(rb);
        listaKlijenata.add(rb, klijent);
        fireTableDataChanged();
    }
    
}
