package org.medhead.emergencysystem.apiincidents.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.medhead.emergencysystem.apiincidents.repository.IncidentRepository;
import org.medhead.emergencysystem.apiincidents.model.Incident;

import java.util.Optional;

@Data
@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public Optional<Incident> getIncident(final Long id) { return incidentRepository.findById(id); }

    public Iterable<Incident> getIncidents() { return incidentRepository.findAll(); }

    public void deleteIncident(final Long id) { incidentRepository.deleteById(id); }

    public Incident saveIncident(Incident incident) {
        Incident savedIncident = incidentRepository.save(incident);
        return savedIncident;
    }
}
