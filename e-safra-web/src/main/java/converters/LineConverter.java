package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mBeans.LineController;
import domain.Line;

@FacesConverter("cl")
public class LineConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null) {
			return null;
		}
		LineController lineController = context.getApplication()
				.evaluateExpressionGet(context, "#{lineController}",
						LineController.class);
		Line line = lineController.doFindLineByName(value);
		System.out.println(line);
		return line;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string = null;
		if (object instanceof Line) {
			string = ((Line) object).getName();
		}
		return string;
	}

}
