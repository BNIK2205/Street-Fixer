package com.cmr.streetfixer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cmr.streetfixer.databinding.ActivityStatusBinding;

public class StatusActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityStatusBinding binding = ActivityStatusBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());


	}
}
