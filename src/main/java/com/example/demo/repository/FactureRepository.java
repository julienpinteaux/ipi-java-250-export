package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	public List<Facture> findAllByClientId(Long id);
}
