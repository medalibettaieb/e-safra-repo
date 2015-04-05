package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;
import services.interfaces.TripServicesRemote;
import domain.Bus;
import domain.Line;
import domain.Station;

public class TestReportBusStop {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra-HAJ-FREJ/StationServices!services.interfaces.StationServicesRemote");
		TripServicesRemote tripServicesRemote = (TripServicesRemote) context
				.lookup("/e-safra-HAJ-FREJ/TripServices!services.interfaces.TripServicesRemote");

		Bus bus = stationServicesRemote.findBusById(1);
		Line line=bus.getLine();
		System.out.println(stationServicesRemote.findStationsByLineId(1).size());
		
	}

}
