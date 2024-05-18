package edu.co.unisabana.mievento.repository;

import edu.co.unisabana.mievento.entities.usuario.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface IClientRepository extends CrudRepository<Cliente, Integer>{}
