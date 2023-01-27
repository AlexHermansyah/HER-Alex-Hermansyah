/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taufiq.perpustakaanclien.Controller;

import com.mycompany.taufiq.perpustakaanclien.FormAnggota;
import com.mycompany.taufiq.perpustakaanclien.Model.Anggota;

import com.mycompany.taufiq.perpustakaanclien.Service.AnggotaService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class AnggotaController {
    private final AnggotaService anggotaService;
    private final FormAnggota formAnggota;
    
    public AnggotaController(FormAnggota formAnggota){
        this.formAnggota = formAnggota;
        anggotaService = new AnggotaService();
    }
    
    public void bersihForm(){
        formAnggota.getTxtAnggotaId().setText("");
        formAnggota.getTxtAnggotaName().setText("");
        formAnggota.getTxtAnggotaAddress().setText("");
    }
    
    public void getAnggotaId(){
        Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
        Anggota anggota = anggotaService.getAnggota(id);
        if(anggota!=null){
            formAnggota.getTxtAnggotaName().setText(anggota.getNama());
            formAnggota.getTxtAnggotaAddress().setText(anggota.getAlamat());
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Data Tidak Ditemukan");
        }
    }
    
    public void saveAnggota(){
        Anggota anggota = new Anggota();
        anggota.setNama(formAnggota.getTxtAnggotaName().getText());
        anggota.setAlamat(formAnggota.getTxtAnggotaAddress().getText());
        anggota = anggotaService.saveAnggota(anggota);
        if(anggota != null){
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Entry Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Entry Data Gagal");
        }
        
    }
    
    public void viewTable(){
        DefaultTableModel tableModel = (DefaultTableModel) formAnggota.getTabelAnggota().getModel();
        tableModel.setRowCount(0);
        List<Anggota> anggotaList = anggotaService.getAllAnggota();
        for(Anggota anggota : anggotaList){
            Object[] row = {
                anggota.getAnggotaId(),
                anggota.getNama(),
                anggota.getAlamat()
            };
        tableModel.addRow(row);
        }
    }
    
     public void updateAnggota(){
        Anggota anggota = new Anggota();
        anggota.setAnggotaId(Long.parseLong(formAnggota.getTxtAnggotaId().getText()));
        anggota.setNama(formAnggota.getTxtAnggotaName().getText());
        anggota.setAlamat(formAnggota.getTxtAnggotaAddress().getText());
        anggota = anggotaService.saveAnggota(anggota);
        if(anggota != null){
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Update Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Update Data Gagal");
        }
        
    }
     
     public void deleteAnggota(){
         Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
         anggotaService.deleteAnggota(id);
         JOptionPane.showMessageDialog(formAnggota, "Delete Data Berhasil");
     }
}
