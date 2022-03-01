/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Wallet;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.WalletRepository;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.service.WalletService;

/**
 *
 * @author Administrator
 */
@CrossOrigin
@RestController
@RequestMapping("/wallet")
public class WalletController {
   @Autowired
   WalletRepository walletRepository;
   
    WalletService walletService;
 
//    @CrossOrigin
//    @PutMapping("/id_wallet")
//    public ResponseEntity<?> put(@PathVariable Long id_wallet,@RequestBody Wallet wallet) {
//         walletService.update(id_wallet,wallet);
//         return new ResponseEntity<>(null,HttpStatus.valueOf(303)); 
//    }
    @CrossOrigin
   @GetMapping("/get/{id_wallet}")
    public Optional<Wallet> get(@PathVariable Long id_wallet) {
        return walletRepository.findById(id_wallet);
    }
    @CrossOrigin
    @PutMapping("/update/{id_wallet}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable Long id_wallet, @RequestBody Wallet wallet) {
        Optional<Wallet> walletOptional = walletRepository.findById(id_wallet);
        return walletOptional.map(wallet1 -> {
            wallet.setId_wallet(wallet1.getId_wallet());
            return new ResponseEntity<>(walletRepository.save(wallet), HttpStatus.valueOf(303));
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
