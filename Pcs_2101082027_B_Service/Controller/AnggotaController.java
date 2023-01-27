/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.pcs_2101082027_B_service.Controller;

import com.alex.pcs_2101082027_B_service.FormAnggota;
import com.alex.pcs_2101082027_B_service.Service.AnggotaService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
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
            formAnggota.getTxtAnggotaName().setText(anggota.getAnggotaName());
            formAnggota.getTxtAnggotaAddress().setText(anggota.getAnggotaAddress());
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Data Tidak Ditemukan");
        }
    }
    
    public void saveAnggota() {
        Anggota anggota = new Anggota();
        anggota.setAnggotaName(formAnggota.getTxtAnggotaName().getText());
        anggota.setAnggotaAddress(formAnggota.getTxtAnggotaAddress().getText());
        anggota = anggotaService.saveAnggota(anggota);
        if (anggota != null) {
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formAnggota, "Entri Data Gagal");
        }
    }
    
    public void updateAnggota() {
        Anggota anggota = new Anggota();
        anggota.setAnggotaId(Long.parseLong(formAnggota.getTxtAnggotaId().getText()));
        anggota.setAnggotaName(formAnggota.getTxtAnggotaName().getText());
        anggota.setAnggotaAddress(formAnggota.getTxtAnggotaAddress().getText());
        anggota = anggotaService.saveAnggota(anggota);
        if (anggota != null) {
            formAnggota.getTxtAnggotaId().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formAnggota, "Update Data Gagal");
        }
    }
    
    public void deleteAnggota(){
        Long id = Long.parseLong(formAnggota.getTxtAnggotaId().getText());
        anggotaService.deleteAnggota(id);
        JOptionPane.showMessageDialog(formAnggota, "Delete Data Berhasil");
    }
    
  
}
