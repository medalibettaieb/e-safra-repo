package services.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.StationServicesLocal;
import services.interfaces.StationServicesRemote;
import domain.Bus;
import domain.Line;
import domain.Station;
import domain.Type;

/**
 * Session Bean implementation class StationServices
 */
@Stateless
public class StationServices implements StationServicesRemote,
		StationServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StationServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Bus findBusById(Integer id) {
		return entityManager.find(Bus.class, id);
	}

	@Override
	public Station findStationById(Integer id) {
		return entityManager.find(Station.class, id);
	}

	@Override
	public Boolean createLine(Line line, Map<Integer, Station> stations) {
		Boolean b = false;
		try {
			for (int i = 0; i < stations.size(); i++) {
				String typeName = "";
				if (i == 0)
					typeName = "Depart";
				else if (i == stations.size() - 1)
					typeName = "Arrival";
				else
					typeName = "Intermediate";
				Type type = new Type(typeName, i, stations.get(i), line);
				entityManager.persist(type);
			}
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public Line findLineById(Integer id) {

		return entityManager.find(Line.class, id);
	}

	@Override
	public List<Station> findStationsByLineId(Integer id) {
		Line line=this.findLineById(id);
		String jpql="select s from Station WHERE s.id in select t.idStation from Type WHERE t.idLine= :id";
	
		Query query=entityManager.createQuery(jpql);
		query.setParameter("id", id);
		List<Station>stations=query.getResultList();
		return stations;
	}

}
