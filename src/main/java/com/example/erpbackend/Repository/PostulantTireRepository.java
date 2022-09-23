package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Postulant_tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostulantTireRepository extends JpaRepository<Postulant_tire,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant_tire(id_postulant, tirage_idtirage) VALUES(?,?);",nativeQuery = true)
    int INSERT_POST_TIRE(Long id_postulant, Long tirage_idtirage);

}
