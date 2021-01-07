/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controllers.Suratmasuk;
import models.M_suratmasuk;
import helper.List_suratmasuk;
import helper.tbl_suratmasuk;
import helper.Message;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Klaus
 */
public class v_suratmasuk extends javax.swing.JFrame{
    List<List_suratmasuk> data = new ArrayList<>();
    tbl_suratmasuk tblmodel;
    M_suratmasuk model = new M_suratmasuk();
    Message msg = new Message(); 
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    String dirct;
    /**
     * Creates new form v_suratmasuk
     * @param dir
     */
    public v_suratmasuk(String dir){
        initComponents();
        model.setDirectori(dir);
        dirct = dir;
        this.loadcombo();
        this.loadtbl();
        this.awal();
        this.windowfull();
    }
    
    private void windowfull(){
        setLocationRelativeTo(null);
        setExtendedState(v_suratmasuk.MAXIMIZED_BOTH);
    }
    
     private void kembali(){
        v_access a = new v_access();
        a.setVisible(true);
        dispose();
    }
    
    private void menusuratkeluar(){
        v_suratkeluar a = new v_suratkeluar(dirct);
        a.setVisible(true);
        dispose();
    }
    
    private void keluar(){
        System.exit(0);
    }
      
    private void awal(){
        this.tampilakhir();
        this.nonaktifinput();
        this.tbl_suratmsk.requestFocus();
        this.btn_simpan.setVisible(false);
        this.btn_batal.setVisible(false);
        this.btn_entri.setVisible(true);
        this.btn_entri.setEnabled(true);
        this.btn_hapus.setEnabled(false);
        this.btn_hapus.setVisible(true);
        this.btn_edit.setEnabled(false);
        this.btn_edit.setVisible(true);
        this.btn_updt.setVisible(false);
        this.btn_disposisi.setEnabled(false);
        this.btn_entri.requestFocus();
    }
       
    private void bersih(){
        this.t_nourut.setText("");
        this.cb_jenissurat.setSelectedItem("--Pilih--");
        this.ta_asalsurat.setText("");
        this.jd_tanggalsurat.setCalendar(null);
        this.t_nosurat.setText("");
        this.ta_perihal.setText("");
        this.jd_tanggalterima.setCalendar(null);
        this.cb_noagenda.setSelectedItem("");
        this.t_ket.setText("");
        this.cb_kat.setSelectedItem("--Pilih--");
        this.t_cari.setText("");
    }    
    
    private void aktifinput(){
        this.t_nourut.setEnabled(true);
        this.cb_jenissurat.setEnabled(true);
        this.ta_asalsurat.setEnabled(true);
        this.jd_tanggalsurat.setEnabled(true);
        this.t_nosurat.setEnabled(true);
        this.ta_perihal.setEnabled(true);
        this.jd_tanggalterima.setEnabled(true);
        this.cb_noagenda.setEnabled(true);
        this.t_ket.setEnabled(true);
    }
    
    private void nonaktifinput(){
        this.t_nourut.setEnabled(false);
        this.cb_jenissurat.setEnabled(false);
        this.ta_asalsurat.setEnabled(false);
        this.jd_tanggalsurat.setEnabled(false);
        this.t_nosurat.setEnabled(false);
        this.ta_perihal.setEnabled(false);
        this.jd_tanggalterima.setEnabled(false);
        this.cb_noagenda.setEnabled(false);
        this.t_ket.setEnabled(false);
    }
    
    private void aktiftable(){
        this.btn_edit.setEnabled(true);
        this.btn_hapus.setEnabled(true);
        this.btn_disposisi.setEnabled(true);
        this.btn_entri.setEnabled(false);
    }
    
    private void aktifentri(){
        this.bersih();
        this.btn_edit.setEnabled(false);
        this.btn_disposisi.setEnabled(false);
        this.btn_simpan.setVisible(true);
        this.btn_batal.setVisible(true);
        this.btn_hapus.setVisible(false);
        this.btn_entri.setVisible(false);
    }
    
