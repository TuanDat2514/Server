/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.User;


/**
 *
 * @author Administrator
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username=:username")
    public User findOne(@Param("username")String id_user);

    
}
