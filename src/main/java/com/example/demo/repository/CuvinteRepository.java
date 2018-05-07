package com.example.demo.repository;

import com.example.demo.models.Cuvant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 12/27/2017.
 */
@Component
public interface CuvinteRepository extends JpaRepository<Cuvant, Long>{

    Cuvant findByNume(String nume);
    List<Cuvant> findAllByIdCategorie(long idCategorie);
    List<Cuvant> findAllByNumeStartingWith(String prefix);
}
