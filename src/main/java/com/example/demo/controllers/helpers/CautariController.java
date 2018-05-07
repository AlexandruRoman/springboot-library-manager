package com.example.demo.controllers.helpers;

import com.example.demo.models.Cautare;
import com.example.demo.repository.CautariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cautari")
public class CautariController {

    @Autowired
    private CautariRepository cautariRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cautare> getAll() {
        return cautariRepository.findAll();
    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public void create(@RequestBody final Cautare cautare){
//        cautariRepository.save(cautare);
//    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll(){
        cautariRepository.deleteAll();
    }
}