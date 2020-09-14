package com.cs.cijferSysteem.controller;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cs.cijferSysteem.domein.Leerling;


public interface LeerlingRepository extends JpaRepository<Leerling, Long> {


	//List<Leerling> findByVoornaam(String voornaam);
	List <Leerling> findByLeerlingNummerBetween(int start, int end);
}
