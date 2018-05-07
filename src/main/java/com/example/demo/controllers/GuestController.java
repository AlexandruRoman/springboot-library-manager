package com.example.demo.controllers;

import com.example.demo.models.Cont;
import com.example.demo.repository.ConturiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex on 12/27/2017.
 */
@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private ConturiRepository conturiRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String signup(@RequestBody final Cont cont){
        if(cont.getNume() == "" || cont.getParola() == "")
            return "Cele 2 campuri sunt obligatorii.";

        if(conturiRepository.findByNume(cont.getNume()) != null)
            return "Acest nume de utilizator este deja inregistrat in baza de date.";

        Cont newCont = new Cont(cont.getNume(), cont.getParola(), (short)2, (short)2);
        conturiRepository.save(newCont);
        return "Cont creat cu succes!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestBody final Cont cont){
        Cont c = conturiRepository.findByNume(cont.getNume());
        if(c == null)
            return "Numele de cont nu a fost gasit in baza de date.";
        String parola = c.getParola();
        if(!cont.getParola().equals(parola))
            return "Parola introdusa este gresita.";

        if(c.getIdStatus() == (short)1){
            return "Bine ai venit " + c.getNume() + "!";
        } else if(c.getIdStatus() == (short)2){
            return "Contul nu a fost inca acceptat de catre un admin.";
        } else if(c.getIdStatus() == (short)3) {
            return "Contul a fost respins de catre un admin.";
        }

        return "";
    }
}
