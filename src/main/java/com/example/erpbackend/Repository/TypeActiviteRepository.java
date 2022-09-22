package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Type_activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeActiviteRepository extends JpaRepository<Type_activite, Long> {
}
