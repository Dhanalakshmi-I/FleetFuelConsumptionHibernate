package com.fleet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.fleet.bean.Trip;
import com.fleet.bean.Vehicle;
import com.fleet.util.HibernateUtil;

public class TripDAO {
	public boolean recordTrip(Trip t) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();
	        session.persist(t);
	        session.getTransaction().commit();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public int generateTripID() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	        return ((Number) session.createNativeQuery("SELECT trip_seq.NEXTVAL FROM DUAL").getSingleResult()).intValue();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	public List<Trip> findTripsByVehicle(String vehicleID) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	        String hql = "FROM Trip t WHERE t.vehicleID = :id";
	        return session.createQuery(hql, Trip.class)
	                      .setParameter("id", vehicleID)
	                      .list();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}
	 
}
