
package com.aeg.jul.controlador.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("sexoConverter")
public class SexoConverter implements Converter{
@Override
    public Object getAsObject(FacesContext context, UIComponent component,String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String sex="";
            sex=(String)value;
        if (sex.equalsIgnoreCase("M")){
            sex="Masculino";
        }
        if (sex.equalsIgnoreCase("F")){
            sex="Femenino";
        }
        return sex;
    }
}
