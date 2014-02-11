package com.example.hw;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button aButton;
	EditText aEdit;
	TextView aText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aButton = (Button)findViewById(R.id.button1);
		
		aButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view) {
				aEdit = (EditText)findViewById(R.id.editText1);
				aText = (TextView)findViewById(R.id.textView1);
				aText.setText(aEdit.getText().toString());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
