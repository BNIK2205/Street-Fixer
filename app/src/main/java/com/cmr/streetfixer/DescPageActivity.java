package com.cmr.streetfixer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cmr.streetfixer.databinding.ActivityDescPageBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DescPageActivity extends AppCompatActivity{

	private FirebaseFirestore dbf;
	private String uid;
	private String location;
	private String issues;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityDescPageBinding binding = ActivityDescPageBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		dbf = FirebaseFirestore.getInstance();
		uid = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
		Button btnSubmit = binding.btnSubmit;
		EditText description = binding.etDescription;
		EditText suggestion = binding.etsuggest;

		Intent intentt = getIntent();
		if (intentt != null) {
			location = intentt.getStringExtra("location");
			issues = intentt.getStringExtra("issues");
		}


		Map<String, Object> report = new HashMap<>();

		btnSubmit.setOnClickListener(v -> {
			if (!description.getText().toString().isEmpty() && !suggestion.getText().toString().isEmpty()) {
				String des = description.getText().toString();
				String sug = suggestion.getText().toString();
				report.put("issue", issues);
				report.put("description", des);
				report.put("location", location);
				report.put("suggestion", sug);

				dbf.collection(uid)
						.document(issues)
						.set(report)
						.addOnSuccessListener(documentReference -> Toast.makeText(DescPageActivity.this, "Problem reported successfully", Toast.LENGTH_SHORT).show())
						.addOnFailureListener(e -> Toast.makeText(DescPageActivity.this, "Error reporting problem!", Toast.LENGTH_SHORT).show());

				Intent intent = new Intent(DescPageActivity.this, HomePageActivity.class);
				startActivity(intent);
			} else {
				Toast.makeText(DescPageActivity.this, "Please fill description and suggestion!", Toast.LENGTH_SHORT).show();
			}
		});
	}
}