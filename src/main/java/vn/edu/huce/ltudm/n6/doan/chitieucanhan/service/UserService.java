/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.User;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository.UserRepository;

/**
 *
 * @author Administrator
 */
public class UserService {
    @Autowired
    UserRepository repo;

    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
   
    public User get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
  
}
