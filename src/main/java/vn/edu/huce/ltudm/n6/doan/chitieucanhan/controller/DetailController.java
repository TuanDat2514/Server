/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.controller;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Detail;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Wallet;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.DetailRepository;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.WalletRepository;
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
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private WalletRepository walletRepository;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<?> addDetail(@RequestBody Detail newDetail, Wallet wallet) {
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
    @GetMapping("/all/get/{username}")
    public List<Detail> getDetails(@PathVariable String username, @RequestParam Date startDate, @RequestParam Date endDate) {

        return (List<Detail>) detailRepository.getDetail(username, startDate, endDate);
    }

    @CrossOrigin
    @GetMapping("/all/{username}")
    public List<Detail> getDetailbyUsername(@PathVariable String username) {
        return (List<Detail>) detailService.getbyUsername(username);
    }

    @CrossOrigin
    @DeleteMapping("delete/{id_detail}")
    public ResponseEntity<Detail> delete(@PathVariable Long id_detail) {
        detailService.delete(id_detail);
        return new ResponseEntity<>(null,
                HttpStatus.valueOf(204));
    }

    @CrossOrigin
    @GetMapping("/category/{username}")
    public List<?> getSumbyCategory(@PathVariable String username) {
        return detailRepository.getSumbyCategory(username);
    }

    @CrossOrigin
    @GetMapping("/category/spend/{username}")
    public List<?> getSumSpendbyCategoryDate(@PathVariable String username, @RequestParam Date startDate, @RequestParam Date endDate) {
        return detailRepository.getSumSpendbyCategoryDate(username, startDate, endDate);
    }

    @CrossOrigin
    @GetMapping("/category/income/{username}")
    public List<?> getSumInbyCategoryDate(@PathVariable String username, @RequestParam Date startDate, @RequestParam Date endDate) {
        return detailRepository.getSumInbyCategoryDate(username, startDate, endDate);
    }

    @CrossOrigin
    @GetMapping("/month/{username}")
    public List<?> getDatabyEMonth(@PathVariable String username, @RequestParam int year) {
        return detailRepository.getDataSpendbyMonth(username, year);
    }

    @CrossOrigin
    @GetMapping("/year/{username}")
    public List<?> getDatabyYear(@PathVariable String username, @RequestParam int year) {
        return detailRepository.getDetailbyYear(username, year);
    }

    @CrossOrigin
    @PutMapping("/update/{id_detail}")
    public ResponseEntity<?> put(@PathVariable Long id_detail,@RequestBody Detail input) {
        Optional<Detail> detailOptional = detailRepository.findById(id_detail);
        return detailOptional.map(detail1 -> {
            input.setId_detail(detail1.getId_detail());
            return new ResponseEntity<>(detailRepository.save(input), HttpStatus.valueOf(303));
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
