package com.fleet.bean;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "TRIP_TBL")   // ✅ your table name
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_seq_gen")
    @SequenceGenerator(
            name = "trip_seq_gen",
            sequenceName = "TRIP_SEQ",   // ✅ your DB sequence name (trip_seq)
            allocationSize = 1           // ✅ must match DB increment (1)
    )
    @Column(name = "TRIP_ID", nullable = false)
    private int tripID;

    @Column(name = "VEHICLE_ID", nullable = false)
    private String vehicleID;

    @Temporal(TemporalType.DATE)
    @Column(name = "TRIP_DATE", nullable = false)
    private Date tripDate;

    @Column(name = "DISTANCE_TRAVELED", nullable = false)
    private double distanceTraveled;

    @Column(name = "FUEL_CONSUMED", nullable = false)
    private double fuelConsumed;

    // getters & setters

    public int getTripID() { return tripID; }
    public void setTripID(int tripID) { this.tripID = tripID; }

    public String getVehicleID() { return vehicleID; }
    public void setVehicleID(String vehicleID) { this.vehicleID = vehicleID; }

    public Date getTripDate() { return tripDate; }
    public void setTripDate(Date tripDate) { this.tripDate = tripDate; }

    public double getDistanceTraveled() { return distanceTraveled; }
    public void setDistanceTraveled(double distanceTraveled) { this.distanceTraveled = distanceTraveled; }

    public double getFuelConsumed() { return fuelConsumed; }
    public void setFuelConsumed(double fuelConsumed) { this.fuelConsumed = fuelConsumed; }

    @Override
    public String toString() {
        return "Trip [tripID=" + tripID + ", vehicleID=" + vehicleID + ", tripDate=" + tripDate +
                ", distanceTraveled=" + distanceTraveled + ", fuelConsumed=" + fuelConsumed + "]";
    }
}