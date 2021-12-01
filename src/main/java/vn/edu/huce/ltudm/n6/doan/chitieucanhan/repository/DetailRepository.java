/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.edu.huce.ltudm.n6.doan.chitieucanhan.entity.Detail;
/**
 *
 * @author Administrator
 */
public interface DetailRepository extends JpaRepository<Detail,Long> {
   @Query(value = "SELECT u FROM Detail u WHERE u.username=:username")
   List<Detail> getDetailbyUsername(@Param("username")String username);
}
