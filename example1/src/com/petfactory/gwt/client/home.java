package com.petfactory.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class home implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// Create a Label and an HTML widget.
	    Label lbl = new Label("This is just text.  It will not be interpreted "
	      + "as <html>.");

	    HTML html = new HTML(
	      "This is <b>HTML</b>.  It will be interpreted as such if you specify "
	        + "the <span style='font-family:fixed'>asHTML</span> flag.", true);

	    // Add them to the root panel.
	    VerticalPanel panel = new VerticalPanel();
	    panel.add(lbl);
	    panel.add(html);
	    RootPanel.get().add(panel);
	}

}
