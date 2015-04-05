package services.interfaces;

import java.util.Map;

import javax.ejb.Local;

import domain.Bus;
import domain.Line;
import domain.Station;

@Local
public interface StationServicesLocal {
	Bus findBusById(Integer id);

	Station findStationById(Integer id);

	Boolean createLine(Line line, Map<Integer, Station> stations);

	Line findLineById(Integer id);
}
