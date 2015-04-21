package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;
import domain.Bus;

public class TestReportBusStop {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra-HAJ-FREJ/StationServices!services.interfaces.StationServicesRemote");

		Bus bus = stationServicesRemote.findBusById(1);
		System.out.println(bus);
	}

}
