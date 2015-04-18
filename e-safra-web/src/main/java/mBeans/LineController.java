package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.StationServicesLocal;
import domain.Line;

@ManagedBean
@SessionScoped
public class LineController {
	private Line line;
	private List<Line> selectedLines;
	@EJB
	private StationServicesLocal stationServicesLocal;

	public Line doFindLineByName(String name) {
		return stationServicesLocal.findLineByName(name);
	}

	public void displaySelectedLines() {
		for (Line l : selectedLines) {
			System.out.println(l.getName());
		}
	}

	public void doSome() {
		System.out.println(line.getName());
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public List<Line> getSelectedLines() {
		return selectedLines;
	}

	public void setSelectedLines(List<Line> selectedLines) {
		this.selectedLines = selectedLines;
	}

}
