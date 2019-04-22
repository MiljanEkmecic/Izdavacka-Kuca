/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.narudzbenica.model;

import domen.Autor;
import domen.Delo;
import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miljan
 */
public class NarudzbenicaModelTabele extends AbstractTableModel{
    Narudzbenica narudzbenica;
    @Override
    public int getRowCount() {
        if(narudzbenica==null){
            return 0;
        }
        if(narudzbenica.getListaStavki()==null){
            return 0;
        }
      return   narudzbenica.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaNarudzbenice stavka=narudzbenica.getListaStavki().get(rowIndex);
        switch(columnIndex){
            case 0:return stavka.getRb();
            case 1:return stavka.getDelo();
            
            case 2:return stavka.getCena();
            case 3:return stavka.getKolicina();
            case 4:return stavka.getIznosStavke();
            default :return "Greska";
    }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex , int columnIndex){
       StavkaNarudzbenice stavka=narudzbenica.getListaStavki().get(rowIndex);
       switch(columnIndex){
           case 0: 
               break;
           case 1:stavka.setDelo((Delo) aValue);
           stavka.setCena(stavka.getDelo().getCena());
           stavka.setIznosStavke(stavka.getCena()*stavka.getKolicina());
               break;
           
           case 2:stavka.setCena(Double.parseDouble(aValue.toString()));
           stavka.setIznosStavke(stavka.getCena()*stavka.getKolicina());
               break;
           case 3: stavka.setKolicina(Integer.parseInt(aValue.toString()));
               stavka.setIznosStavke(stavka.getCena()*stavka.getKolicina());
               break;
           case 4:stavka.setIznosStavke(Double.parseDouble(aValue.toString()));
               break;
       }
    }
    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex){
        if(columnIndex==0){
            return false;
        }
        if(columnIndex==4){
            return false;
        }
        return true;
    }
    @Override
    public String getColumnName(int column){
     switch(column){
         case 0:return "RB";
         case 1:return "Delo";
         case 2:return "Cena";
         case 3:return "Kolicina";
         case 4:return "Iznos stavke";
         default:return "Greska"; 
     }   
    }

    public NarudzbenicaModelTabele(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }
    public void dodajRed(StavkaNarudzbenice st){
        narudzbenica.getListaStavki().add(st);
        fireTableDataChanged();
    }
    public Narudzbenica vratiNarudzbenicu(){
        return narudzbenica;
    }
    public void obrisiRed(int i){
        narudzbenica.getListaStavki().remove(i);
        fireTableDataChanged();
    }
}
