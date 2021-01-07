/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import controllers.Primary;
import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JFileChooser;

/**
 *
 * @author Klaus
 */
public class migrations {
    Primary di = new Primary();
    
    public void CreateDB() throws SQLException, IOException{
        File direct = null;
        JFileChooser Dialog = di.Dialogsave();
        int ret = Dialog.showSaveDialog(null);
            if(ret == JFileChooser.APPROVE_OPTION){
            direct = Dialog.getSelectedFile();
            String name = direct.getAbsolutePath();        
                try{
                    Database db = DatabaseBuilder.create(Database.FileFormat.V2010, new File(name+".mdb"));
                    Table tblsm = new TableBuilder("surat_masuk").setPrimaryKey("no_urut")
                        .addColumn(new ColumnBuilder("no_urut").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("jenis_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("asal_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("tanggal_surat").setSQLType(Types.DATE))
                        .addColumn(new ColumnBuilder("nomor_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("perihal").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("tanggal_diterima").setSQLType(Types.DATE))
                        .addColumn(new ColumnBuilder("no_agenda").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("ket").setSQLType(Types.VARCHAR))
                        .toTable(db);
                    Table tblsk = new TableBuilder("surat_keluar").setPrimaryKey("no_urut")
                        .addColumn(new ColumnBuilder("no_urut").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("jenis_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("tanggal_surat").setSQLType(Types.DATE))
                        .addColumn(new ColumnBuilder("nomor_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("perihal").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("tanggal_keluar").setSQLType(Types.DATE))
                        .addColumn(new ColumnBuilder("surat_ditunjukan").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("cb_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("t_surat").setSQLType(Types.VARCHAR))
                        .addColumn(new ColumnBuilder("tahun").setSQLType(Types.VARCHAR))
                        .toTable(db);
                }catch(IOException IOE){
        
                }
            }else{
                System.out.println("File is Cancelled");
            }            
            if(direct == null){
                System.out.println("No File");
            }
        }
}
