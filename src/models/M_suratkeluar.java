/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.Suratkeluar;
import helper.List_suratkeluar;
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
public class M_suratkeluar extends Suratkeluar{
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
        this.loadcombo_p("SELECT * FROM surat_keluar", "cb_surat", combo);
    }
    
    
    public List<List_suratkeluar> LoadSurat(String where){
        String QueryLoad = "SELECT * FROM surat_keluar" + where;
        List<List_suratkeluar> data = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                List_suratkeluar mm = new List_suratkeluar();
                mm.setNo_urut(rs.getString("no_urut"));
                mm.setJenis_surat(rs.getString("jenis_surat"));
                mm.setTanggal_surat(rs.getString("tanggal_surat"));
                mm.setNomor_surat(rs.getString("nomor_surat"));
                mm.setPerihal(rs.getString("perihal"));
                mm.setTanggal_keluar(rs.getString("tanggal_keluar"));
                mm.setSurat_ditunjukan(rs.getString("surat_ditunjukan"));
                data.add(mm);
            }
        } catch (SQLException ex) {
                pesan.notloadgrid(String.valueOf(ex));
        }
        return data;
    }
    
    public Suratkeluar Dataakhir() {
        Suratkeluar ld = new Suratkeluar();
        String QueryLoad = "select * from surat_keluar ORDER BY no_urut DESC LIMIT 1";
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ld.setNo_urut(rs.getString("no_urut"));
                ld.setJenis_surat(rs.getString("jenis_surat"));
                ld.setTanggal_surat(rs.getDate("tanggal_surat"));
                ld.setCombo_surat(rs.getString("cb_surat"));
                ld.setNomor_surat(rs.getString("t_surat"));
                ld.setTahun_surat(rs.getString("tahun"));
                ld.setPerihal(rs.getString("perihal"));
                ld.setTanggal_keluar(rs.getDate("tanggal_keluar"));
                ld.setSurat_ditunjukan(rs.getString("surat_ditunjukan"));
            }

        } catch (SQLException ex) {
            
        }
        return ld;
    }
    
    public Suratkeluar pilihNo(String no_urut) {
        Suratkeluar ld = new Suratkeluar();
        String QueryLoad = "select * from surat_keluar where no_urut=?";
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            pstmt.setString(1, no_urut);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ld.setNo_urut(rs.getString("no_urut"));
                ld.setJenis_surat(rs.getString("jenis_surat"));
                ld.setTanggal_surat(rs.getDate("tanggal_surat"));
                ld.setCombo_surat(rs.getString("cb_surat"));
                ld.setNomor_surat(rs.getString("t_surat"));
                ld.setTahun_surat(rs.getString("tahun"));
                ld.setPerihal(rs.getString("perihal"));
                ld.setTanggal_keluar(rs.getDate("tanggal_keluar"));
                ld.setSurat_ditunjukan(rs.getString("surat_ditunjukan"));
            }

        } catch (SQLException ex) {
            
        }
        return ld;
    }
    
    public void Simpansurat(Suratkeluar ld){
        String Gabung = getCombo_surat() + "-" + getNomor_surat() + "-" + getTahun_surat();
        Timestamp tanggalsurat = new Timestamp(ld.getTanggal_surat().getTime());
        Timestamp tanggalkel = new Timestamp(ld.getTanggal_keluar().getTime());
        this.setQuerySave ("INSERT INTO surat_keluar(no_urut,jenis_surat,"
                + "tanggal_surat,nomor_surat,perihal,tanggal_keluar,surat_ditunjukan,cb_surat,t_surat,tahun) values"
                + "('" + ld.getNo_urut() + "',"
                + "'" + ld.getJenis_surat() + "'" + ","
                + "'" + tanggalsurat + "'" + ","
                + "'" + Gabung + "'" + ","
                + "'" + ld.getPerihal() + "'" + ","
                + "'" + tanggalkel + "'" + ","
                + "'" + ld.getSurat_ditunjukan() + "'" + ","
                + "'" + ld.getCombo_surat()+ "'" + ","
                + "'" + ld.getNomor_surat()+ "'" + ","        
                + "'" + ld.getTahun_surat()+ "')");
        this.SimpanData(QuerySave);
    }
    
    public void Updatesurat(Suratkeluar ld){
        String Gabung = getCombo_surat() + "-" + getNomor_surat() + "-" + getTahun_surat();
        Timestamp tanggalsurat = new Timestamp(ld.getTanggal_surat().getTime());
        Timestamp tanggalkel = new Timestamp(ld.getTanggal_keluar().getTime());
        this.setQueryEdit("UPDATE surat_keluar set "
                + "jenis_surat = '" + ld.getJenis_surat() + "',"
                + "tanggal_surat = '" + tanggalsurat + "',"
                + "nomor_surat = '" + Gabung + "',"
                + "perihal = '" + ld.getPerihal() + "',"
                + "tanggal_keluar = '" + tanggalkel + "',"
                + "surat_ditunjukan = '" + ld.getSurat_ditunjukan() + "',"
                + "cb_surat = '" + ld.getCombo_surat() + "',"
                + "t_surat = '" + ld.getNomor_surat()+ "',"        
                + "tahun = '" + ld.getTahun_surat()+ "'"
                + " WHERE no_urut = '" + ld.getNo_urut() + "'");
        this.UpdateData(QueryEdit);
    }
     
    public void Deletesurat(Suratkeluar ld){
        this.setQueryHapus("DELETE FROM surat_keluar "
                + " WHERE no_urut = '" +ld.getNo_urut()+ "'");
         this.DeleteData(this.getQueryHapus());
    }
    
    public void cari(JComboBox cb_kat ,JTextField t_cari ,JTable tbl_surat){
        String QueryLoad = "";
        if (cb_kat.getSelectedItem().equals("No Urut")){
            QueryLoad = "select * from surat_keluar where no_urut like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Jenis Surat")){
            QueryLoad = "select * from surat_keluar where jenis_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Tanggal Surat")){
            QueryLoad = "select * from surat_keluar where tanggal_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Nomor Surat")){
            QueryLoad = "select * from surat_keluar where nomor_surat like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Perihal")){
            QueryLoad = "select * from surat_keluar where perihal like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Tanggal Keluar")){
            QueryLoad = "select * from surat_keluar where tanggal_keluar like'" + t_cari.getText() + "%'";
        }else if(cb_kat.getSelectedItem().equals("Surat Ditunjukan")){
            QueryLoad = "select * from surat_keluar where surat_ditunjukan like'" + t_cari.getText() + "%'";
        }else{
            pesan.kategory();
        }
        cariSurat(QueryLoad ,tbl_surat);
    }
}
