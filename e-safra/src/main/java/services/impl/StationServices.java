package services.impl;

import java.util.ArrayList;
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
			entityManager.persist(line);

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Station> findStationsByLineIdBis(Integer id) {
		Line line = this.findLineById(id);
		String jpql = "select s from Station s " + "join s.types ts "
				+ "where ts.line= :param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", line);
		List<Station> stations = query.getResultList();
		return stations;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Line> findLinesByStation(Integer idStation) {
		Station station = findStationById(idStation);
		String jpql = "select l from Line l " + "join l.types ls "
				+ "where ls.station= :param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", station);

		List<Line> lines = query.getResultList();
		return lines;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bus> findBusesByLineId(Integer idLine) {
		List<Bus> buses = new ArrayList<>();
		try {
			Line line = findLineById(idLine);
			String jpql = "SELECT b FROM Bus b WHERE b.line = :param1";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("param1", line);
			buses = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return buses;
	}

	@Override
	public List<Station> findAllPreviousStationsByStationId(Line line,
			Station station) {

		List<Station> stations = new ArrayList<>();
		try {

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return stations;
	}

	@Override
	public Boolean addLine(Line line) {
		Boolean b = false;
		try {
			entityManager.persist(line);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Station> findAllStations() {
		return entityManager.createQuery("Select s from Station s")
				.getResultList();
	}

	@Override
	public Boolean assignBusesToLine(List<Bus> bus, Line line) {
		Boolean b = false;
		try {
			entityManager.merge(line);
			line.linkBusesToThisLine(bus);
			entityManager.merge(line);
			b = true;
		} catch (Exception e) {

		}
		return b;
	}
}
