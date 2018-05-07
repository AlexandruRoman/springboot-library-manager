package com.example.demo.controllers;

import com.example.demo.models.Categorie;
import com.example.demo.models.Cautare;
import com.example.demo.models.Cont;
import com.example.demo.models.Cuvant;
import com.example.demo.models.helpers.Prefix;
import com.example.demo.repository.CategoriiRepository;
import com.example.demo.repository.CautariRepository;
import com.example.demo.repository.ConturiRepository;
import com.example.demo.repository.CuvinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Alex on 12/27/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CategoriiRepository categoriiRepository;
    @Autowired
    private CuvinteRepository cuvinteRepository;
    @Autowired
    private ConturiRepository conturiRepository;
    @Autowired
    private CautariRepository cautariRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public void changePassword(@RequestBody final Cont cont){
        if(conturiRepository.findOne(cont.getId()) == null)
            return;
        Cont c = conturiRepository.findOne(cont.getId());
        c.setParola(cont.getParola());
        conturiRepository.save(c);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cuvinte/getid")
    public String getWordIdByName(@RequestBody final Cuvant cuvant){
        return "" + cuvinteRepository.findByNume(cuvant.getNume()).getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categorii/getid")
    public String getCategoryIdByName(@RequestBody final Categorie categorie){
        return "" + categoriiRepository.findByNume(categorie.getNume()).getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/conturi/getid")
    public String getAccountIdByName(@RequestBody final Cont cont){
        return "" + conturiRepository.findByNume(cont.getNume()).getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cuvinte/categorie/{id}")
    public List<Cuvant> listAllWordsByCategory(@PathVariable("id") long id){
        if(categoriiRepository.findOne(id) == null)
            return null;
        return cuvinteRepository.findAllByIdCategorie(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cuvinte/{id_cont}+{id_cuvant}")
    public Cuvant getWord(@PathVariable("id_cont") long idCont, @PathVariable("id_cuvant") long idCuvant){
        //incrementeaza numarul de cautari al cuvantului global
        Cuvant cuvant = cuvinteRepository.findOne(idCuvant);
        if(cuvant != null){
            cuvant.setNumarAccesari(cuvant.getNumarAccesari() + 1);
            cuvinteRepository.save(cuvant);
        }

        //incrementeaza numarul de cautari al cuvantului pentru contul in cauza
        Cautare cautare = cautariRepository.findByIdContAndIdCuvant(idCont, idCuvant);
        if(cautare != null){
            cautare.setNumarAccesari(cautare.getNumarAccesari() + 1);
            cautariRepository.save(cautare);
        }

        return cuvant;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cuvinte/litere")
    public List<Character> listLetters(){

        return cuvinteRepository.findAll()
                .stream()
                .map(cuvant -> cuvant.getNume().charAt(0))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cuvinte/litera/{litera}")
    public List<Cuvant> listWordsStartingWithLetter(@PathVariable("litera") String litera){
        return cuvinteRepository.findAllByNumeStartingWith(litera);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cuvinte/prefix")
    public List<Cuvant> listPrefixedWords(@RequestBody Prefix prefixParameter){
        String prefix = prefixParameter.getPrefix();
        long idCont = prefixParameter.getIdCont();

        //sorteaza dupa cautare
        List<Cautare> aux = cautariRepository.findAllByIdContOrderByNumarAccesariDesc(idCont);
        List<Cuvant> cuvinte = cuvinteRepository.findAllByNumeStartingWith(prefix);

        Map<Long, Cuvant> map = new HashMap<>();
        cuvinte.forEach(cuvant -> map.put(cuvant.getId(), cuvant));

        List<Cuvant> result = new ArrayList<>();
        aux.forEach(cautare -> {
            if(map.containsKey(cautare.getIdCuvant())){
                result.add(map.get(cautare.getIdCuvant()));
            }
        });

        return result;
    }
}
























