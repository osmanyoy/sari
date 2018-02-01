package com.training.jsf.cc;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily="javax.faces.Output",rendererType="com.training.jsf.cc.uimenuitemrenderer")
public class UIMenuItemRenderer extends Renderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIMenuItem menuItem = (UIMenuItem) component;
		String pageUrl = menuItem.getAttributes().get("pageUrl").toString();
		String iconName = menuItem.getAttributes().get("iconName").toString();
		String pageName = menuItem.getAttributes().get("pageName").toString();
		String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		responseWriter.startElement("li", menuItem);
		if (viewId.equals("/" + pageUrl)) {
			responseWriter.writeAttribute("class", "active", null);
		}
		responseWriter.startElement("a", menuItem);
		responseWriter.writeAttribute("href", pageUrl, null);
		responseWriter.startElement("i", menuItem);
		responseWriter.writeAttribute("class", iconName, null);
		responseWriter.endElement("i");
		responseWriter.write(pageName);
		responseWriter.endElement("a");
		responseWriter.endElement("li");
	}
}
