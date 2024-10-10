package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.onllinebookstore.dto.Admin;

public class AdminDao {
//	Admin 
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlinebookstore");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();	
	
	public void saveAdmin(Admin ad) {
		List <Admin> l = new ArrayList<Admin>();
		l.add(ad);
		et.begin();
		em.persist(l);
		et.commit();
	}
	
	public Admin deleteAdmin(int id ) {
		Admin ad = em.find(Admin.class, id);
		if(ad!=null) {
			et.begin();
			em.remove(ad);
			et.commit();
			return ad;
		}
		return null;
	}
	
	
	public void updateAdmin(int id , String name,String pass, String email) {
		
			Admin ad = em.find(Admin.class, id);
			if(ad!=null) {
				ad.setAdminName(name);
				ad.setAdminPass(pass);
				ad.setEmail(email);
				et.begin();
				em.merge(ad);
				et.commit();
			}
		
	}
	
	
	
	
	

}
