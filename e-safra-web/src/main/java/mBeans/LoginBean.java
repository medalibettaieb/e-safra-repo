package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.IdentificationServiceLocal;
import domain.User;

@ManagedBean
@SessionScoped
public class LoginBean {

	private User user = new User();
	@EJB
	private IdentificationServiceLocal identificationServiceLocal;

	public String doLogin() {
		String navigateTo = "";
		User userFound = identificationServiceLocal.login(user.getLogin(),
				user.getPassword());
		if (userFound != null) {
			navigateTo = "/pages/passengerHome";
		} else {
			navigateTo = "/error";
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
