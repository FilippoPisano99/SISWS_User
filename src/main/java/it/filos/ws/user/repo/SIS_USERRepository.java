package it.filos.ws.user.repo;

import it.filos.ws.user.resources.SIS_USER;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SIS_USERRepository extends CrudRepository<SIS_USER, Integer> {

}