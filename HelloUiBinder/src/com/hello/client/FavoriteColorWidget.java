package com.hello.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FavoriteColorWidget extends Composite {

	private static FavoriteColorWidgetUiBinder uiBinder = GWT
			.create(FavoriteColorWidgetUiBinder.class);

	interface FavoriteColorWidgetUiBinder extends
			UiBinder<Widget, FavoriteColorWidget> {
	}
	
	 @UiField Label greeting;
     @UiField CheckBox red;
     @UiField CheckBox white;
     @UiField CheckBox blue;
     @UiField Button button;
     ArrayList<CheckBox> checkBoxs;

     
	public FavoriteColorWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		greeting.setText("Hello Vishal  !");
		checkBoxs = new ArrayList<CheckBox>();
		checkBoxs.add(blue);
		checkBoxs.add(red);
		checkBoxs.add(white);
		
		/*button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				  String t = "";
                  for(CheckBox box : checkBoxs) {
                       // if the box was checked
                       if (box.getValue()) {
                            t += box.getFormValue() + ", ";
                       }
                  }
                  Window.alert("Your favorite color/colors are: "+ t);
			}
		});*/
		
	}
	
	@UiHandler("button")
	public void buttonClick(ClickEvent event){
		String t = "";
        for(CheckBox box : checkBoxs) {
             // if the box was checked
             if (box.getValue()) {
                  t += box.getFormValue() + ", ";
             }
        }
        Window.alert("Your favorite color/colors are: "+ t);
	}


}
