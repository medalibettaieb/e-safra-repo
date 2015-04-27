package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import services.interfaces.StationServicesLocal;
import domain.Bus;
import domain.Line;

@ManagedBean
@ViewScoped
public class BusesBean {
	private List<Bus> buses = new ArrayList<>();
	private Bus bus = new Bus();
	private Boolean visibility = false;

	@EJB
	private StationServicesLocal stationServicesLocal;
	@ManagedProperty(value = "#{lineController}")
	private LineController lineController;

	public void doSelect() {
		visibility = true;
	}

	public String doSaveOrUpdate() {
		Line lineSelected = lineController.getLine();
		bus.setLine(lineSelected);
		stationServicesLocal.updateBus(bus);
		visibility = false;
		return "";
	}

	public String doDeleteBus() {
		stationServicesLocal.deleteBusById(bus.getId());
		visibility = false;
		return "";
	}

	public String doAddBus() {
		stationServicesLocal.addBus(bus);
		visibility = false;
		return "";
	}

	public List<Bus> getBuses() {
		buses = stationServicesLocal.findAllBuses();
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	public LineController getLineController() {
		return lineController;
	}

	public void setLineController(LineController lineController) {
		this.lineController = lineController;
	}

}
