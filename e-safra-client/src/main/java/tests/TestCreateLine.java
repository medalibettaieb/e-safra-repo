package tests;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;
import domain.Line;
import domain.Station;

public class TestCreateLine {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra-HAJ-FREJ/StationServices!services.interfaces.StationServicesRemote");

		Station station = stationServicesRemote.findStationById(1);
		Station station2 = stationServicesRemote.findStationById(2);
		Station station3 = stationServicesRemote.findStationById(3);

		Map<Integer, Station> stations = new HashMap();

		stations.put(0, station);
		stations.put(1, station2);
		stations.put(2, station3);

		Line line = stationServicesRemote.findLineById(1);

		stationServicesRemote.createLine(line, stations);

	}

}
