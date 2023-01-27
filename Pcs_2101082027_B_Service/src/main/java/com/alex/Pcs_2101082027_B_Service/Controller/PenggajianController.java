/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.pcs_2101082027_B_service.Controller;
import com.alex.pcs_2101082027_B_service.Entity.Penggajian;
import com.alex.pcs_2101082027_B_service.Service.PenggajianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alex
 */
@RestController
@RequestMapping("/penggajian")
public class PenggajianController {
    @Autowired
    private PenggajianService penggajianService;
    
    @PostMapping("/")
    public Penggajian savePenggajian(@RequestBody Penggajian penggajian){
        return penggajianService.savePenggajian(penggajian);
    }
    
    
    @GetMapping("/")
    public List<Penggajian> getAllPeminjaman(){
        return penggajianService.getAllPenggajian();
    }
    
    @PutMapping("/")
    public Penggajian updatePenggajian(@RequestBody Penggajian penggajian){
        return penggajianService.updatePenggajian(penggajian);
    } 
     
    @DeleteMapping("/{id}")
    public void deletePeminjaman(@PathVariable("id") Long penggajianId){
        penggajianService.deletePenggajian(penggajianId);
    }
}