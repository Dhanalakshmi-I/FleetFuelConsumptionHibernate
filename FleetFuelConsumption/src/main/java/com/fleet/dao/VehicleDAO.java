package com.fleet.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fleet.bean.Vehicle;
import com.fleet.util.HibernateUtil;
public class VehicleDAO {
	 public Vehicle findVehicle(String vehicleID) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        return session.get(Vehicle.class,vehicleID);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	 public List<Vehicle> viewAllVehicles() {
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        return session.createQuery("FROM Vehicle", Vehicle.class).list();
		    } catch (Exception e) {
		        e.printStackTrace();
		        return new ArrayList<>();
		    }
		}
	 public boolean insertVehicle(Vehicle v) {
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        session.beginTransaction();
		        session.persist(v);
		        session.getTransaction().commit();
		        return true;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	 public boolean updateMileage(String vehicleID, double newDistance, double newFuel) {
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        session.beginTransaction();
		        String hql = "UPDATE Vehicle v " +
		                     "SET v.totalDistance = v.totalDistance + :dist, " +
		                     "    v.totalFuelUsed = v.totalFuelUsed + :fuel " +
		                     "WHERE v.vehicleID = :id";
		        int rows = session.createQuery(hql)
		                .setParameter("dist", newDistance)
		                .setParameter("fuel", newFuel)
		                .setParameter("id", vehicleID)
		                .executeUpdate();
		        session.getTransaction().commit();
		        return rows > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	 public boolean deleteVehicle(String vehicleID) {
		    Transaction transaction = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
               Vehicle vehicle = session.get(Vehicle.class, vehicleID);
		        if (vehicle != null) {
		            session.remove(vehicle);
		            System.out.println("Vehicle deleted: " + vehicleID);
		        }
		        transaction.commit();
		        return true;
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace();
		        return false;
		    }
		}
}
