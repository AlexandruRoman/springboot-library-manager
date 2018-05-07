package com.example.demo.controllers.helpers;

import com.example.demo.models.Cuvant;
import com.example.demo.repository.CuvinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alex on 12/27/2017.
 */
@RestController
@RequestMapping("/cuvinte")
public class CuvinteController {

    @Autowired
    private CuvinteRepository cuvinteRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cuvant> getAll() {
        return cuvinteRepository.findAll();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create(@RequestBody final Cuvant cuvant){
        cuvinteRepository.save(cuvant);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll(){
        cuvinteRepository.deleteAll();
    }
}
