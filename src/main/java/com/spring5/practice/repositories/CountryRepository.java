package com.spring5.practice.repositories;

import com.spring5.practice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository

@Transactional

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryName(String countryName);

    List<Country> findAll();

}