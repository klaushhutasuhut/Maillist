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
public class tbl_suratkeluar extends AbstractTableModel{
    
    private List<List_suratkeluar> list = new ArrayList<>();     
    public void setList(List<List_suratkeluar> list){
    this.list = list;     
    } 
    List<List_suratkeluar> data;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public tbl_suratkeluar(List<List_suratkeluar> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getNo_urut();
            case 1:
                return data.get(rowIndex).getJenis_surat();
            case 2:
                return data.get(rowIndex).getTanggal_surat();
            case 3:
                return data.get(rowIndex).getNomor_surat();
            case 4:
                return data.get(rowIndex).getPerihal();
            case 5:
                return data.get(rowIndex).getTanggal_keluar();
            case 6:
                return data.get(rowIndex).getSurat_ditunjukan();       
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
                return "Tanggal Surat";
            case 3:
                return "Nomor Surat";
            case 4:
                return "Perihal";
            case 5:
                return "Tanggal Keluar";
            case 6:
                return "Surat Ditunjukan";
            default:
                return null;
        }
    }
}
