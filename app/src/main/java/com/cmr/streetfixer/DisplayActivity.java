package com.cmr.streetfixer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cmr.streetfixer.databinding.ActivityDisplayBinding;

public class DisplayActivity extends AppCompatActivity {
	ActivityDisplayBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityDisplayBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
	}
}