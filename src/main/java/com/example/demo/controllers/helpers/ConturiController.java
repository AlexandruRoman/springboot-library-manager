package com.example.demo.controllers.helpers;

import com.example.demo.models.Cont;
import com.example.demo.repository.ConturiRepository;
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
@RequestMapping("/conturi")
public class ConturiController {

    @Autowired
    private ConturiRepository conturiRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cont> getAll() {
        return conturiRepository.findAll();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create(@RequestBody final Cont cont){
        conturiRepository.save(cont);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll(){
        conturiRepository.deleteAll();
    }
}
