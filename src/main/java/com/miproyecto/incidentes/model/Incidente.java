package com.miproyecto.incidentes.model;

import jakarta.persistence.*;

@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String oficina;
    private String claseAviso;
    private String prioridad;
    private String estado;

    private Long incidentePadreId;

    // Constructor vacío (IMPORTANTE)
    public Incidente() {}

    // Getters y Setters
    public Long getId() { return id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getOficina() { return oficina; }
    public void setOficina(String oficina) { this.oficina = oficina; }

    public String getClaseAviso() { return claseAviso; }
    public void setClaseAviso(String claseAviso) { this.claseAviso = claseAviso; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Long getIncidentePadreId() { return incidentePadreId; }
    public void setIncidentePadreId(Long incidentePadreId) { this.incidentePadreId = incidentePadreId; }
}