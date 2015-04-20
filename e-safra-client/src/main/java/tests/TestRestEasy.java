package tests;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import domain.Station;

public class TestRestEasy {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Station station = client
				.target("http://localhost:8180/e-safra-web/rest/stations/")
				.path("{id}").resolveTemplate("id", 2).request()
				.get(Station.class);
		
		System.out.println(station.getName());

	}

}
