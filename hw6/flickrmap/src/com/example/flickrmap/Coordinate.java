package com.example.flickrmap;

import org.json.JSONException;
import org.json.JSONObject;

public class Coordinate {
	private double latitude;
	private double longitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public static Coordinate fromJSON( JSONObject object ){
		Coordinate response = new Coordinate();

		try {
			response.latitude = object.getDouble("latitude_delta");
			response.longitude = object.getDouble("longitude_delta");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
	
}
