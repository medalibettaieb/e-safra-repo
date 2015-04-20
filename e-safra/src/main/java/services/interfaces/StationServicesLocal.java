package services.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Bus;
import domain.Line;
import domain.Station;
import domain.Stop;

@Local
@Path("/stations")
public interface StationServicesLocal {
	Bus findBusById(Integer id);

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Station findStationById(@PathParam("id") Integer id);

	Boolean createLine(Line line, Map<Integer, Station> stations);

	Line findLineById(Integer id);

	List<Station> findStationsByLineIdBis(Integer id);

	List<Line> findLinesByStation(Integer idStation);

	List<Bus> findBusesByLineId(Integer idLine);

	List<Station> findAllPreviousStationsByStationId(Line line, Station station);

	Boolean addLine(Line line);

	@GET
	@Produces("application/json")
	List<Station> findAllStations();

	Boolean assignBusesToLine(List<Bus> bus, Line line);

	Line findLineByName(String name);

	List<Bus> findComingSoonBuses(Station station);

	Stop findLastStopByBusId(Integer idBus);

	Integer findStationOrderByLineId(Integer idStation, Integer idLine);

	Bus findBusByName(String name);

	Station findStationByName(String name);

	List<Bus> findAllBuses();

}
