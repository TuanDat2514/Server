/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Detail;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.DetailRepository;

/**
 *
 * @author Administrator
 */
@Service
public class DetailService {

    @Autowired
    DetailRepository repo;

    public void save(Detail detail) {
        repo.save(detail);
    }

    public List<Detail> listAll() {
        return (List<Detail>) repo.findAll();
    }
    public List<Detail> getbyUsername(String username){
        return (List<Detail>) repo.getDetailbyUsername(username);
    }
    public Detail get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }
   
            
}
