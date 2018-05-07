package com.example.demo.repository;

import com.example.demo.models.Cont;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alex on 12/27/2017.
 */
@Component
public interface ConturiRepository extends JpaRepository<Cont, Long> {
    Cont findByNume(String nume);
    List<Cont> findAllByIdStatus(short id);
}
