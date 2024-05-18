package edu.co.unisabana.mievento.repository;

import org.springframework.data.repository.CrudRepository;

import edu.co.unisabana.mievento.entities.personal.Personal;

public interface IPersonalRepository extends CrudRepository<Personal,Long> {
}
