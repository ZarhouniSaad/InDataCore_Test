package com.example.InDataCore_Test.Services;

import com.example.InDataCore_Test.Entities.Personne;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.List;

@Component
public interface Service {
    List<Personne> readCsv();

    Personne addPersonneToCsv(Personne personne);

    Personne addRandomPersonne();
    

    void deletePersonne(int p) throws IOException;

    Personne updatePersonne(Personne personne) throws IOException;
}
