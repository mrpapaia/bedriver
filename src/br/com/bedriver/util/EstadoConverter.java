package br.com.bedriver.util;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.bedriver.model.Estado;
import br.com.bedriver.web.EstadoBean;

@FacesConverter(value = "estadoConverter")
public class EstadoConverter  implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{estadoBean}", EstadoBean.class);

        EstadoBean estados = (EstadoBean)vex.getValue(ctx.getELContext());
        return estados.getEstado(Integer.valueOf(beerId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object estado) {
        return ((Estado)estado).getId().toString();
    }
}
