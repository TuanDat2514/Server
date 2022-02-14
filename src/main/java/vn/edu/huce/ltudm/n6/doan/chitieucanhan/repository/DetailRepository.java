/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.repository;

import java.util.ArrayList;
import java.util.Date;
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
public interface DetailRepository extends JpaRepository<Detail, Long> {

    @Query(value = "SELECT u FROM Detail u WHERE u.username=:username ")
    List<Detail> getDetailbyUsername(@Param("username") String username);

    @Query(value = "select gd from Detail gd where gd.username=?1 and (gd.date between ?2 and ?3)")
    List<Detail> getDetail(String username, Date startDate, Date endDate);

    @Query(value = "select sum(gd.price)as sum,gd.id_category as id from Detail gd where gd.username=?1 and status=1 and (gd.date between ?2 and ?3) group by id_category ")
    List<Integer> getSumSpendbyCategoryDate(String username, Date startDate, Date endDate);

    @Query(value = "select sum(gd.price)as sum,gd.id_category as id from Detail gd where gd.username=?1 and status=0 and (gd.date between ?2 and ?3) group by id_category ")
    List<Integer> getSumInbyCategoryDate(String username, Date startDate, Date endDate);

    @Query(value = "select sum(gd.price) as sum ,gd.id_category as id from Detail gd where username=?1 and status=1 group by id_category")
    List<?> getSumbyCategory(String username);

    @Query(value = "SELECT sum(gd.price) as sum ,month(gd.date),gd.status FROM Detail gd WHERE username=?1 and YEAR(gd.date)=?2 group by month(gd.date),gd.status")
    List<?> getDataSpendbyMonth(String username,int year);
    
    @Query(value = "SELECT gd FROM Detail gd WHERE username=?1 and YEAR(gd.date)=?2")
    List<?> getDetailbyYear(String username,int year);
}
