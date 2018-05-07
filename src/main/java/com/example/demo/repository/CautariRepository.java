package com.example.demo.repository;

import com.example.demo.models.Cautare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Alex on 12/28/2017.
 */
public interface CautariRepository extends JpaRepository<Cautare, Long> {
    Cautare findByIdContAndIdCuvant(long idCont, long idCuvant);
    List<Cautare> findAllByIdContOrderByNumarAccesariDesc(long idCont);
}
