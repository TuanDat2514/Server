/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "wallet")
public class Wallet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_wallet")
    private Long id_wallet;
    
    @Column(name = "money")
    private float money;
    
//    @OneToOne
//    @JoinColumn(name = "id_wallet",referencedColumnName = "id_wallet")
//    @JsonManagedReference
//    private Wallet wallet;
   
//    @OneToOne(mappedBy = "wallet", fetch = FetchType.EAGER)
//    private User user;
    
    public Long getId_wallet() {
        return id_wallet;
    }

    public void setId_wallet(Long id_wallet) {
        this.id_wallet = id_wallet;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    

    
}
