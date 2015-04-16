package mBeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import services.interfaces.StationServicesLocal;
import domain.Line;
import domain.Station;

@ManagedBean
@ViewScoped
public class LineBean {

	private Line line = new Line();
	private List<Station> stations = new ArrayList<Station>();
	private DataModel<Station> dataModel = new ListDataModel<>();
	private Map<Integer, Station> stationMap = new HashMap<Integer, Station>();
	private List<Line> lines = new ArrayList<>();

	@EJB
	private StationServicesLocal stationServicesLocal;

	public String doCreateLine() {
		stationServicesLocal.createLine(line, stationMap);
		return "";
	}
	public String doDo() {
		System.out.println(line.getName());
		return "";
	}
	
	public String doSelectStationForCurrentLine() {
		Integer i = stationMap.size();
		stationMap.put(i, dataModel.getRowData());
		System.out.println(stationMap.get(i).getName() + " size "
				+ stationMap.size());
		return "";
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public List<Station> getStations() {
		return stationServicesLocal.findAllStations();
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public DataModel<Station> getDataModel() {
		dataModel.setWrappedData(stationServicesLocal.findAllStations());
		return dataModel;
	}

	public void setDataModel(DataModel<Station> dataModel) {
		this.dataModel = dataModel;
	}

	public Map<Integer, Station> getStationMap() {
		return stationMap;
	}

	public void setStationMap(Map<Integer, Station> stationMap) {
		this.stationMap = stationMap;
	}

	public List<Line> getLines() {
		lines = stationServicesLocal.findLinesByStation(1);
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

}
