package com.example.InDataCore_Test.Web;

import com.example.InDataCore_Test.Entities.Personne;
import com.example.InDataCore_Test.Entities.Personnes;
import com.example.InDataCore_Test.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    Service service;

    @GetMapping("/list")
    List<Personne> getListPersonnes(){
        return service.readCsv();
    }

    @PostMapping("/addPersonne")
    Personne addPersonne(@RequestBody Personne personne){
        int lastId=(Personnes.getPersonnes()).get(Personnes.getPersonnes().size()-1).getId();
        personne.setId(lastId+1);
        return service.addPersonneToCsv(personne);
    }

    @PostMapping("/addRandomPersonne")
    Personne addRandomPersonne(){
        return service.addRandomPersonne();
    }

    @DeleteMapping("/deletePersonne")
    void deletePersonne(@RequestParam int id) throws IOException {
        System.out.println("delete executed "+id);
        this.service.deletePersonne(id);
    }

    @PutMapping("/updatePersonne")
    Personne updatePersonne(@RequestBody Personne personne) throws IOException {
        System.out.println("update executed");
        return this.service.updatePersonne(personne);
    }

}
