/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.User;


/**
 *
 * @author Administrator
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username=?1")
    public User findOne(String id_user);
    

}
