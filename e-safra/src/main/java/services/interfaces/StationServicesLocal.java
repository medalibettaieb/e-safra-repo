package services.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import domain.Bus;
import domain.Line;
import domain.Station;
import domain.Stop;

@Local
public interface StationServicesLocal {
	Bus findBusById(Integer id);

	Station findStationById(Integer id);

	Boolean createLine(Line line, Map<Integer, Station> stations);

	Line findLineById(Integer id);

	List<Station> findStationsByLineIdBis(Integer id);

	List<Line> findLinesByStation(Integer idStation);

	List<Bus> findBusesByLineId(Integer idLine);

	List<Station> findAllPreviousStationsByStationId(Line line, Station station);

	Boolean addLine(Line line);

	List<Station> findAllStations();

	Boolean assignBusesToLine(List<Bus> bus, Line line);

	Line findLineByName(String name);

	List<Bus> findComingSoonBuses(Station station);

	Stop findLastStopByBusId(Integer idBus);

	Integer findStationOrderByLineId(Integer idStation, Integer idLine);

	Bus findBusByName(String name);

	Station findStationByName(String name);

}
