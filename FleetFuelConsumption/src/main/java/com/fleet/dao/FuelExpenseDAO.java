package com.fleet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.fleet.bean.FuelExpense;
import com.fleet.util.HibernateUtil;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;
public class FuelExpenseDAO {
	public int generateExpenseID() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
          return ((Number) session.createNativeQuery("SELECT fuel_expense_seq.NEXTVAL FROM DUAL").getSingleResult()).intValue();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	public boolean recordFuelExpense(FuelExpense fe) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();
	        session.save(fe);  
	        session.getTransaction().commit();
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public List<FuelExpense> findExpensesByVehicle(String vehicleID) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String hql = "FROM FuelExpense fe WHERE fe.vehicleID = :id";
	        return session.createQuery(hql, FuelExpense.class)
	                      .setParameter("id", vehicleID)
	                      .list();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}
}
