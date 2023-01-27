/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.buku.service;

import com.alex.buku.entity.Buku;
import com.alex.buku.repository.BukuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;
    
    public Buku saveBuku(Buku buku){
        return bukuRepository.save(buku);
    }
    
    public Buku findBukuById(Long bukuId){
        return bukuRepository.findByBukuId(bukuId);
    }

    public List<Buku> getAllBuku(){
        return bukuRepository.findAll();
    }
    
    public Buku updateBuku(Buku buku){
        return bukuRepository.save(buku);
    }
    
    public void deleteById(Long bukuId) {
        bukuRepository.deleteById(bukuId);
    }
}
