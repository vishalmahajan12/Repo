package com.hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloUiBinder2 implements EntryPoint {

	@Override
	public void onModuleLoad() {
		 MyBinderWidget w = new MyBinderWidget();
         RootPanel.get().add(w);
	}

	
}
