/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controllers.Suratkeluar;
import models.M_suratkeluar;
import helper.List_suratkeluar;
import helper.tbl_suratkeluar;
import helper.Message;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Klaus
 */
public class v_suratkeluar extends javax.swing.JFrame {
    List<List_suratkeluar> data = new ArrayList<>();
    tbl_suratkeluar tblmodel = new tbl_suratkeluar(data);
    M_suratkeluar model = new M_suratkeluar();
    Message msg = new Message(); 
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String dir;
    /**
     * Creates new form v_suratkeluar
     * @param dirct
     */
    public v_suratkeluar(String dirct) {
        initComponents();
        model.setDirectori(dirct);
        dir = dirct;
        this.loadcombo();
        this.loadtblkel();
        this.awal();
        this.windowsfull();
    }
    
    private void windowsfull(){
        setLocationRelativeTo(null);
        setExtendedState(v_suratkeluar.MAXIMIZED_BOTH);
    }
    
    private void kembali(){
        v_access a = new v_access();
        a.setVisible(true);
        dispose();
    }
    
    private void menusuratmasuk(){
        v_suratmasuk a = new v_suratmasuk(dir);
        a.setVisible(true);
        dispose();
    }
    
    private void keluar(){
        System.exit(0);
    }
    
    private void awal(){
        this.tampilakhir();
        this.nonaktifinput();
        this.tbl_suratkel.requestFocus();
        this.btn_simpan.setVisible(false);
        this.btn_batal.setVisible(false);
        this.btn_entri.setVisible(true);
        this.btn_entri.setEnabled(true);
        this.btn_hapus.setEnabled(false);
        this.btn_hapus.setVisible(true);
        this.btn_edit.setEnabled(false);
        this.btn_edit.setVisible(true);
        this.btn_updt.setVisible(false);
        this.btn_entri.requestFocus();
    }
       
    private void bersih(){
        this.t_nokel.setText("");
        this.cb_js.setSelectedItem("--Pilih--");
        this.jd_tgls.setCalendar(null);
        this.cb_ns.setSelectedItem("");
        this.tno1.setText("");
        this.tno2.setText("");
        this.t_perihal.setText("");
        this.jd_tglkel.setCalendar(null);
        this.t_sd.setText("");
        this.cb_kat.setSelectedItem("--Pilih--");
        this.t_cari.setText("");
    }
    
    private void aktifinput(){
        this.t_nokel.setEnabled(true);
        this.cb_js.setEnabled(true);
        this.jd_tgls.setEnabled(true);
        this.cb_ns.setEnabled(true);
        this.tno1.setEnabled(true);
        this.tno2.setEnabled(true);
        this.t_perihal.setEnabled(true);
        this.jd_tglkel.setEnabled(true);
        this.t_sd.setEnabled(true);
    }
    
    private void nonaktifinput(){
        this.t_nokel.setEnabled(false);
        this.cb_js.setEnabled(false);
        this.jd_tgls.setEnabled(false);
        this.cb_ns.setEnabled(false);
        this.tno1.setEnabled(false);
        this.tno2.setEnabled(false);
        this.t_perihal.setEnabled(false);
        this.jd_tglkel.setEnabled(false);
        this.t_sd.setEnabled(false);
    }
    
    private void aktiftable(){
        this.btn_edit.setEnabled(true);
        this.btn_hapus.setEnabled(true);
        this.btn_entri.setEnabled(false);
    }
    
    private void aktifentri(){
        this.bersih();
        this.btn_edit.setEnabled(false);
        this.btn_simpan.setVisible(true);
        this.btn_batal.setVisible(true);
        this.btn_hapus.setVisible(false);
        this.btn_entri.setVisible(false);
    }
    
    private void aktifubah(){
        this.btn_entri.setEnabled(false);
        this.btn_hapus.setEnabled(false);
        this.btn_updt.setVisible(true);
        this.btn_batal.setVisible(true);
        this.btn_edit.setVisible(false);
        this.aktifinput();
        this.t_nokel.setEnabled(false);
    }
    
    private void aktifhapus(){
        this.btn_entri.setEnabled(false);
        this.btn_edit.setEnabled(false);
    }
    
    private void loadcombo(){
        model.loadcombo_box(this.cb_ns);
    }
    
    private void loadtblkel(){
        data =  model.LoadSurat("");
        tblmodel = new tbl_suratkeluar(data);
        tbl_suratkel.setModel(tblmodel);
    }
    
    private void tampilakhir(){
        Suratkeluar dt = model.Dataakhir();
        t_nokel.setText(dt.getNo_urut());
        cb_js.setSelectedItem(dt.getJenis_surat());
        jd_tgls.setDate(dt.getTanggal_surat());
        cb_ns.setSelectedItem(dt.getCombo_surat());
        tno1.setText(dt.getNomor_surat());
        tno2.setText(dt.getTahun_surat());
        t_perihal.setText(dt.getPerihal());
        jd_tglkel.setDate(dt.getTanggal_keluar());
        t_sd.setText(dt.getSurat_ditunjukan());
    }
   
