package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Entity implementation class for Entity: TypePK
 *
 */
@Embeddable
public class TypeId implements Serializable {

	private Integer idLine;
	private Integer idStation;
	private static final long serialVersionUID = 1L;

	public TypeId() {
		super();
	}

	public TypeId(Integer idLine, Integer idStation) {
		super();
		this.idLine = idLine;
		this.idStation = idStation;
	}

	public Integer getIdLine() {
		return idLine;
	}

	public void setIdLine(Integer idLine) {
		this.idLine = idLine;
	}

	public Integer getIdStation() {
		return idStation;
	}

	public void setIdStation(Integer idStation) {
		this.idStation = idStation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLine == null) ? 0 : idLine.hashCode());
		result = prime * result
				+ ((idStation == null) ? 0 : idStation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeId other = (TypeId) obj;
		if (idLine == null) {
			if (other.idLine != null)
				return false;
		} else if (!idLine.equals(other.idLine))
			return false;
		if (idStation == null) {
			if (other.idStation != null)
				return false;
		} else if (!idStation.equals(other.idStation))
			return false;
		return true;
	}

}
