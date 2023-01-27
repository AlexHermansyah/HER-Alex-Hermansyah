/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alex.pcs_2101082027_B_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alex
 */
    public interface PenggajianRepository extends JpaRepository<Penggajian, Long>{

    public Penggajian findByPenggajianId(Long IdAnggota);
}
