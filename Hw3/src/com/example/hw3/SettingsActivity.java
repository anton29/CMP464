package com.example.hw3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		
		PreferenceManager.setDefaultValues(this, R.xml.settings, false);
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
		
		if (settings.getBoolean("alt_1", true)) {
		getApplication().setTheme(R.style.alt);
		}else{
		getApplication().setTheme(R.style.start);
		}
		PreferenceManager.setDefaultValues(this, R.xml.settings, false);
		SharedPreferences settings1 = PreferenceManager.getDefaultSharedPreferences(this);
		
		if (settings.getBoolean("alt_2", false)) {
		getApplication().setTheme(R.style.alt);
		}else{
		getApplication().setTheme(R.style.start);

	}
	}
}
