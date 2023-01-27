/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.pcs_2101082027_B_service.Service;

import com.alex.pcs_2101082027_B_service.Entity.Penggajian;
import com.alex.pcs_2101082027_B_service.Repository.PenggajianRepository;
import com.alex.pcs_2101082027_B_service.Vo.Anggota;
import com.alex.pcs_2101082027_B_service.Vo.Gaji;
import com.alex.pcs_2101082027_B_service.Vo.ResponseTemplateVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author alex
 */
@Service
public class PenggajianService {
    @Autowired
    private PenggajianRepository penggajianRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
   
    public Penggajian savePeminjaman(Penggajian penggajian) {
       return penggajianRepository.save(penggajian); 
    }

     public ResponseTemplateVO getPenggajian(Long IdAnggota){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Penggajian penggajian = penggajianRepository.findByPenggajianId(penggajianId);
        Anggota anggota = restTemplate.getForObject("http://localhost:8111/anggota/" 
              + penggajian.getAnggotaId(), Anggota.class);
        Gaji gaji = restTemplate.getForObject("http://localhost:8117/buku/" 
                + penggajian.getGajiId(), Gaji.class);
        vo.setPenggajian(penggajian);
        vo.setAnggota(anggota);
        vo.setGaji(gaji);
        return vo;
    }
     
     
     
    public List<Penggajian> getAllPenggajian(){
        return penggajianRepository.findAll();
    }
    
    public void deletePenggajian(Long IdAnggota) {
        penggajianRepository.deleteById(IdAnggota);
    }
    
    public Penggajian updatePenggajian(Penggajian penggajian){
        return penggajianRepository.save(penggajian);
    }
}
