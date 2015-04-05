package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class StopId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idBus;
	private Integer idstation;
	private Date date;

	public StopId() {
		// TODO Auto-generated constructor stub
	}

	public StopId(Integer idBus, Integer idstation) {
		super();
		this.idBus = idBus;
		this.idstation = idstation;
		this.date = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBus == null) ? 0 : idBus.hashCode());
		result = prime * result
				+ ((idstation == null) ? 0 : idstation.hashCode());
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
		StopId other = (StopId) obj;
		if (idBus == null) {
			if (other.idBus != null)
				return false;
		} else if (!idBus.equals(other.idBus))
			return false;
		if (idstation == null) {
			if (other.idstation != null)
				return false;
		} else if (!idstation.equals(other.idstation))
			return false;
		return true;
	}

	public Integer getIdBus() {
		return idBus;
	}

	public void setIdBus(Integer idBus) {
		this.idBus = idBus;
	}

	public Integer getIdstation() {
		return idstation;
	}

	public void setIdstation(Integer idstation) {
		this.idstation = idstation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
