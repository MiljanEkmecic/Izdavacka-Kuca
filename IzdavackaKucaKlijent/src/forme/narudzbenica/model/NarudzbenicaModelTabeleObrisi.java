/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.narudzbenica.model;

import domen.Narudzbenica;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miljan
 */
public class NarudzbenicaModelTabeleObrisi extends AbstractTableModel {
    ArrayList<Narudzbenica>listaNarudzbenica;

    public NarudzbenicaModelTabeleObrisi(ArrayList<Narudzbenica> listaNarudzbenica) {
        this.listaNarudzbenica = listaNarudzbenica;
    }
    
    @Override
    public int getRowCount() {
        return listaNarudzbenica.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Narudzbenica narudzbenica=listaNarudzbenica.get(rowIndex);
        switch(columnIndex){
            case 0:return narudzbenica.getBrojNarudzbenice();
            case 1:return narudzbenica.getDatumKreiranja();
            case 2:return narudzbenica.getIdKlijenta().getIme();
            case 3:return narudzbenica.getIdKlijenta().getPrezime();
            default:return "Greska";
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:return "Broj narudzbenice";
            case 1:return "Datum kreiranja";
            case 2:return "Ime klijenta";
            case 3:return "Prezime klijenta";
            default:return "Greska";
        }
    }
    public void obrisiNarudzbenicu(int rb){
        listaNarudzbenica.remove(rb);
        fireTableDataChanged();
    }
}
