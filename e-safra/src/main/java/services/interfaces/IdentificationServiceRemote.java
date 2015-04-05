package services.interfaces;

import javax.ejb.Remote;

import domain.User;

@Remote
public interface IdentificationServiceRemote {
	User login(String login, String pwd);
}
