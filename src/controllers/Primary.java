/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import config.database;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.DefaultListModel;
/**
 *
 * @author Klaus
 */
public class Primary extends database{
    String fileop;
    static String title = "MailList-[Buat Database]";
    static String title2 = "MailList-[Cari Database]";
    DefaultListModel df = new DefaultListModel();
    
     public String getFile(){
        return fileop;
    }

    public void setFile(String fileop){
        this.fileop = fileop;
    }

    public JFileChooser Dialogsave(){
        JFileChooser Dialog = new JFileChooser(".");
        Dialog.setDialogTitle(title);
        Dialog.setCurrentDirectory(new File(System.getProperty("user.dir")
                +System.getProperty("file.separator")
                +"saves"));
        Dialog.setFileFilter(new javax.swing.filechooser.FileFilter(){
        @Override
        public boolean accept(final File f){
            return f.isDirectory()|| f.getAbsolutePath().endsWith(".mdb");
            }

        @Override
        public String getDescription(){
            return "Access files (*.mdb)";
            }
        }
        );
        return Dialog;
    }
    
    public JFileChooser DialogOpen(){
        JFileChooser Dialog = new JFileChooser(".");
        Dialog.setDialogTitle(title2);
        Dialog.setCurrentDirectory(new File(System.getProperties().getProperty("user.home")));
        Dialog.setFileFilter(new javax.swing.filechooser.FileFilter(){
        @Override
        public boolean accept(final File f){
            return f.isDirectory()|| f.getAbsolutePath().endsWith(".mdb");
            }

        @Override
        public String getDescription(){
            return "Access files (*.mdb)";
            }
        }
        );
        return Dialog;
    }
    
    public void Tampilfile(JList jl){
        File dir = new File("saves");
        File[] files = dir.listFiles();
        for(File file: files){
            if(file.isFile()){
            df.addElement(file.getName());
            jl.setModel(df);
            }else{
                
            }
        }
    }
    
    public void OpenFileMSaccess(){
        File direct = null;
        JFileChooser Dialog = DialogOpen();
        int ret = Dialog.showOpenDialog(null);
            if(ret == JFileChooser.APPROVE_OPTION){
                direct = Dialog.getSelectedFile();
                String name = direct.getPath().replace('\\', '/');
                setFile(String.valueOf(name));
            }else{
                System.out.println("File is Cancelled");
            }            
            if(direct == null){
                System.out.println("No File");
            }
    }
}
