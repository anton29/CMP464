package com.example.flickrmap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends FragmentActivity {
	private double latitude;
	private double longitude;

			
	private final LatLng Coordinate= new LatLng(40.855971,-73.867611);
	
	GoogleMap mMap;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setUpMapIfNeeded();
		
	}
		private void setUpMapIfNeeded() {
		    // Do a null check to confirm that we have not already instantiated the map.
		    if (mMap == null) {
		        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		                            .getMap();
		        // Check if we were successful in obtaining the map.
		        if (mMap != null) {
		            // The Map is verified. It is now safe to manipulate the map.
		        	mMap.setMyLocationEnabled(true);
		        	mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		        	mMap.addMarker(new MarkerOptions()
		        		.position(Coordinate)
		        		.title("pizza"));
		        }
		    }
		}



		
	}


	



