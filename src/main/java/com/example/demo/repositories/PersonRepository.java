package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    @Query(value = "SELECT person_id FROM tb_m_person WHERE email = ?1", nativeQuery = true)
    public Integer findIdByEmail(String email);
}
