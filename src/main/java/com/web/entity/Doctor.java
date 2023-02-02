package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private long idDoctor;
    @Column(name = "cabinetNumber",nullable = false)
    private int cabinetNumber;
    @Column(name = "specialityDoctor",nullable = false)
    private String specialityDoctor;
    @ManyToMany(mappedBy = "doctors")
    private Set<PositionDoctor> positionDoctors;

    @OneToOne(mappedBy = "doctor")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private Set<Calendar> calendars;

    public Doctor(long idDoctor, int cabinetNumber, String specialityDoctor) {
        this.idDoctor = idDoctor;
        this.cabinetNumber = cabinetNumber;
        this.specialityDoctor = specialityDoctor;
    }

    public Doctor() {

    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getSpecialityDoctor() {
        return specialityDoctor;
    }

    public void setSpecialityDoctor(String specialityDoctor) {
        this.specialityDoctor = specialityDoctor;
    }

    public Set<PositionDoctor> getPositionDoctors() {
        return positionDoctors;
    }

    public void setPositionDoctors(Set<PositionDoctor> positionDoctors) {
        this.positionDoctors = positionDoctors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(Set<Calendar> calendars) {
        this.calendars = calendars;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", cabinetNumber=" + cabinetNumber +
                ", specialityDoctor='" + specialityDoctor + '\'' +
                ", positionDoctors=" + positionDoctors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        return idDoctor == doctor.idDoctor;
    }

    @Override
    public int hashCode() {
        return (int) (idDoctor ^ (idDoctor >>> 32));
    }
}
