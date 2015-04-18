package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.StationServicesLocal;
import domain.Bus;

@ManagedBean
@SessionScoped
public class BusesSelectManyCheckboxBean {

	private List<Bus> buses;
	private List<Bus> selectedBuses;
	private List<String> selectedIds = new ArrayList<String>();
	@EJB
	private StationServicesLocal stationServicesLocal;

	public void doSome() {
		for (String string : selectedIds) {
			System.out.println(string);
		}

	}

	public List<Bus> getBus() {
		buses = stationServicesLocal.findAllBuses();
		return buses;
	}

	public void setBus(List<Bus> bus) {
		this.buses = bus;
	}

	public List<Bus> getSelectedBuses() {
		return selectedBuses;
	}

	public void setSelectedBuses(List<Bus> selectedBuses) {
		this.selectedBuses = selectedBuses;
	}

	public List<String> getSelectedIds() {
		return selectedIds;
	}

	public void setSelectedIds(List<String> selectedIds) {
		this.selectedIds = selectedIds;
	}

}