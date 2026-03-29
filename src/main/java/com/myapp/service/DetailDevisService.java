package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.DetailDevis;
import com.myapp.repository.DetailDevisRepository;

@Service
public class DetailDevisService {
    @Autowired
    DetailDevisRepository detailDevisRepository;

    public List<DetailDevis> getAllDetailDevis(){
        return detailDevisRepository.findAll();
    }

    public DetailDevis getDetailDevisById(Integer id){
        return detailDevisRepository.findById(id).orElse(null);
    }

    public DetailDevis saveDetail(DetailDevis detailDevis){
        return detailDevisRepository.save(detailDevis);
    }

    public void deleteDetail(Integer id){
        detailDevisRepository.deleteById(id);
    }

}
