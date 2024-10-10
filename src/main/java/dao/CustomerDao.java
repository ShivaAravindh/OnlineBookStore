package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.onllinebookstore.dto.Customer;

public class CustomerDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlinebookstore");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();	
	
	public void saveCustomer(Customer ct) {
		List <Customer> l = new ArrayList<Customer>();
		l.add(ct);
		et.begin();
		em.persist(l);
		et.commit();
	}
	public Customer deleteCustomer(int id ) {
		Customer ct = em.find(Customer.class, id);
		if(ct!=null) {
			et.begin();
			em.remove(ct);
			et.commit();
			return ct;
		}
		return null;
	}
	
	public void updateCustomer(int id , String name,long phn,String pass, String email) {
		
		Customer ct = em.find(Customer.class, id);
		if(ct!=null) {
			ct.setCustomeremail(email);
			ct.setCustomerName(name);
			ct.setCustomerpass(pass);
			ct.setCustomerphn(phn);
			et.begin();
			em.merge(ct);
			et.commit();
		}
	}
	
}
