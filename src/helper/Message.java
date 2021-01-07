/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import javax.swing.JOptionPane;
/**
 *
 * @author Klaus
 */
public class Message {
    public void keluar(){
        int pesan=JOptionPane.showConfirmDialog(null, "Yakin Mau Keluar?", "Pesan", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pesan==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    public void simpan(){
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Maillist",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notsimpan(String e){
        JOptionPane.showMessageDialog(null,"Data gagal disimpan:" + e,"Maillist",JOptionPane.INFORMATION_MESSAGE);
    }
    public void teredit(){
        JOptionPane.showMessageDialog(null,"Data berhasil edit","Maillist",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notteredit(String e){
        JOptionPane.showMessageDialog(null,"Data gagal diedit:" + e,"Maillist",JOptionPane.INFORMATION_MESSAGE);
    }
    public void terhapus(){
        JOptionPane.showMessageDialog(null,"Data berhasil dihapus","Maillist",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notterhapus(String e){
        JOptionPane.showMessageDialog(null,"Data gagal dihapus:" + e,"Maillist",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notloadgrid(String e){
        JOptionPane.showMessageDialog(null,"Data gagal ditampilkan:" + e,"Maillist",JOptionPane.WARNING_MESSAGE);    
    }
    public void notloadcombo(String e){
        JOptionPane.showMessageDialog(null,"Load Combo Gagal:" + e,"Maillist",JOptionPane.WARNING_MESSAGE);
    }
    public void validasi(){
        JOptionPane.showMessageDialog(null,"Data belum lengkap","Maillist",JOptionPane.INFORMATION_MESSAGE);      
    }
    public void kategory(){
        JOptionPane.showMessageDialog(null,"Belum Memilih Kategori Pencarian","Maillist",JOptionPane.INFORMATION_MESSAGE);      
    }
    public void dbbuat(){
        JOptionPane.showMessageDialog(null,"Database Gagal Di buat" + "Error","Maillist",JOptionPane.WARNING_MESSAGE);     
    }
}





