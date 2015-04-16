package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;

public class TestFindStationOrderByLineId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra/StationServices!services.interfaces.StationServicesRemote");

		System.out
				.println(stationServicesRemote.findStationOrderByLineId(3, 1));

	}

}
