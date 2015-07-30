package com.hello.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyBinderWidget extends Composite{

	private static MyBinderWidgetUiBinder uiBinder = GWT
			.create(MyBinderWidgetUiBinder.class);
	
	@UiField
	VerticalPanel myPanelContent;

	interface MyBinderWidgetUiBinder extends UiBinder<Widget, MyBinderWidget> {
	}

	public MyBinderWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		
		HTML html =  new HTML();
		html.setHTML("<a href='http://www.google.com'>Click me!</a>");
		myPanelContent.add(html);
		
		 HTML html2 = new HTML();
         html2.setHTML("This is my sample <b>content</b>!");
         myPanelContent.add(html2);
	}

}
