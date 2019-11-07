package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager entityManager = factory.createEntityManager();
        
        // Enters into Transient state
		Student student = new Student();
		student.setStudentName("Aneri");
		student.setAvgScore(67.7);
		
		/*entityManager.getTransaction().begin();
		// Enters in Managed/Attached state
		entityManager.persist(student);
		
		student.setAvgScore(67.0); // as it is in attached state, so any changes like this will automatically converted into update statement 
		                           // as object is in sync with db, so any changes here will reflect in db.
		entityManager.getTransaction().commit();
		System.out.println("Student is persisted in database");*/
		
		student.setRollNumber(42);// if we dont write this, it will take new incremented rollno & that will not be deleted.
		// it will not throw exception so take one from the present dB.
		entityManager.getTransaction().begin();
		// Enters into Removed state
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		System.out.println("Student removed from db");
	
		
		
	}

}
