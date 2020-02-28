package com.spring5.practice.service;

import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Country;
import com.spring5.practice.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService{
    @Autowired
    private CountryRepository countryRepository;
    public void save(Country country)
    {
        countryRepository.save(country);
    }

 /*   public void saveEdit(Country country){
        country.setId(country.getId());
        country.setCountryName(country.getCountryName());
        countryRepository.save(country);
    }
*/
    public List<Country> findAll()
    {
        var countries = countryRepository.findAll();
        if(countries.size() == 0)
        {
            throw new ResourceNotFoundException("No countries");
        }
       return countryRepository.findAll();
    }

    public Country findById(Long id){
        return countryRepository.findById(id).get();
    }
    public void delete(Long id)
    {
       var country =  countryRepository.findById(id).get();
       country.setActive(false);
       countryRepository.save(country);
    }

}