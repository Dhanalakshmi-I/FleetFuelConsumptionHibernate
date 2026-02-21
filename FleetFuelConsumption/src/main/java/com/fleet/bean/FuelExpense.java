package com.fleet.bean;

import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "FUEL_EXPENSE_TBL")   
public class FuelExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq_gen")
    @SequenceGenerator(
            name = "expense_seq_gen",
            sequenceName = "FUEL_EXPENSE_SEQ",   
            allocationSize = 1
    )
    @Column(name = "EXPENSE_ID", nullable = false)
    private int expenseID;
    @Column(name = "VEHICLE_ID", nullable = false)
    private String vehicleID;

    @Column(name = "FUEL_VOLUME", nullable = false)
    private double fuelVolume;
    @Column(name = "COST", nullable = false)
    private double cost;
    @Temporal(TemporalType.DATE)
    @Column(name = "PURCHASE_DATE", nullable = false)
    private Date purchaseDate;
    @Column(name = "STATION_NAME", nullable = false)
    private String stationName;
    public int getExpenseID() {
        return expenseID; 
    }
    public void setExpenseID(int expenseID) { 
        this.expenseID = expenseID;
    }
    public String getVehicleID() {
        return vehicleID; 
    }
    public void setVehicleID(String vehicleID) { 
        this.vehicleID = vehicleID;
    }
    public double getFuelVolume() { 
        return fuelVolume; 
    }
    public void setFuelVolume(double fuelVolume) { 
        this.fuelVolume = fuelVolume;
    }
    public double getCost() { 
        return cost; 
    }
    public void setCost(double cost) {
        this.cost = cost; 
    }
    public Date getPurchaseDate() {
        return purchaseDate; 
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate; 
    }
    public String getStationName() {
        return stationName; 
    }
    public void setStationName(String stationName) { 
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "FuelExpense [expenseID=" + expenseID + ", vehicleID=" + vehicleID + ", fuelVolume=" + fuelVolume
                + ", cost=" + cost + ", purchaseDate=" + purchaseDate + ", stationName=" + stationName + "]";
    }
}
