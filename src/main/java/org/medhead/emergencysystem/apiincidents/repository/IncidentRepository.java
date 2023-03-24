package org.medhead.emergencysystem.apiincidents.repository;

import org.medhead.emergencysystem.apiincidents.model.Incident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
