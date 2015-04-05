package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.TripServicesLocal;
import services.interfaces.TripServicesRemote;
import domain.Bus;
import domain.Station;
import domain.Stop;

/**
 * Session Bean implementation class TripServices
 */
@Stateless
public class TripServices implements TripServicesRemote, TripServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TripServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean reportBusStop(Bus bus, Station station) {
		Boolean b = false;
		try {
			Stop stop = new Stop(5, bus, station);
			entityManager.persist(stop);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
