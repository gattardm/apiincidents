package org.medhead.emergencysystem.apiincidents.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.medhead.emergencysystem.apiincidents.model.Incident;
import org.medhead.emergencysystem.apiincidents.service.IncidentService;

@RestController
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    /**
     * Create - Add a new incident
     *
     * @param incident An object incident
     * @return The incident object saved
     */
    @PostMapping("/incident")
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.saveIncident(incident);
    }

    /**
     * Read - Get one incident
     *
     * @param id The id of the incident
     * @return A Incident object fulfilled
     */
    @GetMapping("/incident/{id}")
    public Incident getIncident(@PathVariable("id") final Long id) {
        Optional<Incident> incident = incidentService.getIncident(id);
        if (incident.isPresent()) {
            return incident.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all incidents
     *
     * @return - An Iterable object of Incident fulfilled
     */
    @GetMapping("/incidents")
    public Iterable<Incident> getIncidents() {
        return incidentService.getIncidents();
    }

    /**
     * Update - Update an existing incident
     *
     * @param id       - The id of the incident to update
     * @param incident - The incident object updated
     * @return
     */
    @PutMapping("/incident/{id}")
    public Incident updateIncident(@PathVariable("id") final Long id, @RequestBody Incident incident) {
        Optional<Incident> i = incidentService.getIncident(id);
        if (i.isPresent()) {
            Incident currentIncident = i.get();

            String type = incident.getType();
            if (type != null) currentIncident.setType(type);

            String longitude = incident.getLongitude();
            if (longitude != null) currentIncident.setLongitude(longitude);

            String latitude = incident.getLatitude();
            if (latitude != null) currentIncident.setLatitude(latitude);

            String specialityNeeded = incident.getSpecialityNeeded();
            if (specialityNeeded != null) currentIncident.setSpecialityNeeded(specialityNeeded);

            String traitement = incident.getTraitement();
            if (traitement != null) currentIncident.setTraitement(traitement);

            incidentService.saveIncident(currentIncident);
            return currentIncident;
        } else {
            return null;
        }
    }

    /**
     * Delete - Delete an incident
     *
     * @param id - The id of the incident to delete
     */
    @DeleteMapping("/incident/{id}")
    public void deleteIncident(@PathVariable("id") final Long id) {
        incidentService.deleteIncident(id);
    }

}