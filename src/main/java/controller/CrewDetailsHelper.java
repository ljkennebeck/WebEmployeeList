package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CrewDetails;

public class CrewDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebEmployeeList");
	
	public void insertNewEmployeeDetails(CrewDetails d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CrewDetails> getEmployees(){
		EntityManager em = emfactory.createEntityManager();
		List<CrewDetails> allDetails = em.createQuery("SELECT d FROM CrewDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteCrew(CrewDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CrewDetails> typedQuery = em.createQuery("select detail from CrewDetails detail where detail.id = :selectedId", CrewDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		CrewDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public CrewDetails searchForCrewDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CrewDetails found = em.find(CrewDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateCrew(CrewDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
