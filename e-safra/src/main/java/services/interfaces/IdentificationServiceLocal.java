package services.interfaces;

import javax.ejb.Local;

import domain.User;

@Local
public interface IdentificationServiceLocal {
	User login(String login, String pwd);
}
