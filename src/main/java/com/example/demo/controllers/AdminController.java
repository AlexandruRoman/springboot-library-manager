package com.example.demo.controllers;

import com.example.demo.models.Categorie;
import com.example.demo.models.Cautare;
import com.example.demo.models.Cont;
import com.example.demo.models.Cuvant;
import com.example.demo.repository.CategoriiRepository;
import com.example.demo.repository.CautariRepository;
import com.example.demo.repository.ConturiRepository;
import com.example.demo.repository.CuvinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alex on 12/27/2017.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoriiRepository categoriiRepository;
    @Autowired
    private CuvinteRepository cuvinteRepository;
    @Autowired
    private ConturiRepository conturiRepository;
    @Autowired
    private CautariRepository cautariRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/categorii/add")
    public void addCategory(@RequestBody final Categorie categorie){
        if(categoriiRepository.findByNume(categorie.getNume()) != null)
            return;
        categoriiRepository.save(categorie);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/categorii/update")
    public void updateCategory(@RequestBody final Categorie categorie){
        if(categoriiRepository.findOne(categorie.getId()) == null)
            return;
        categoriiRepository.save(categorie);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/categorii/delete/{id}")
    public void deleteCategory(@PathVariable("id") long id){
        if(categoriiRepository.findOne(id) == null)
            return;
        categoriiRepository.delete(id);
        //sterge toate cuvintele apartinand acestei categorii
        List<Cuvant> cuvinte = cuvinteRepository.findAllByIdCategorie(id);
        cuvinteRepository.delete(cuvinte);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cuvinte/add")
    public void addWord(@RequestBody final Cuvant cuvant){
        if(cuvinteRepository.findByNume(cuvant.getNume()) != null)
            return;
        cuvant.setNumarAccesari(0);
        cuvinteRepository.save(cuvant);

        //pentru fiecare user adauga cuvantul in tabela "cautari"
        long idCuvant = cuvinteRepository.findByNume(cuvant.getNume()).getId();
        conturiRepository.findAll().forEach(cont -> cautariRepository.save(new Cautare(cont.getId(), idCuvant)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cuvinte/update")
    public void updateWord(@RequestBody final Cuvant cuvant){
        if(cuvinteRepository.findOne(cuvant.getId()) == null)
            return;
        cuvinteRepository.save(cuvant);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cuvinte/delete/{id}")
    public void deleteWord(@PathVariable("id") long id){
        if(cuvinteRepository.findOne(id) == null)
            return;
        cuvinteRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/conturi/accept/{id}")
    public void acceptAccount(@PathVariable("id") long id){
        if(conturiRepository.findOne(id) == null)
            return;
        Cont cont = conturiRepository.findOne(id);
        cont.setIdStatus((short)1);
        conturiRepository.save(cont);

        //pentru fiecare cuvant adauga userul in tabela "cautari"
//        cuvinteRepository.findAll().forEach(cuvant -> cautariRepository.save(new Cautare(id, cuvant.getId())));
        for(Cuvant cuvant : cuvinteRepository.findAll()){
            cautariRepository.save(new Cautare(id, cuvant.getId()));
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/conturi/reject/{id}")
    public void rejectAccount(@PathVariable("id") long id){
        if(conturiRepository.findOne(id) == null)
            return;
        Cont cont = conturiRepository.findOne(id);
        cont.setIdStatus((short)3);
        conturiRepository.save(cont);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/conturi/accepted")
    public List<Cont> listAcceptedAccounts(){
        return conturiRepository.findAllByIdStatus((short)1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/conturi/rejected")
    public List<Cont> listRejectedAccounts(){
        return conturiRepository.findAllByIdStatus((short)3);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cuvinte")
    public List<Cuvant> listAllWords(){
        return cuvinteRepository.findAll();
    }
}
