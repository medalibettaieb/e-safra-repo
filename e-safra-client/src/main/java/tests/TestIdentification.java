package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.IdentificationServiceRemote;
import domain.User;

public class TestIdentification {
	public static void main(String[] args) {

		Context context;

		try {
			context = new InitialContext();
			IdentificationServiceRemote stationServicesRemote = (IdentificationServiceRemote) context
					.lookup("e-safra-HAJ-FREJ/IdentificationService!services.interfaces.IdentificationServiceRemote");
			User user = stationServicesRemote.login("a", "b");
			System.out.println(user);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
