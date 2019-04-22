/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor.model;

import domen.Autor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miljan
 */
public class AutorModelTabele extends AbstractTableModel {
    ArrayList<Autor>listaAutora;
    
  public AutorModelTabele(ArrayList<Autor>lista){
      listaAutora=lista;
  }
    @Override
    public int getRowCount() {
       return listaAutora.size();
        
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor=listaAutora.get(rowIndex);
        switch(columnIndex){
            case 0:return autor.getSifraAutora();
            case 1:return autor.getImeAutora();
            case 2: return autor.getPrezimeAutora();
            case 3: return autor.getTelefon();
            case 4:return autor.getJmbg();
            case 5:return autor.getAdresa();
            default :return "Greska";
        }
    }
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:return "Šifra Autora";
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
        Autor autor=listaAutora.get(rowIndex);
        switch(columnIndex){
            case 0: autor.setSifraAutora(Integer.parseInt(aValue.toString()));
            case 1: autor.setImeAutora((String) aValue);
            case 2:autor.setPrezimeAutora((String)aValue);
            case 3:autor.setTelefon((String)aValue);
            case 4:autor.setJmbg((String)aValue);
            case 5:autor.setAdresa((String)aValue);
            
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex){
        if(columnIndex==0){
        return false;
        }
        return true;
    }
    public void obrisiAutora(int rb){
        listaAutora.remove(rb);
        fireTableDataChanged();
    }
}
