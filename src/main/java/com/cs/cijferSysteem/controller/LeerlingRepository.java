package com.cs.cijferSysteem.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cs.cijferSysteem.domein.Leerling;

public interface LeerlingRepository extends JpaRepository<Leerling, Long> {

}
