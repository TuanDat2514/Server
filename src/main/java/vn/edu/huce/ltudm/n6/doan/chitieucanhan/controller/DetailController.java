/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Detail;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.service.DetailService;

/**
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/detail")
public class DetailController {
    
    @Autowired
    private DetailService detailService;
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<?> addDetail(@RequestBody Detail newDetail) {
        detailService.save(newDetail);
        return new ResponseEntity<>(null, HttpStatus.valueOf(200));
    }
    @CrossOrigin
    @GetMapping("/{id_detail}")
    public Detail getDetail(@PathVariable Long id_detail) {
        return detailService.get(id_detail);
    }
    @CrossOrigin
    @GetMapping("/all")
    public List<Detail> details() {
        return detailService.listAll();
    }
    @CrossOrigin
    @GetMapping("/all/{username}")
    public List<Detail> getdetailsbyUser(@PathVariable String username) {
        return (List<Detail>) detailService.getbyUsername(username);
    }
    
}
