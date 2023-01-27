/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.pcs_2101082027_B_service.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alex
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Penggajian {
    private Long Nama;
    private Long IdAnggota;
    private String KodeSlip;
    private String tgl;
    private String golongan;
    private String potongan;
    private String gb;
    
}
