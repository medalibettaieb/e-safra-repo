package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Driver
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Driver extends User implements Serializable {

	private Integer seniority;
	private String shift;
	private static final long serialVersionUID = 1L;

	public Driver() {
		super();
	}

	public Driver(Integer seniority, String shift, String name, String login,
			String pwd) {
		super(name, login, pwd);
		this.seniority = seniority;
		this.shift = shift;
	}

	public Integer getSeniority() {
		return seniority;
	}

	public void setSeniority(Integer seniority) {
		this.seniority = seniority;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Driver [seniority=" + seniority + ", shift=" + shift + "]";
	}
	
}
