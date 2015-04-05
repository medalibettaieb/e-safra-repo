package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: BusMan
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BusMan extends User implements Serializable {

	private Integer accesLevel;
	private static final long serialVersionUID = 1L;

	public BusMan() {
		super();
	}

	public BusMan(Integer accesLevel, String name, String login, String pwd) {
		super(name, login, pwd);
		this.accesLevel = accesLevel;
	}

	public Integer getAccesLevel() {
		return accesLevel;
	}

	public void setAccesLevel(Integer accesLevel) {
		this.accesLevel = accesLevel;
	}

	@Override
	public String toString() {
		return "BusMan [accesLevel=" + accesLevel + "]";
	}
	
}
