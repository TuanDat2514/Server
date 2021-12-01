/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Detail;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Wallet;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.WalletRepository;

/**
 *
 * @author Administrator
 */
public class WalletService {
     @Autowired
     WalletRepository repo;
     WalletService walletService;
    public void save(Wallet wallet) {
        repo.save(wallet);
    }
    public Wallet get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
