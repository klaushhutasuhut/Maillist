/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.Suratmasuk;
import helper.List_suratmasuk;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Klaus
 */
public class M_suratmasuk extends Suratmasuk{
    private String QuerySave,QueryEdit,QueryHapus; 
        
     public void setQuerySave(String QuerySave){
        this.QuerySave = QuerySave;
    }
     
     public void setQueryEdit(String QueryEdit){
        this.QueryEdit = QueryEdit;
    }

    public String getQueryHapus(){
        return QueryHapus;
    }

    public void setQueryHapus(String QueryHapus){
        this.QueryHapus = QueryHapus;
    }
    
    public void loadcombo_box(JComboBox combo){
        this.loadcombo_p("SELECT * FROM surat_masuk", "no_agenda", combo);
    }
    
    public List<List_suratmasuk> LoadSurat(String where) {
        String QueryLoad = "select * from surat_masuk " + where;
        List<List_suratmasuk> data = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                List_suratmasuk mm = new List_suratmasuk();
                mm.setNo_urut(rs.getString("no_urut"));
                mm.setJenis_surat(rs.getString("jenis_surat"));
                mm.setAsal_surat(rs.getString("asal_surat"));
                mm.setTanggal_surat(rs.getString("tanggal_surat"));
                mm.setNo_surat(rs.getString("nomor_surat"));
                mm.setPerihal(rs.getString("perihal"));
                mm.setTanggal_terima(rs.getString("tanggal_diterima"));
                mm.setNo_agenda(rs.getString("no_agenda"));
                data.add(mm);
            }
        } catch (SQLException ex) {
                pesan.notloadgrid(String.valueOf(ex));
        }
        return data;
    }
    
    public Suratmasuk Dataakhir() {
        Suratmasuk ld = new Suratmasuk();
        String QueryLoad = "select * from surat_masuk ORDER BY no_urut DESC LIMIT 1";
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ld.setNo_urut(rs.getString("no_urut"));
                ld.setJenis_surat(rs.getString("jenis_surat"));
                ld.setAsal_surat(rs.getString("asal_surat"));
                ld.setTanggal_surat(rs.getDate("tanggal_surat"));
                ld.setNo_surat(rs.getString("nomor_surat"));
                ld.setPerihal(rs.getString("perihal"));
                ld.setTanggal_terima(rs.getDate("tanggal_diterima"));
                ld.setNo_agenda(rs.getString("no_agenda"));
                ld.setKeterangan(rs.getString("ket"));
            }

        } catch (SQLException ex) {
            
        }
        return ld;
    }
    
    public Suratmasuk pilihNo(String no_urut) {
        Suratmasuk ld = new Suratmasuk();
        String QueryLoad = "select * from surat_masuk where no_urut=?";
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            pstmt.setString(1, no_urut);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ld.setNo_urut(rs.getString("no_urut"));
                ld.setJenis_surat(rs.getString("jenis_surat"));
                ld.setAsal_surat(rs.getString("asal_surat"));
                ld.setTanggal_surat(rs.getDate("tanggal_surat"));
                ld.setNo_surat(rs.getString("nomor_surat"));
                ld.setPerihal(rs.getString("perihal"));
                ld.setTanggal_terima(rs.getDate("tanggal_diterima"));
                ld.setNo_agenda(rs.getString("no_agenda"));
                ld.setKeterangan(rs.getString("ket"));
            }

        } catch (SQLException ex) {
            
        }
        return ld;
    }
    
    public void Simpansurat(Suratmasuk ld){
        Timestamp tanggalsurat = new Timestamp(ld.getTanggal_surat().getTime());
        Timestamp tanggalterima = new Timestamp(ld.getTanggal_terima().getTime());
        this.setQuerySave ("INSERT INTO surat_masuk(no_urut,jenis_surat,asal_surat,"
                + "tanggal_surat,nomor_surat,perihal,tanggal_diterima,no_agenda,ket) values"
                + "('" + ld.getNo_urut() + "',"
                + "'" + ld.getJenis_surat() + "'" + ","
                + "'" + ld.getAsal_surat() + "'" + ","
                + "'" + tanggalsurat + "'" + ","
                + "'" + ld.getNo_surat() + "'" + ","
                + "'" + ld.getPerihal() + "'" + ","
                + "'" + tanggalterima + "'" + ","
                + "'" + ld.getNo_agenda()+ "'" + ","
                + "'" + ld.getKeterangan()+ "')");
        this.SimpanData(QuerySave);
    }
    
    public void Updatesurat(Suratmasuk ld){
        Timestamp tanggalsurat = new Timestamp(ld.getTanggal_surat().getTime());
        Timestamp tanggalterima = new Timestamp(ld.getTanggal_terima().getTime());
        this.setQueryEdit("UPDATE surat_masuk set "
                + "jenis_surat = '" + ld.getJenis_surat() + "',"
                + "asal_surat = '" + ld.getAsal_surat()+ "',"
                + "tanggal_surat = '" + tanggalsurat + "',"
                + "nomor_surat = '" + ld.getNo_surat() + "',"
                + "perihal = '" + ld.getPerihal() + "',"
                + "tanggal_diterima = '" + tanggalterima + "',"
                + "no_agenda = '" + ld.getNo_agenda()+ "',"        
                + "ket = '" + ld.getKeterangan()+ "'"
                + " WHERE no_urut = '" + ld.getNo_urut() + "'");
        this.UpdateData(QueryEdit);
    }
     
    public void Deletesurat(Suratmasuk ld){
        this.setQueryHapus("DELETE FROM surat_masuk "
                + " WHERE no_urut = '" +ld.getNo_urut()+ "'");
         this.DeleteData(this.getQueryHapus());
    }
    
    public void cari(JComboBox cb_kat ,JTextField t_cari ,JTable tbl_surat){
        String QueryLoad = "";
        if (cb_kat.getSelectedItem().equals("No Urut")){
            QueryLoad = "select * from surat_masuk where no_urut like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Jenis Surat")){
            QueryLoad = "select * from surat_masuk where jenis_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Asal Surat")){
            QueryLoad = "select * from surat_masuk where asal_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Tanggal Surat")){
            QueryLoad = "select * from surat_masuk where tanggal_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Nomor Surat")){
            QueryLoad = "select * from surat_masuk where nomor_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Perihal")){
            QueryLoad = "select * from surat_masuk where perihal like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Tanggal Diterima")){
            QueryLoad = "select * from surat_masuk where tanggal_diterima like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("No Agenda")){
            QueryLoad = "select * from surat_masuk where no_agenda like'" + t_cari.getText() + "%'";
        }else{
            pesan.kategory();
        }
        cariSurat(QueryLoad ,tbl_surat);
    }
}
