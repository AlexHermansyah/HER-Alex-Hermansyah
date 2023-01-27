/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taufiq.perpustakaanclien.Controller;

import com.mycompany.taufiq.perpustakaanclien.FormPengembalian;
import com.mycompany.taufiq.perpustakaanclien.Model.Peminjaman;
import com.mycompany.taufiq.perpustakaanclien.Model.Pengembalian;
import com.mycompany.taufiq.perpustakaanclien.Service.PengembalianService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class PengembalianController {
    private final PengembalianService pengembalianService;
    private final FormPengembalian formPengembalian;    
    
    public PengembalianController(FormPengembalian formPengembalian){
        this.formPengembalian = formPengembalian;
        pengembalianService = new PengembalianService();
    }
    
    public void bersihForm(){
        formPengembalian.getTxtPengembalianId().setText("");
        formPengembalian.getTxtPeminjamanId().setText("");
        formPengembalian.getTxtTglDikembalikan().setText("");
        formPengembalian.getTxtTerlambat().setText("");
    }
    
    public void getPengembalianId(){
        Long id = Long.parseLong(formPengembalian.getTxtPeminjamanId().getText());
        Pengembalian pengembalian = pengembalianService.getPengembalian(id);
        if(pengembalian!=null){
            formPengembalian.getTxtPeminjamanId().setText(pengembalian.getPeminjamanId().toString());
            formPengembalian.getTxtTglDikembalikan().setText(pengembalian.getTglDikembalikan());
            formPengembalian.getTxtTerlambat().setText(Integer.toString(pengembalian.getTerlambat()));              
        }else{
            JOptionPane.showMessageDialog(formPengembalian, "Data Tidak Ditemukan");
        }       
    }
    
    public void savePengembalian(){
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setPeminjamanId(Long.parseLong(formPengembalian.getTxtPeminjamanId().getText()));        
        pengembalian.setTglDikembalikan(formPengembalian.getTxtTglDikembalikan().getText());
        pengembalian.setTerlambat(Integer.parseInt(formPengembalian.getTxtTerlambat().getText()));
        pengembalian = pengembalianService.savePengembalian(pengembalian);
        if(pengembalian != null){
            formPengembalian.getTxtPengembalianId().setText(pengembalian.getPengembalianId().toString());
            JOptionPane.showMessageDialog(formPengembalian, "Entry Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formPengembalian, "Entry Data Gagal");
        }
        
    }
    
    public void viewTable(){
        DefaultTableModel tableModel = (DefaultTableModel) formPengembalian.getTablePengembalian().getModel();
        tableModel.setRowCount(0);
        List<Pengembalian> pengembalianList = pengembalianService.getAllPengembalian();
        for(Pengembalian pengembalian : pengembalianList){
            Object[] row = {
                pengembalian.getPengembalianId(),
                pengembalian.getPeminjamanId(),
                pengembalian.getTglDikembalikan(),
                pengembalian.getTerlambat(),
                pengembalian.getDenda()
            };
        tableModel.addRow(row);
        }
    }
    
     public void updatePengembalian(){
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setPeminjamanId(Long.parseLong(formPengembalian.getTxtPeminjamanId().getText()));        
        pengembalian.setTglDikembalikan(formPengembalian.getTxtTglDikembalikan().getText());
        pengembalian.setTerlambat(Integer.parseInt(formPengembalian.getTxtTerlambat().getText()));
        pengembalian = pengembalianService.savePengembalian(pengembalian);
        if(pengembalian != null){
            formPengembalian.getTxtPengembalianId().setText(pengembalian.getPengembalianId().toString());
            JOptionPane.showMessageDialog(formPengembalian, "Update Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formPengembalian, "Update Data Gagal");
        }
        
    }
     
     public void deletePengembalian(){
         Long id = Long.parseLong(formPengembalian.getTxtPengembalianId().getText());
         pengembalianService.deletePengembalian(id);
         JOptionPane.showMessageDialog(formPengembalian, "Delete Data Berhasil");
     }
}
