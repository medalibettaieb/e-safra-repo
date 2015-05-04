package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Type
 *
 */
@Entity
public class Type implements Serializable {

	private TypeId typeId;
	private String type;
	private Integer stationOrder;
	private static final long serialVersionUID = 1L;

	private Station station;
	private Line line;
	private Section section;
	private List<Ticket> tickets;

	public Type() {
		super();
	}

	public Type(String type, Integer stationOrder, Station station, Line line) {
		super();
		this.type = type;
		this.stationOrder = stationOrder;
		this.typeId = new TypeId(line.getId(), station.getId());
	}

	@EmbeddedId
	public TypeId getTypeId() {
		return typeId;
	}

	public void setTypeId(TypeId typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStationOrder() {
		return stationOrder;
	}

	public void setStationOrder(Integer stationOrder) {
		this.stationOrder = stationOrder;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idStation", referencedColumnName = "id", insertable = false, updatable = false)
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idLine", referencedColumnName = "id", insertable = false, updatable = false)
	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@OneToMany(mappedBy = "type")
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
