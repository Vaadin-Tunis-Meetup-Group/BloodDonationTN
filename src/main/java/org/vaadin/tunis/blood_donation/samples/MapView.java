package org.vaadin.tunis.blood_donation.samples;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.CssLayout;

public class MapView extends CssLayout implements View {

	public static final String VIEW_NAME = "Map View";
	private GoogleMap googleMap;
	private GoogleMapMarker kakolaMarker = new GoogleMapMarker(
			"DRAGGABLE: Kakolan vankila", new LatLon(60.44291, 22.242415),
			true, null);
	private GoogleMapInfoWindow kakolaInfoWindow = new GoogleMapInfoWindow(
			"Kakola used to be a provincial prison.", kakolaMarker);
	private final String apiKey = "";

	public MapView() {
		setSizeFull();
		addStyleName("crud-view");
		googleMap = new GoogleMap(null, null, null);
		googleMap.setCenter(new LatLon(60.440963, 22.25122));
		googleMap.setZoom(10);
		googleMap.setSizeFull();
		kakolaMarker.setAnimationEnabled(false);
		googleMap.addMarker(kakolaMarker);
		googleMap.addMarker("DRAGGABLE: Paavo Nurmi Stadion", new LatLon(
				60.442423, 22.26044), true, "VAADIN/1377279006_stadium.png");
		googleMap.addMarker("NOT DRAGGABLE: Iso-Heikkilä", new LatLon(
				60.450403, 22.230399), false, null);
		googleMap.setMinZoom(4);
		googleMap.setMaxZoom(16);

		kakolaInfoWindow.setWidth("400px");
		kakolaInfoWindow.setHeight("500px");

		addComponent(googleMap);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
