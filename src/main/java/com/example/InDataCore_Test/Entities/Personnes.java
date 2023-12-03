package com.example.InDataCore_Test.Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Personnes {
    private static ArrayList<Personne> personnes=new ArrayList<>();
    private Personnes(){}

    static {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/convertcsv.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                //personneList.add(Arrays.asList(values));
                Personne personne= new Personne();
                personne.setId(Integer.parseInt(values[0]));
                personne.setFirstName(values[1]);
                personne.setLastName(values[2]);
                personne.setAge(Integer.parseInt(values[3]));
                personne.setStreet(values[4]);
                personne.setCity(values[5]);
                personne.setState(values[6]);
                personne.setZip(Integer.parseInt(values[7]));
                personne.setDollar(Double.parseDouble(values[8]));
                personne.setPick(values[9]);
                personne.setDate(values[10]);

                personnes.add(personne);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Personne> getPersonnes() {
        return personnes;
    }
}
