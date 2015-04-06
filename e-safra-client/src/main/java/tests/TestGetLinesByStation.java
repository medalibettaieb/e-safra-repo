package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;
import domain.Line;

public class TestGetLinesByStation {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra/StationServices!services.interfaces.StationServicesRemote");

		List<Line> lines = stationServicesRemote.findLinesByStation(2);
		for (Line l : lines) {
			System.out.println(l);
		}
	}

}
