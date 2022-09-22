package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TirageRepository extends JpaRepository<Tirage,Long> {


}
