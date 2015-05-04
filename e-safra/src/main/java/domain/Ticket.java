package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity
public class Ticket implements Serializable {

	private Integer id;
	private Integer Stars;
	private static final long serialVersionUID = 1L;

	private User user;
	private Bus bus;
	private Type type;

	public Ticket() {
		super();
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStars() {
		return this.Stars;
	}

	public void setStars(Integer Stars) {
		this.Stars = Stars;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@ManyToOne
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
