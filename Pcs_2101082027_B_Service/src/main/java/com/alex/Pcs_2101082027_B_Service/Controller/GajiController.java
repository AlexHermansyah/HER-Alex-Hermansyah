/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.pcs_2101082027_B_service.Controller;

import com.alex.pcs_2101082027_B_service.FormGaji;
import com.mycompany.fikri.perpustakaanclient.Service.GajiService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class GajiController {
    private final GajiService bukuService;
    private final FormGaji formGaji;
    
    public GajiController(FormGaji formGaji){
        this.formBuku = formBuku;
        bukuService = new BukuService();
    }
    
    public void bersihForm(){
        formBuku.getTxtBukuId().setText("");
        formBuku.getTxtBukuKode().setText("");
        formBuku.getTxtBukuJudul().setText("");
        formBuku.getTxtBukuPenerbit().setText("");
        formBuku.getTxtBukuTahunTerbit().setText("");
    }
    
    public void getBukuId(){
        Long id = Long.parseLong(formBuku.getTxtBukuId().getText());
        Buku buku = bukuService.getBuku(id);
        if(buku!=null){
            formBuku.getTxtBukuKode().setText(buku.getKode());
            formBuku.getTxtBukuJudul().setText(buku.getJudul());
            formBuku.getTxtBukuPenerbit().setText(buku.getKode());
            formBuku.getTxtBukuTahunTerbit().setText(buku.getKode());
        }else{
            JOptionPane.showMessageDialog(formBuku, "Data Tidak Ditemukan");
        }
    }
    
    public void saveBuku() {
        Buku buku = new Buku();
        buku.setKode(formBuku.getTxtBukuKode().getText());
        buku.setJudul(formBuku.getTxtBukuJudul().getText());
        buku.setPenerbit(formBuku.getTxtBukuPenerbit().getText());
        buku.setTahunTerbit(formBuku.getTxtBukuTahunTerbit().getText());
        buku = bukuService.saveBuku(buku);
        if (buku != null) {
            formBuku.getTxtBukuId().setText(buku.getBukuId().toString());
            JOptionPane.showMessageDialog(formBuku, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formBuku, "Entri Data Gagal");
        }
    }
    
     public void updateBuku() {
        Buku buku = new Buku();
        buku.setBukuId(Long.parseLong(formBuku.getTxtBukuId().getText()));
        buku.setKode(formBuku.getTxtBukuKode().getText());
        buku.setJudul(formBuku.getTxtBukuJudul().getText());
        buku.setPenerbit(formBuku.getTxtBukuPenerbit().getText());
        buku.setTahunTerbit(formBuku.getTxtBukuTahunTerbit().getText());
        buku = bukuService.saveBuku(buku);
        if (buku != null) {
            formBuku.getTxtBukuId().setText(buku.getBukuId().toString());
            JOptionPane.showMessageDialog(formBuku, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formBuku, "Update Data Gagal");
        }
    }
    
    public void deleteBuku(){
        Long id = Long.parseLong(formBuku.getTxtBukuId().getText());
        bukuService.deleteBuku(id);
        JOptionPane.showMessageDialog(formBuku, "Delete Data Berhasil");
    }
    
    public void viewTabel(){
        DefaultTableModel tabelModel = (DefaultTableModel) formBuku.getTabelBuku().getModel();
        tabelModel.setRowCount(0);
        List<Buku> bukuList = bukuService.getAllBuku();
        for(Buku buku : bukuList){
            Object[] row = {
                buku.getBukuId(),
                buku.getKode(),
                buku.getJudul(),
                buku.getPenerbit(),
                buku.getTahunTerbit()
            };
            tabelModel.addRow(row);
        }
    } 
}
