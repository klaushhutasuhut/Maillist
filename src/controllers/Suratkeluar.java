/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import config.database;
import helper.List_suratkeluar;
import helper.tbl_suratkeluar;
import helper.Message;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Klaus
 */
public class Suratkeluar extends database{
    private String no_urut,jenis_surat,combo_surat,nomor_surat,tahun,perihal,surat_ditunjukan;
    private Date tanggal_surat,tanggal_keluar;
    private Integer kolom,RecordCount;
    public Message pesan = new Message();
    
    public String getNo_urut(){
        return no_urut;
    }

    public void setNo_urut(String no_urut){
        this.no_urut = no_urut;
    }
    
    public String getJenis_surat(){
        return jenis_surat;
    }

    public void setJenis_surat(String jenis_surat){
        this.jenis_surat = jenis_surat;
    }
       
    public Date getTanggal_surat(){
        return tanggal_surat;
    }

    public void setTanggal_surat(Date tanggal_surat){
        this.tanggal_surat = tanggal_surat;
    }
    
    public String getCombo_surat(){
        return combo_surat;
    }

    public void setCombo_surat(String combo_surat){
        this.combo_surat = combo_surat;
    }
    
    public String getNomor_surat(){
        return nomor_surat;
    }

    public void setNomor_surat(String nomor_surat){
        this.nomor_surat = nomor_surat;
    }
    
    public String getTahun_surat(){
        return tahun;
    }

    public void setTahun_surat(String tahun){
        this.tahun = tahun;
    }
    
    public String getPerihal(){
        return perihal;
    }

    public void setPerihal(String perihal){
        this.perihal = perihal;
    }
    
    public Date getTanggal_keluar(){
        return tanggal_keluar;
    }

    public void setTanggal_keluar(Date tanggal_keluar){
        this.tanggal_keluar = tanggal_keluar;
    }
    
    public String getSurat_ditunjukan(){
        return surat_ditunjukan;
    }

    public void setSurat_ditunjukan(String surat_ditunjukan){
        this.surat_ditunjukan = surat_ditunjukan;
    }
    
    public Integer getRecordCount(){
        return RecordCount;
    }

    public void setRecordCount(Integer RecordCount){
        this.RecordCount = RecordCount;
    }
    
    public void loadcombo_p(String QueryLoad, String idxfield,JComboBox combo_p){
        try{
            koneksi();
            rs = st.executeQuery(QueryLoad);
            int i = 0;
            
            while(rs.next()){
               combo_p.addItem(rs.getString(idxfield));
                i++;
            }       
            this.setRecordCount(i);
        }catch(SQLException ex){
            pesan.notloadcombo(String.valueOf(ex));
        }
    }
    
    public void SimpanData(String QuerySave){
        try{
            koneksi();
            st.executeUpdate(QuerySave);
            pesan.simpan();
        }catch(SQLException e){
            pesan.notsimpan(String.valueOf(e));
        }
    }
    
    public void UpdateData(String QueryEdit){
        try{
            koneksi();
            st.executeUpdate(QueryEdit);
            pesan.teredit();
        }catch (SQLException e) {
            pesan.notteredit(String.valueOf(e));
        }
    }
    
    public void DeleteData(String QueryHapus){
        try{
            koneksi();
            st.executeUpdate(QueryHapus);
            pesan.terhapus();
        }catch (SQLException e) {
            pesan.notterhapus(String.valueOf(e));
        }
    }
    
    public void cariSurat(String QueryLoad ,JTable tbl_surat){
        List<List_suratkeluar> data = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
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
            tbl_suratkeluar tblcari = new tbl_suratkeluar(data);
            tbl_surat.setModel(tblcari);
        } catch (SQLException ex) {
        }
    }
}

