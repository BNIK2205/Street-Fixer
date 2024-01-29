package com.cmr.streetfixer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StatusActivity extends AppCompatActivity {

	private TextView issueTextView, locationTextView, descriptionTextView, suggestionsTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);

		TextView tv = findViewById(R.id.tvHeading);
	}
}
