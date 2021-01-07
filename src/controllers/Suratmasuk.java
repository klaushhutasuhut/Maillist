/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import config.database;
import helper.List_suratmasuk;
import helper.tbl_suratmasuk;
import helper.Message;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
/**
 *
 * @author Klaus
 */
public class Suratmasuk extends database{
    private String no_urut,jenis_surat,asal_surat,no_surat,perihal,no_agenda,ket;
    private Date tanggal_surat,tanggal_terima;
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
    
    public String getAsal_surat(){
        return asal_surat;
    }

    public void setAsal_surat(String asal_surat){
        this.asal_surat = asal_surat;
    }
    
    public Date getTanggal_surat(){
        return tanggal_surat;
    }

    public void setTanggal_surat(Date tanggal_surat){
        this.tanggal_surat = tanggal_surat;
    }
    
    public String getNo_surat(){
        return no_surat;
    }

    public void setNo_surat(String no_surat){
        this.no_surat = no_surat;
    }
    
    public String getPerihal(){
        return perihal;
    }

    public void setPerihal(String perihal){
        this.perihal = perihal;
    }
    
    public Date getTanggal_terima(){
        return tanggal_terima;
    }

    public void setTanggal_terima(Date tanggal_terima){
        this.tanggal_terima = tanggal_terima;
    }
    
    public String getNo_agenda(){
        return no_agenda;
    }

    public void setNo_agenda(String no_agenda){
        this.no_agenda = no_agenda;
    }
    
    public String getKeterangan(){
        return ket;
    }

    public void setKeterangan(String ket){
        this.ket = ket;
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
        List<List_suratmasuk> data = new ArrayList<>();

        try {
            koneksi();
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
            tbl_suratmasuk tblcari = new tbl_suratmasuk(data);
            tbl_surat.setModel(tblcari);
        } catch (SQLException ex) {
        }
    }
    
    public void ctrldisposisi(JDialog formB){
        formB.setVisible(true);
    }
}
