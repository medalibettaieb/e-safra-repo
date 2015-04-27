package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.IdentificationServiceLocal;
import domain.BusMan;
import domain.Driver;
import domain.User;

@ManagedBean
@SessionScoped
public class LoginBean {

	private User user = new User();
	private Boolean loggedInAsBusMan = false;
	@EJB
	private IdentificationServiceLocal identificationServiceLocal;

	public String doLogin() {
		String navigateTo = "/error";
		User userFound = identificationServiceLocal.login(user.getLogin(),
				user.getPassword());
		if (userFound != null) {
			user = userFound;
			if (userFound instanceof BusMan) {
				loggedInAsBusMan = true;
				navigateTo = "/pages/busMan/home?faces-redirect=true";
			}
			if (userFound instanceof Driver) {
				navigateTo = "/pages/driver/home?faces-redirect=true";
			} else {
				navigateTo = "/pages/passenger/home?faces-redirect=true";
			}
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsBusMan() {
		return loggedInAsBusMan;
	}

	public void setLoggedInAsBusMan(Boolean loggedInAsBusMan) {
		this.loggedInAsBusMan = loggedInAsBusMan;
	}

}
