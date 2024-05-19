package edu.co.unisabana.mievento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.co.unisabana.mievento.entities.personal.Personal;

@Repository
public interface IPersonalRepository extends CrudRepository<Personal,Integer> {
}
