package com.cs.cijferSysteem.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.cijferSysteem.domein.Cijfer;

public interface CijferRepository extends JpaRepository <Cijfer, Long> {

}
