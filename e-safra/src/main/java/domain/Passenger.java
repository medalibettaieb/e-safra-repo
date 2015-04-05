package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Passenger
 *
 */
@Entity
public class Passenger extends User implements Serializable {

	private Double cash;
	private Date birthDay;
	private Boolean gender;
	private static final long serialVersionUID = 1L;

	public Passenger() {
		super();
	}

	public Passenger(Double cash, Date birthDay, Boolean gender, String name,
			String login, String pwd) {
		super(name, login, pwd);
		this.cash = cash;
		this.birthDay = birthDay;
		this.gender = gender;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [cash=" + cash + ", birthDay=" + birthDay
				+ ", gender=" + gender + "]";
	}
	
}
