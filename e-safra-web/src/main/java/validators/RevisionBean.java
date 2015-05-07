package validators;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.validator.constraints.Email;

@ManagedBean
@SessionScoped
public class RevisionBean {
	
	private String name;
	private Date dateOfSomeStuff;
	@Email(message="mail invalid")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfSomeStuff() {
		return dateOfSomeStuff;
	}

	public void setDateOfSomeStuff(Date dateOfSomeStuff) {
		this.dateOfSomeStuff = dateOfSomeStuff;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
