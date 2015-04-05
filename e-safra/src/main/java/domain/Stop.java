package domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Stop
 *
 */
@Entity
public class Stop implements Serializable {

	private StopId stopId;
	private Integer nbFreePlaces;
	private static final long serialVersionUID = 1L;

	private Bus bus;
	private Station station;

	public Stop() {
		super();
	}

	public Stop(Integer nbFreePlaces, Bus bus, Station station) {
		super();
		this.nbFreePlaces = nbFreePlaces;
		this.bus = bus;
		this.station = station;
		this.stopId = new StopId(bus.getId(), station.getId());
	}

	public Integer getNbFreePlaces() {
		return this.nbFreePlaces;
	}

	public void setNbFreePlaces(Integer nbFreePlaces) {
		this.nbFreePlaces = nbFreePlaces;
	}

	@EmbeddedId
	public StopId getStopId() {
		return stopId;
	}

	public void setStopId(StopId stopId) {
		this.stopId = stopId;
	}

	@ManyToOne
	@JoinColumn(name = "idBus", referencedColumnName = "id", insertable = false, updatable = false)
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@ManyToOne
	@JoinColumn(name = "idStation", referencedColumnName = "id", insertable = false, updatable = false)
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

}
