package edu.co.unisabana.mievento.repository;

import edu.co.unisabana.mievento.entities.usuario.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository; // Add this import statement

@Repository
public interface IClientRepository extends CrudRepository<Cliente,Integer>{}