    private void settable(){
        int i = tbl_suratkel.getSelectedRow();
        String no_urut = tbl_suratkel.getValueAt(i, 0).toString();
        Suratkeluar dt = model.pilihNo(no_urut);
        t_nokel.setText(dt.getNo_urut());
        cb_js.setSelectedItem(dt.getJenis_surat());
        jd_tgls.setDate(dt.getTanggal_surat());
        cb_ns.setSelectedItem(dt.getCombo_surat());
        tno1.setText(dt.getNomor_surat());
        tno2.setText(dt.getTahun_surat());
        t_perihal.setText(dt.getPerihal());
        jd_tglkel.setDate(dt.getTanggal_keluar());
        t_sd.setText(dt.getSurat_ditunjukan());
        model.setDirectori(dir);
    }
    
    private void proses(){
        model.setNo_urut(String.valueOf(this.t_nokel.getText()));
        model.setJenis_surat(String.valueOf(this.cb_js.getSelectedItem()));
        model.setTanggal_surat(this.jd_tgls.getDate());
        model.setCombo_surat(String.valueOf(this.cb_ns.getSelectedItem()));
        model.setNomor_surat(String.valueOf(this.tno1.getText()));
        model.setTahun_surat(String.valueOf(this.tno2.getText()));
        model.setPerihal(String.valueOf(this.t_perihal.getText()));
        model.setTanggal_keluar(this.jd_tglkel.getDate());
        model.setSurat_ditunjukan(String.valueOf(this.t_sd.getText()));
    }
    
    private void Simpansuratkeluar(){
        if(this.t_nokel.getText().equals("")
            || this.cb_js.getSelectedItem().equals("Pilih")
            || this.jd_tgls.getDate() == null
            || this.cb_ns.getSelectedItem().equals("")
            || this.tno1.getText().equals("")
            || this.tno2.getText().equals("")
            || this.t_perihal.getText().equals("")
            || this.jd_tglkel.getDate() == null
            || this.t_sd.getText().equals("")) {
            msg.validasi();
        }else{
            this.proses();
            model.Simpansurat(model);
            this.loadtblkel();
            this.awal();
            model.setDirectori(dir);
        }
    }
    
    private void Updatesuratkeluar(){
        if(this.t_nokel.getText().equals("")
            || this.cb_js.getSelectedItem().equals("Pilih")
            || this.jd_tgls.getDate() == null
            || this.cb_ns.getSelectedItem().equals("")
            || this.tno1.getText().equals("")
            || this.tno2.getText().equals("")
            || this.t_perihal.getText().equals("")
            || this.jd_tglkel.getDate() == null
            || this.t_sd.getText().equals("")) {
            msg.validasi();
        }else{
            this.proses();
            model.Updatesurat(model);
            this.loadtblkel();
            this.awal();
            model.setDirectori(dir);
        }
    }
    
    private void Deletesuratkeluar(){
        this.proses();
        model.Deletesurat(model);
        this.loadtblkel();
        this.awal();
        model.setDirectori(dir);
    }
    
    private void searching(){
        model.cari(this.cb_kat ,this.t_cari ,this.tbl_suratkel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_perihal = new javax.swing.JTextArea();
        jd_tglkel = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_sd = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jd_tgls = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        t_nokel = new javax.swing.JTextField();
        cb_ns = new javax.swing.JComboBox<>();
        tno2 = new javax.swing.JTextField();
        tno1 = new javax.swing.JTextField();
        cb_kat = new javax.swing.JComboBox<>();
        cb_js = new javax.swing.JComboBox<>();
        t_cari = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_entri = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_updt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_suratkel = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        dblain = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mn_sm = new javax.swing.JMenu();
        mn_sk = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mn_k = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cbmn1 = new javax.swing.JCheckBoxMenuItem();
        cbmn2 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MailList - [Surat keluar]");
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(880, 770));
        setName("v_keluar"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jenis Surat");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        jLabel2.setText("Nomor Surat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 30));

