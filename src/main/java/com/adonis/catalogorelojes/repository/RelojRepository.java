package com.adonis.catalogorelojes.repository;

import com.adonis.catalogorelojes.model.Reloj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelojRepository extends JpaRepository<Reloj, Long> {
}