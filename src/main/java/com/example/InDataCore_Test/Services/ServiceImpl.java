package com.example.InDataCore_Test.Services;

import com.example.InDataCore_Test.Entities.Personne;
import com.example.InDataCore_Test.Entities.Personnes;
import jdk.jshell.execution.Util;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Component
@Builder
public class ServiceImpl implements Service {
    @Override
    public List<Personne> readCsv() {
        return Personnes.getPersonnes();
    }



    @Override
    public synchronized Personne addPersonneToCsv(Personne personne) {
        if(Personnes.getPersonnes().add(personne)){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/static/convertcsv.csv",true))) {
                // Écrire l'en-tête du fichier CSV
                writer.write(personne.getId()+",");
                writer.write(personne.getFirstName()+",");
                writer.write(personne.getLastName()+",");
                writer.write(personne.getAge()+",");
                writer.write(personne.getStreet()+",");
                writer.write(personne.getCity()+",");
                writer.write(personne.getState()+",");
                writer.write(personne.getZip()+",");
                writer.write(personne.getDollar()+",");
                writer.write(personne.getPick()+",");
                writer.write(personne.getDate());
                writer.write("\n");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return personne;
        }
        else{
            return null;
        }

    }

    @Override
    public Personne addRandomPersonne() {
        int lastId=(Personnes.getPersonnes()).get(Personnes.getPersonnes().size()-1).getId();
        Personne personne=new Personne();
        personne.setId(lastId+1);
        personne.setFirstName("inconnu");
        personne.setLastName("inconnu");
        personne.setAge((int) (Math.random()*100));
        personne.setStreet("inconnu");
        personne.setCity("inconnu");
        personne.setState("inconnu");
        personne.setZip((int) (Math.random()*10000));
        personne.setDollar(Math.random()*9999);
        personne.setPick("inconnu");
        personne.setDate("inconnu");

        if(Personnes.getPersonnes().add(personne)){
            addPersonneToCsv(personne);
            return personne;
        }
        else{
            return null;
        }
    }

    @Override
    public void deletePersonne(int id) throws IOException {
        for(Personne p:Personnes.getPersonnes()){
            if(p.getId()==id){
                Personnes.getPersonnes().remove(p);
                break;
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/static/convertcsv.csv",false));
        for(Personne personne:Personnes.getPersonnes()){
            writer.write(personne.getId()+",");
            writer.write(personne.getFirstName()+",");
            writer.write(personne.getLastName()+",");
            writer.write(personne.getAge()+",");
            writer.write(personne.getStreet()+",");
            writer.write(personne.getCity()+",");
            writer.write(personne.getState()+",");
            writer.write(personne.getZip()+",");
            writer.write(personne.getDollar()+",");
            writer.write(personne.getPick()+",");
            writer.write(personne.getDate());
            writer.write("\n");
        }
        // Close the writer
        writer.close();
    }

    @Override
    public Personne updatePersonne(Personne p) throws IOException {
        int index;
        for(Personne per:Personnes.getPersonnes()){
            if(per.getId()==p.getId()){
                index=Personnes.getPersonnes().indexOf(per);
                BeanUtils.copyProperties(p,Personnes.getPersonnes().get(index));
                System.out.println(Personnes.getPersonnes().get(index));
                break;
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/static/convertcsv.csv",false));
        for(Personne personne:Personnes.getPersonnes()){
            writer.write(personne.getId()+",");
            writer.write(personne.getFirstName()+",");
            writer.write(personne.getLastName()+",");
            writer.write(personne.getAge()+",");
            writer.write(personne.getStreet()+",");
            writer.write(personne.getCity()+",");
            writer.write(personne.getState()+",");
            writer.write(personne.getZip()+",");
            writer.write(personne.getDollar()+",");
            writer.write(personne.getPick()+",");
            writer.write(personne.getDate());
            writer.write("\n");
        }
        // Close the writer
        writer.close();
        return p;
    }
}
