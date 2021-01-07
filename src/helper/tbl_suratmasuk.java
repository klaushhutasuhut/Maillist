/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Klaus
 */
public class tbl_suratmasuk extends AbstractTableModel{
    private List<List_suratmasuk> list = new ArrayList<>();     
    public void setList(List<List_suratmasuk> list){
    this.list = list;     
    } 
    List<List_suratmasuk> data;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public tbl_suratmasuk(List<List_suratmasuk> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 8;
    }
    
    @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getNo_urut();
            case 1:
                return data.get(rowIndex).getJenis_surat();
            case 2:
                return data.get(rowIndex).getAsal_surat();
            case 3:
                return data.get(rowIndex).getTanggal_surat();
            case 4:
                return data.get(rowIndex).getNo_surat();
            case 5:
                return data.get(rowIndex).getPerihal();
            case 6:
                return data.get(rowIndex).getTanggal_terima();
            case 7:
                return data.get(rowIndex).getNo_agenda();
            default:
                return null;
        }
    }
     
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Urut";
            case 1:
                return "Jenis Surat";
            case 2:
                return "Asal Surat";
            case 3:
                return "Tanggal Surat";
            case 4:
                return "Nomor Surat";
            case 5:
                return "Perihal";
            case 6:
                return "Tanggal Diterima";
            case 7:
                return "No Agenda";
            default:
                return null;
        }
    }
}
