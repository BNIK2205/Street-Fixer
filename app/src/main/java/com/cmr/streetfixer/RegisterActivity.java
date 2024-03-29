package com.cmr.streetfixer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;
public class RegisterActivity extends AppCompatActivity{

	TextInputEditText etRegEmail;
	TextInputEditText etRegPassword;
	TextView tvLoginHere;
	Button btnRegister;

	FirebaseAuth mAuth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		etRegEmail = findViewById(R.id.etRegEmail);
		etRegPassword = findViewById(R.id.etRegPass);
		tvLoginHere = findViewById(R.id.tvLoginHere);
		btnRegister = findViewById(R.id.btnRegister);

		mAuth = FirebaseAuth.getInstance();

		if (mAuth.getCurrentUser() != null) {
			startActivity(new Intent(RegisterActivity.this, MainActivity.class));
			finish();
		}

		btnRegister.setOnClickListener(view -> createUser());

		tvLoginHere.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, MainActivity.class)));
	}
	private void createUser(){
		String email = Objects.requireNonNull(etRegEmail.getText()).toString();
		String password = Objects.requireNonNull(etRegPassword.getText()).toString();

		if (etRegEmail.getText().toString().trim().isEmpty()){
			etRegEmail.setError("Email cannot be empty");
			etRegEmail.requestFocus();
		}else if (etRegPassword.getText().toString().trim().isEmpty()){
			etRegPassword.setError("Password cannot be empty");
			etRegPassword.requestFocus();
		}else{
			mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
				if (task.isSuccessful()){
					Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
					startActivity(new Intent(RegisterActivity.this, MainActivity.class));
				}else{
					Toast.makeText(RegisterActivity.this, "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
