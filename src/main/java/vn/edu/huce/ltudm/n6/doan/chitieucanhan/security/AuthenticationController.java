/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.User;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.UserRepository;

/**
 *
 * @author Administrator
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam(value = "username",
                    defaultValue = "") String username,
            @RequestParam(value = "password",
                    defaultValue = "") String password
    ) {
        User user = userRepository.findOne(username);
        if (user != null) {
            return new ResponseEntity<>(user,
                    HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(null,
                    HttpStatus.valueOf(404));
        }
    }
}
