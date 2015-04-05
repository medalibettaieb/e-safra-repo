package services.interfaces;

import javax.ejb.Remote;

import domain.Bus;
import domain.Station;

@Remote
public interface TripServicesRemote {

	Boolean reportBusStop(Bus bus, Station station);

}
