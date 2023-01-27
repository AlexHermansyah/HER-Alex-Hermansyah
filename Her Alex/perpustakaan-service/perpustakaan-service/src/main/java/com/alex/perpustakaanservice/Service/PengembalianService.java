/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taufiq.perpustakaanclien.Service;

import com.google.gson.Gson;
import com.mycompany.taufiq.perpustakaanclien.Model.Peminjaman;
import com.mycompany.taufiq.perpustakaanclien.Model.Pengembalian;
import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author user
 */
public class PengembalianService {

    private final String URL1 = "http://localhost:9009";
    
    public Pengembalian getPengembalian(Long pengembalianId){
        Pengembalian pengembalian = Unirest.get(URL1+"/pengembalian/"+pengembalianId).asObject(Pengembalian.class).getBody();
        if (pengembalian!=null){
            return pengembalian;
        }
        return null;
    }
    
//    public Peminjaman getPeminjaman(Long peminjamanId){
//        Peminjaman peminjaman = Unirest.get(URL+"/peminjaman/"+peminjamanId).asObject(Peminjaman.class).getBody();
//        if (peminjaman!=null){
//            return peminjaman;
//        }
//        return null;
//    }
    
    
    public List<Pengembalian> getAllPengembalian(){
        List<Pengembalian> pengembalianList = Unirest.get(URL1 + "/pengembalian/")
                .asObject(new GenericType<List<Pengembalian>>(){})
                .getBody();
        return pengembalianList;
    }
    
    public Pengembalian savePengembalian(Pengembalian pengembalian){
        HttpResponse<JsonNode> response = Unirest.post(URL1 + "/pengembalian/")
                .header("content-type","application/json")
                .body(pengembalian)
                .asJson();
        Gson gson = new Gson();
        Pengembalian p1 = gson.fromJson(response.getBody().toString(),Pengembalian.class);
        return p1;
    }
    
    public Pengembalian updatePengembalian(Pengembalian pengembalian){
        HttpResponse<JsonNode> response = Unirest.put(URL1 + "/pengembalian/")
                .header("content-type","application/json")
                .body(pengembalian)
                .asJson();
        Gson gson = new Gson();
        Pengembalian p1 = gson.fromJson(response.getBody().toString(),Pengembalian.class);
        return p1;
    }
    
    public void deletePengembalian(Long pengembalianId){
        Unirest.delete(URL1 + "/pengembalian/"+pengembalianId).asEmpty();
    }
}