        jLabel3.setText("Nomor Urut");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 30));

        jLabel4.setText("Surat Ditujukan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        jLabel6.setText("Tanggal Surat");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 30));

        t_perihal.setColumns(20);
        t_perihal.setRows(5);
        jScrollPane1.setViewportView(t_perihal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 450, 110));

        jd_tglkel.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jd_tglkel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 30));

        t_sd.setColumns(20);
        t_sd.setRows(5);
        jScrollPane2.setViewportView(t_sd);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 450, 110));

        jLabel7.setText("Perihal");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        jd_tgls.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jd_tgls, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 210, 30));

        jLabel8.setText("Tanggal Keluar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        jLabel10.setText("Jenis Pencarian");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 120, 30));

        jLabel11.setText("Cari Data");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 70, 30));
        getContentPane().add(t_nokel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 80, 30));

        cb_ns.setEditable(true);
        getContentPane().add(cb_ns, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, 30));
        getContentPane().add(tno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 70, 30));
        getContentPane().add(tno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 100, 30));

        cb_kat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "No Urut", "Jenis Surat", "Tanggal Surat", "No Surat", "Perihal", "Tanggal Keluar", "Surat Ditunjukan" }));
        getContentPane().add(cb_kat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 150, 30));

        cb_js.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Umum", "Badan Pertanahan Nasional RI", "Gubernur", "Kantor Wilayah BPN", "Kantor Pertanahan", "Instansi Lain", "Walikota" }));
        getContentPane().add(cb_js, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 30));

        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_cariKeyReleased(evt);
            }
        });
        getContentPane().add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 340, 30));

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, 30));

        btn_edit.setText("Ubah Data");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 90, 30));

        btn_entri.setText("Entri Data Baru");
        btn_entri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entriActionPerformed(evt);
            }
        });
        getContentPane().add(btn_entri, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, 30));

        btn_batal.setText("Cancel");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 100, 30));

        btn_hapus.setText("Hapus Data");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 100, 30));

        btn_updt.setText("Ubah Data");
        btn_updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updtActionPerformed(evt);
            }
        });
        getContentPane().add(btn_updt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 90, 30));

        tbl_suratkel.setAutoCreateRowSorter(true);
        tbl_suratkel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_suratkel.setMaximumSize(new java.awt.Dimension(1366, 768));
        tbl_suratkel.setMinimumSize(new java.awt.Dimension(880, 770));
        tbl_suratkel.setRowSelectionAllowed(false);
        tbl_suratkel.setRowSorter(null);
        tbl_suratkel.getTableHeader().setReorderingAllowed(false);
        tbl_suratkel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_suratkelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_suratkel);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 1260, 170));

        jMenu1.setText("Menu");

        dblain.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        dblain.setText("Buka Database Lain");
        dblain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dblainActionPerformed(evt);
            }
        });
        jMenu1.add(dblain);
        jMenu1.add(jSeparator2);

        mn_sm.setText("Surat Masuk");
        mn_sm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_smMouseClicked(evt);
            }
        });
        mn_sm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_smActionPerformed(evt);
            }
        });
        jMenu1.add(mn_sm);

        mn_sk.setText("Surat Keluar");
        jMenu1.add(mn_sk);
        jMenu1.add(jSeparator3);

        mn_k.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mn_k.setText("Keluar");
        mn_k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_kActionPerformed(evt);
            }
        });
        jMenu1.add(mn_k);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Report");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Export Database>>");
        jMenu2.add(jMenuItem4);
        jMenu2.add(jSeparator1);

        cbmn1.setText("1 Surat Masuk");
        cbmn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmn1ActionPerformed(evt);
            }
        });
        jMenu2.add(cbmn1);

        cbmn2.setSelected(true);
        cbmn2.setText("2 Surat Keluar");
        jMenu2.add(cbmn2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Bantuan");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        this.Simpansuratkeluar();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        this.aktifubah();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_entriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entriActionPerformed
        // TODO add your handling code here:
        this.aktifinput();
        this.aktifentri();
        this.t_nokel.requestFocus();
    }//GEN-LAST:event_btn_entriActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        this.awal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        this.Deletesuratkeluar();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updtActionPerformed
        // TODO add your handling code here:
        this.Updatesuratkeluar();
    }//GEN-LAST:event_btn_updtActionPerformed

    private void dblainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dblainActionPerformed
        // TODO add your handling code here:
        this.kembali();
    }//GEN-LAST:event_dblainActionPerformed

    private void mn_smActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_smActionPerformed
        // TODO add your handling code here:
        this.menusuratmasuk();
    }//GEN-LAST:event_mn_smActionPerformed

    private void mn_kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_kActionPerformed
        // TODO add your handling code here:
        this.keluar();
    }//GEN-LAST:event_mn_kActionPerformed

    private void cbmn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmn1ActionPerformed
        // TODO add your handling code here:
        this.menusuratmasuk();
    }//GEN-LAST:event_cbmn1ActionPerformed

    private void tbl_suratkelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_suratkelMouseClicked
        // TODO add your handling code here:
        this.settable();
        this.aktiftable();
    }//GEN-LAST:event_tbl_suratkelMouseClicked

    private void mn_smMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_smMouseClicked
        // TODO add your handling code here:
        this.menusuratmasuk();
    }//GEN-LAST:event_mn_smMouseClicked

    private void t_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyReleased
        this.searching();
    }//GEN-LAST:event_t_cariKeyReleased

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_entri;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_updt;
    private javax.swing.JComboBox<String> cb_js;
    private javax.swing.JComboBox<String> cb_kat;
    private javax.swing.JComboBox<String> cb_ns;
    private javax.swing.JCheckBoxMenuItem cbmn1;
    private javax.swing.JCheckBoxMenuItem cbmn2;
    private javax.swing.JMenuItem dblain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private com.toedter.calendar.JDateChooser jd_tglkel;
    private com.toedter.calendar.JDateChooser jd_tgls;
    private javax.swing.JMenuItem mn_k;
    private javax.swing.JMenu mn_sk;
    private javax.swing.JMenu mn_sm;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_nokel;
    private javax.swing.JTextArea t_perihal;
    private javax.swing.JTextArea t_sd;
    private javax.swing.JTable tbl_suratkel;
    private javax.swing.JTextField tno1;
    private javax.swing.JTextField tno2;
    // End of variables declaration//GEN-END:variables
}
