/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.delo.model;

import domen.Delo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miljan
 */
public class DeloModelTabeleObrisi extends AbstractTableModel {
    ArrayList<Delo> listaDela;

    public DeloModelTabeleObrisi(ArrayList<Delo> lista) {
        listaDela=lista;
    }
    
    @Override
    public int getRowCount() {
        return listaDela.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
   Delo delo=listaDela.get(rowIndex);
   switch(columnIndex){
       case 0:return delo.getNaziv();
       case 1:return delo.getCena();
       case 2:return delo.getDatumPrijema();
       case 3:return delo.getSifraAutora();
       default :return "Greska";
   }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:return "Naziv";
            case 1:return "Cena";
            case 2:return "Datum";
            case 3:return "Autor";
            default :return "Greska";
        }
    }
    public void obrisiDelo(int rb){
        listaDela.remove(rb);
        fireTableDataChanged();
    }
    public void izmeniRed(int rbTabele,Delo delo){
        listaDela.remove(rbTabele);
        listaDela.add(rbTabele, delo);
        fireTableDataChanged();
    }
}
