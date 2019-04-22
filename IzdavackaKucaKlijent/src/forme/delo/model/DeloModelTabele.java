/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.delo.model;

import domen.Delo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miljan
 */
public class DeloModelTabele extends AbstractTableModel {
    ArrayList<Delo> listaDela;
    public DeloModelTabele(ArrayList<Delo> lista){
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
            case 0:return delo.getSifraDela();
            case 1:return delo.getNaziv();
            case 2:return delo.getCena();
            case 3:return delo.getDatumPrijema();
            default:return "greska";
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:return "Sifra Dela";
            case 1:return "Naziv";
            case 2:return "Cena";
            case 3:return "Datum prijema";
            default:return "greska";
        }
    }
}
