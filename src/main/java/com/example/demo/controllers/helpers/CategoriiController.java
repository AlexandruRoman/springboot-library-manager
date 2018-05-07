package com.example.demo.controllers.helpers;

import com.example.demo.models.Categorie;
import com.example.demo.models.Cont;
import com.example.demo.repository.CategoriiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alex on 12/27/2017.
 */
@RestController
@RequestMapping("/categorii")
public class CategoriiController {

    @Autowired
    private CategoriiRepository categoriiRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categorie> getAll() {
        return categoriiRepository.findAll();
    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public void create(@RequestBody final Categorie categorie){
//        categoriiRepository.save(categorie);
//    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll(){
        categoriiRepository.deleteAll();
    }
}
