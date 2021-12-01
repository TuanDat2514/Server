/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Detail;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.User;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Wallet;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.UserRepository;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.service.UserService;

/**
 *
 * @author Administrator
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    private UserService userService;
    
    @GetMapping("/get/{id_user}")
    public Optional<User> get(@PathVariable Long id_user) {
        return userRepository.findById(id_user);
    }
    @GetMapping("/all")
    public List<User> list() {
        return userRepository.findAll();
    }
}
