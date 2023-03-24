package org.medhead.emergencysystem.apiincidents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "specialityneeded")
    private String specialityNeeded;

    @Column(name="longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "traitement")
    private String traitement;
}
