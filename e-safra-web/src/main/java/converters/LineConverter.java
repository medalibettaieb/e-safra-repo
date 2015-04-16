package converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import services.interfaces.StationServicesLocal;
import domain.Line;

@ManagedBean
public class LineConverter implements Converter {
	@EJB
	private StationServicesLocal stationService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Line line = stationService.findLineById(Integer.parseInt(arg2));
		return line;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return String.valueOf(((Line) arg2).getId());
	}

}