    private void aktifubah(){
        this.btn_entri.setEnabled(false);
        this.btn_disposisi.setEnabled(false);
        this.btn_hapus.setEnabled(false);
        this.btn_updt.setVisible(true);
        this.btn_batal.setVisible(true);
        this.btn_edit.setVisible(false);
        this.aktifinput();
        this.t_nourut.setEnabled(false);
    }
    
    private void aktifhapus(){
        this.btn_entri.setEnabled(false);
        this.btn_edit.setEnabled(false);
        this.btn_disposisi.setEnabled(false);
    }
        
    private void loadcombo(){
        model.loadcombo_box(this.cb_noagenda);
    }
    
    private void tampilakhir(){
        Suratmasuk dt = model.Dataakhir();
        t_nourut.setText(dt.getNo_urut());
        cb_jenissurat.setSelectedItem(dt.getJenis_surat());
        ta_asalsurat.setText(dt.getAsal_surat());
        jd_tanggalsurat.setDate(dt.getTanggal_surat());
        t_nosurat.setText(dt.getNo_surat());
        ta_perihal.setText(dt.getPerihal());
        jd_tanggalterima.setDate(dt.getTanggal_terima());
        cb_noagenda.setSelectedItem(dt.getNo_agenda());
        t_ket.setText(dt.getKeterangan());
    }
    
    private void loadtbl(){
        data = model.LoadSurat("");
        tblmodel = new tbl_suratmasuk(data);
        tbl_suratmsk.setModel(tblmodel);
    }
   
    private void settable(){
        int i = tbl_suratmsk.getSelectedRow();
        String no_urut = tbl_suratmsk.getValueAt(i, 0).toString();
        Suratmasuk dt = model.pilihNo(no_urut);
        t_nourut.setText(dt.getNo_urut());
        cb_jenissurat.setSelectedItem(dt.getJenis_surat());
        ta_asalsurat.setText(dt.getAsal_surat());
        jd_tanggalsurat.setDate(dt.getTanggal_surat());
        t_nosurat.setText(dt.getNo_surat());
        ta_perihal.setText(dt.getPerihal());
        jd_tanggalterima.setDate(dt.getTanggal_terima());
        cb_noagenda.setSelectedItem(dt.getNo_agenda());
        t_ket.setText(dt.getKeterangan());
        model.setDirectori(dirct);
    }
    
    private void proses(){
        model.setNo_urut(String.valueOf(this.t_nourut.getText()));
        model.setJenis_surat(String.valueOf(this.cb_jenissurat.getSelectedItem()));
        model.setAsal_surat(String.valueOf(this.ta_asalsurat.getText()));
        model.setTanggal_surat(this.jd_tanggalsurat.getDate());
        model.setNo_surat(String.valueOf(this.t_nosurat.getText()));
        model.setPerihal(String.valueOf(this.ta_perihal.getText()));
        model.setTanggal_terima(this.jd_tanggalterima.getDate());
        model.setNo_agenda(String.valueOf(this.cb_noagenda.getSelectedItem()));
        model.setKeterangan(String.valueOf(this.t_ket.getText()));
    }
    
    private void Suratdisposisi(){
        String dis1 = this.t_nourut.getText();
        String dis2 = this.cb_jenissurat.getSelectedItem().toString();
        String dis3 = this.ta_asalsurat.getText();
        Date dis4 = this.jd_tanggalsurat.getDate();
        String dis5 = this.t_nosurat.getText();
        String dis6 = this.ta_perihal.getText();
        Date dis7 = this.jd_tanggalterima.getDate();
        String dis8 = this.cb_noagenda.getSelectedItem().toString();
        v_disposisi dispo = new v_disposisi(dis1, dis2, dis3, dis4, dis5, dis6, dis7, dis8, dirct);
        model.ctrldisposisi(dispo);
    }
    
    private void Simpansuratmasuk(){
        if(this.t_nourut.getText().equals("")
            || this.cb_jenissurat.getSelectedItem().equals("Pilih")
            || this.ta_asalsurat.getText().equals("")
            || this.jd_tanggalsurat.getDate() == null
            || this.t_nosurat.getText().equals("")
            || this.ta_perihal.getText().equals("")
            || this.jd_tanggalsurat.getDate() == null
            || this.cb_jenissurat.getSelectedItem().equals("")) {
            msg.validasi();
        }else{
            this.proses();
            model.Simpansurat(model);
            this.loadtbl();
            this.awal();
            model.setDirectori(dirct);
        }
    }
    
