package services.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.IdentificationServiceLocal;
import services.interfaces.IdentificationServiceRemote;
import domain.User;

/**
 * Session Bean implementation class IdentificationService
 */
@Stateless
@LocalBean
public class IdentificationService implements IdentificationServiceRemote,
		IdentificationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public IdentificationService() {
		// TODO Auto-generated constructor stub
	}

	public User login(String login, String pwd){
		try {
			String req="Select u from User u WHERE u.login = :x and u.password = :y";
			Query query=entityManager.createQuery(req);
			query.setParameter("x", login);	
			query.setParameter("y", pwd);
			return (User)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
    }
}
