package com.aniways.sample;

import com.aniways.Aniways;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Init Aniways here, before using any UI components.
		// IF your app has an 'Application' class, then it is best to init Aniways there in order not
		// do have to do it in the onCreate() of every entry point activity and in onCreate() of services
		// that use the Aniways API
		Aniways.init(this);
		
		// The content view is set up after the Aniways init because the view contains Aniways elements
		setContentView(R.layout.activity_main);

		// Setup the 'send' button
		Button btn = (Button) findViewById(R.id.chat_send);
		final EditText textEditor = (EditText) findViewById(R.id.chat_input);
		final TextView textView = (TextView) findViewById(R.id.message_wall);

		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String message = Aniways.encodeMessage(textEditor.getText());
				textView.setText(message);
				textEditor.setText("");	
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
