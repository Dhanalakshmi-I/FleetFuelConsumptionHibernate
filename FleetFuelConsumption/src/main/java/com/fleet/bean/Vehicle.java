package com.fleet.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "VEHICLE_TBL")  
public class Vehicle {
    @Id
    @Column(name = "VEHICLE_ID", nullable = false)
    private String vehicleID;   
    @Column(name = "MODEL", nullable = false)
    private String model;
    @Column(name = "CATEGORY", nullable = false)
    private String category;
    @Column(name = "TANK_CAPACITY", nullable = false)
    private double tankCapacity;
    @Column(name = "TOTAL_DISTANCE", nullable = false)
    private double totalDistance;
    @Column(name = "TOTAL_FUEL_USED", nullable = false)
    private double totalFuelUsed;
    public String getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID; 
    }
    public String getModel() { 
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCategory() {
        return category; 
    }
    public void setCategory(String category) { 
        this.category = category; 
    }
    public double getTankCapacity() { 
        return tankCapacity;
    }
    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity; 
    }
    public double getTotalDistance() {
        return totalDistance; 
    }
    public void setTotalDistance(double totalDistance) { 
        this.totalDistance = totalDistance; 
    }
    public double getTotalFuelUsed() { 
        return totalFuelUsed;
    }
    public void setTotalFuelUsed(double totalFuelUsed) {
        this.totalFuelUsed = totalFuelUsed;
    }
    @Override
    public String toString() {
        return "Vehicle [vehicleID=" + vehicleID + ", model=" + model + ", category=" + category + ", tankCapacity="
                + tankCapacity + ", totalDistance=" + totalDistance + ", totalFuelUsed=" + totalFuelUsed + "]";
    }
}
