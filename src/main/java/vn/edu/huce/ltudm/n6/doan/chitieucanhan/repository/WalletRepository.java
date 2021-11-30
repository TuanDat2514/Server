/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Wallet;

/**
 *
 * @author Administrator
 */
public interface WalletRepository extends JpaRepository<Wallet, Long>{
    
}
