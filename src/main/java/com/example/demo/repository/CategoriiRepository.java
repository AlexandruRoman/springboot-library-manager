package com.example.demo.repository;

import com.example.demo.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 12/27/2017.
 */
@Component
public interface CategoriiRepository extends JpaRepository<Categorie, Long> {
    Categorie findByNume(String categorie);
}
