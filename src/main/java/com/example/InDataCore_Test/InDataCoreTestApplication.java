package com.example.InDataCore_Test;

import com.example.InDataCore_Test.Entities.Personne;
import com.example.InDataCore_Test.Services.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class InDataCoreTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InDataCoreTestApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(Service service){
		return args -> {
			ArrayList<Personne> list= (ArrayList<Personne>) service.readCsv();
			for(Personne p:list){
				System.out.println(p);
			}
		};
	}

}
