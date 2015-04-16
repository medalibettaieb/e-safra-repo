package services.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.StationServicesLocal;
import domain.Bus;
import domain.BusMan;
import domain.Driver;
import domain.Line;
import domain.Passenger;
import domain.Station;
import domain.Stop;

/**
 * Session Bean implementation class PopulateDataBase
 */
@Singleton
@Startup
public class PopulateDataBase {
	@EJB
	private StationServicesLocal stationServicesLocal;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PopulateDataBase() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void populateDb() {
		Bus bus = new Bus("B01");
		Bus bus2 = new Bus("B02");
		Bus bus3 = new Bus("B03");
		Bus bus4 = new Bus("B04");

		Line line = new Line("Tun-Lambadouza");
		Line line2 = new Line("Tun-Sfax");

		Station station = new Station("Tun");
		Station station2 = new Station("Safax");
		Station station3 = new Station("Lambadouza");
		Station station4 = new Station("Rouad");

		List<Bus> listBuses1 = new ArrayList<>();
		List<Bus> listBuses2 = new ArrayList<>();

		listBuses1.add(bus);
		listBuses1.add(bus2);

		listBuses2.add(bus3);
		listBuses2.add(bus4);

		line.linkBusesToThisLine(listBuses1);
		line2.linkBusesToThisLine(listBuses2);

		Driver driver = new Driver(1, "matin", "Mohamed", "med@driver.tn",
				"0000");
		entityManager.persist(driver);
		Driver driver2 = new Driver(1, "midi", "Nizar", "nizar@driver.tn",
				"0000");
		entityManager.persist(driver2);
		BusMan busMan = new BusMan(5, "Seif", "seif@man.tn", "0000");
		entityManager.persist(busMan);
		BusMan busMan2 = new BusMan(5, "Amine", "amine@man.tn", "0000");
		entityManager.persist(busMan2);
		try {
			Passenger passenger = new Passenger((Double) 120.0,
					new SimpleDateFormat("MM/dd/yyyy").parse("11/25/1991"),
					true, "Patricia", "patricia@passenger.tn", "0000");
			entityManager.persist(passenger);
		} catch (Exception e) {
		}

		// Creation of a line

		Map<Integer, Station> stations = new HashMap();
		Map<Integer, Station> stations2 = new HashMap();

		stations.put(0, station);
		stations.put(1, station2);
		stations.put(2, station3);

		stations2.put(0, station4);
		stations2.put(1, station2);
		stations2.put(2, station);

		entityManager.persist(line);
		entityManager.persist(line2);

		entityManager.persist(station);
		entityManager.persist(station2);
		entityManager.persist(station3);
		entityManager.persist(station4);

		stationServicesLocal.createLine(line, stations);
		stationServicesLocal.createLine(line2, stations2);

		Stop stop2 = new Stop(0, stationServicesLocal.findBusByName("B01"),
				stationServicesLocal.findStationByName("Tun"));
		Stop stop4 = new Stop(0, stationServicesLocal.findBusByName("B01"),
				stationServicesLocal.findStationByName("Safax"));
		Stop stop3 = new Stop(0, stationServicesLocal.findBusByName("B02"),
				stationServicesLocal.findStationByName("Tun"));
		Stop stop5 = new Stop(0, stationServicesLocal.findBusByName("B02"),
				stationServicesLocal.findStationByName("Safax"));
		Stop stop6 = new Stop(0, stationServicesLocal.findBusByName("B02"),
				stationServicesLocal.findStationByName("Lambadouza"));
		Stop stop = new Stop(0, stationServicesLocal.findBusByName("B03"),
				stationServicesLocal.findStationByName("Rouad"));

		
		entityManager.persist(stop2);
		entityManager.persist(stop4);
		entityManager.persist(stop3);
		entityManager.persist(stop5);
		entityManager.persist(stop6);
		entityManager.persist(stop);
	}

}
