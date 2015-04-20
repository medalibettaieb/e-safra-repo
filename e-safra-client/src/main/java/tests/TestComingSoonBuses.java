package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StationServicesRemote;
import domain.Bus;

public class TestComingSoonBuses {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context
				.lookup("/e-safra/StationServices!services.interfaces.StationServicesRemote");

		List<Bus> buses = stationServicesRemote.findComingSoonBuses(2);

		System.out.println(buses.size());
		for (Bus b : buses) {

			System.out.println(b.getNum());
		}

	}

}