    private void Updatesuratmasuk(){
        if(this.t_nourut.getText().equals("")
            || this.cb_jenissurat.getSelectedItem().equals("Pilih")
            || this.ta_asalsurat.getText().equals("")
            || this.jd_tanggalsurat.getDate() == null
            || this.t_nosurat.getText().equals("")
            || this.ta_perihal.getText().equals("")
            || this.jd_tanggalsurat.getDate() == null
            || this.cb_jenissurat.getSelectedItem().equals("")) {
            msg.validasi();
        }else{
            this.proses();
            model.Updatesurat(model);
            this.loadtbl();
            this.awal();
            model.setDirectori(dirct);
        }
    }
    
    private void Deletesurarmasuk(){
        this.proses();
        model.Deletesurat(model);
        this.loadtbl();
        this.awal();
        model.setDirectori(dirct);
    }
    
    private void searching(){
        model.cari(this.cb_kat ,this.t_cari ,this.tbl_suratmsk);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_perihal = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_asalsurat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_disposisi = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        t_nourut = new javax.swing.JTextField();
        cb_noagenda = new javax.swing.JComboBox<>();
        t_nosurat = new javax.swing.JTextField();
        t_ket = new javax.swing.JTextField();
        btn_edit = new javax.swing.JButton();
        cb_jenissurat = new javax.swing.JComboBox<>();
        btn_entri = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_updt = new javax.swing.JButton();
        jd_tanggalsurat = new com.toedter.calendar.JDateChooser();
        jd_tanggalterima = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_suratmsk = new javax.swing.JTable();
        t_cari = new javax.swing.JTextField();
        cb_kat = new javax.swing.JComboBox();
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

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MailList - [Surat Masuk]");
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(880, 770));
        setName("v_masuk"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Jenis Surat");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        jLabel2.setText("Nomor Surat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        jLabel3.setText("Nomor Urut");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 30));

        jLabel4.setText("Asal Surat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 30));

        jLabel5.setText("Keterangan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 70, 30));

        jLabel6.setText("Tanggal Surat");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 30));

        ta_perihal.setColumns(20);
        ta_perihal.setRows(5);
        jScrollPane1.setViewportView(ta_perihal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 450, 110));

        ta_asalsurat.setColumns(20);
        ta_asalsurat.setRows(5);
        jScrollPane2.setViewportView(ta_asalsurat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 450, 110));

        jLabel7.setText("Perihal");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        jLabel8.setText("Tanggal Diterima");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        jLabel9.setText("Nomor Agenda");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, 30));

        btn_disposisi.setText("Buat Lembar Disposisi");
        btn_disposisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disposisiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_disposisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 160, 30));

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 30));

        jLabel10.setText("Jenis Pencarian");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 100, 30));

        jLabel11.setText("Cari Data");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 70, 30));
        getContentPane().add(t_nourut, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 80, 30));

        cb_noagenda.setEditable(true);
        getContentPane().add(cb_noagenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 110, 30));
        getContentPane().add(t_nosurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 450, 30));
        getContentPane().add(t_ket, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 380, 30));

        btn_edit.setText("Ubah Data");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 90, 30));

        cb_jenissurat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Umum", "Badan Pertanahan Nasional RI", "Gubernur", "Kantor Wilayah BPN", "Kantor Pertanahan", "Instansi Lain", "Walikota" }));
        getContentPane().add(cb_jenissurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 30));

        btn_entri.setText("Entri Data Baru");
        btn_entri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entriActionPerformed(evt);
            }
        });
        getContentPane().add(btn_entri, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 30));

        btn_batal.setText("Cancel");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 100, 30));

        btn_hapus.setText("Hapus Data");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 100, 30));

        btn_updt.setText("Ubah Data");
        btn_updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updtActionPerformed(evt);
            }
        });
        getContentPane().add(btn_updt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 90, 30));

        jd_tanggalsurat.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jd_tanggalsurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 210, 30));

        jd_tanggalterima.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jd_tanggalterima, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 210, 30));

        tbl_suratmsk.setAutoCreateRowSorter(true);
        tbl_suratmsk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_suratmsk.setMaximumSize(new java.awt.Dimension(1366, 768));
        tbl_suratmsk.setMinimumSize(new java.awt.Dimension(880, 770));
        tbl_suratmsk.setRowSorter(null);
        tbl_suratmsk.getTableHeader().setReorderingAllowed(false);
        tbl_suratmsk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_suratmskMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_suratmsk);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1260, 170));

        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_cariKeyReleased(evt);
            }
        });
        getContentPane().add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, 380, 30));

        cb_kat.setMaximumRowCount(7);
        cb_kat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih--", "No Urut", "Jenis Surat", "Asal Surat", "Tanggal Surat", "Nomor Surat", "Perihal", "Tanggal Diterima", "No Agenda" }));
        cb_kat.setName(""); // NOI18N
        getContentPane().add(cb_kat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 150, 30));

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
        jMenu1.add(mn_sm);

        mn_sk.setText("Surat Keluar");
        mn_sk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_skMouseClicked(evt);
            }
        });
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

        cbmn1.setSelected(true);
        cbmn1.setText("1 Surat Masuk");
        jMenu2.add(cbmn1);

        cbmn2.setText("2 Surat Keluar");
        cbmn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmn2ActionPerformed(evt);
            }
        });
        jMenu2.add(cbmn2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Bantuan");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_entriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entriActionPerformed
        // TODO add your handling code here:
        this.aktifinput();
        this.aktifentri();
        this.t_nourut.requestFocus();
    }//GEN-LAST:event_btn_entriActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        this.Simpansuratmasuk();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        this.awal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void tbl_suratmskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_suratmskMouseClicked
        // TODO add your handling code here:
        this.settable();
        this.aktiftable();
    }//GEN-LAST:event_tbl_suratmskMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        this.aktifubah();        
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updtActionPerformed
        // TODO add your handling code here:
        this.Updatesuratmasuk();
    }//GEN-LAST:event_btn_updtActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        this.Deletesurarmasuk();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void t_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyReleased
        // TODO add your handling code here:
        this.searching();
    }//GEN-LAST:event_t_cariKeyReleased

    private void btn_disposisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disposisiActionPerformed
        // TODO add your handling code here:
        this.Suratdisposisi();
    }//GEN-LAST:event_btn_disposisiActionPerformed

    private void dblainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dblainActionPerformed
        // TODO add your handling code here:
        this.kembali();
    }//GEN-LAST:event_dblainActionPerformed

    private void mn_kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_kActionPerformed
        // TODO add your handling code here:
        this.keluar();
    }//GEN-LAST:event_mn_kActionPerformed

    private void cbmn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmn2ActionPerformed
        // TODO add your handling code here:
        this.menusuratkeluar();
    }//GEN-LAST:event_cbmn2ActionPerformed

    private void mn_skMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_skMouseClicked
        // TODO add your handling code here:
        this.menusuratkeluar();
    }//GEN-LAST:event_mn_skMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_disposisi;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_entri;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_updt;
    private javax.swing.JComboBox<String> cb_jenissurat;
    public javax.swing.JComboBox cb_kat;
    private javax.swing.JComboBox<String> cb_noagenda;
    private javax.swing.JCheckBoxMenuItem cbmn1;
    private javax.swing.JCheckBoxMenuItem cbmn2;
    private javax.swing.JMenuItem dblain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private com.toedter.calendar.JDateChooser jd_tanggalsurat;
    private com.toedter.calendar.JDateChooser jd_tanggalterima;
    private javax.swing.JMenuItem mn_k;
    private javax.swing.JMenu mn_sk;
    private javax.swing.JMenu mn_sm;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_ket;
    private javax.swing.JTextField t_nosurat;
    private javax.swing.JTextField t_nourut;
    private javax.swing.JTextArea ta_asalsurat;
    private javax.swing.JTextArea ta_perihal;
    private javax.swing.JTable tbl_suratmsk;
    // End of variables declaration//GEN-END:variables
}
