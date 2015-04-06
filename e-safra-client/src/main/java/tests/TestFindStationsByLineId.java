package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;
import domain.Station;

public class TestFindStationsByLineId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra/StationServices!services.interfaces.StationServicesRemote");

		List<Station> stations = stationServicesRemote
				.findStationsByLineIdBis(1);
		System.out.println(stations.size());
	}

}
