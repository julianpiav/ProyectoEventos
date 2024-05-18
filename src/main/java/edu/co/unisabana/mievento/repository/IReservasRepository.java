package edu.co.unisabana.mievento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.co.unisabana.mievento.entities.reserva.Reserva;

@Repository
public interface IReservasRepository extends CrudRepository<Reserva,Long> {}
