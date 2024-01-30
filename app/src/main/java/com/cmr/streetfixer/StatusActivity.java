package com.cmr.streetfixer;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class StatusActivity extends AppCompatActivity {

	private RecyclerView recyclerView;
	private StatusAdapter statusAdapter;
	private List<StatusItem> statusList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);

		recyclerView = findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		// Initialize an empty list or fetch data from Firestore
		statusList = fetchDataFromFirestore();
		// Initialize the adapter with the statusList
		statusAdapter = new StatusAdapter(statusList);
		// Set the adapter to the RecyclerView
		recyclerView.setAdapter(statusAdapter);
	}

	// Method to fetch data from Firestore or create a sample list for demonstration
	private List<StatusItem> fetchDataFromFirestore() {
		List<StatusItem> statusItemList = new ArrayList<>();

		FirebaseFirestore db = FirebaseFirestore.getInstance();
		CollectionReference userCollection = db.collection("user");

		userCollection.get().addOnCompleteListener(task -> {
			if (task.isSuccessful()) {
				for (QueryDocumentSnapshot document : task.getResult()) {
					// Assuming "issue" and "status" are fields in your documents
					String issue = document.getString("issue");
					String status = document.getString("status");

					// Create a new StatusItem and add it to the list
					StatusItem statusItem = new StatusItem(issue, status);
					statusItemList.add(statusItem);
				}

				// Notify the adapter that the data set has changed
				statusAdapter.notifyDataSetChanged();
			} else {
				// Handle errors
				Log.e("Firestore", "Error getting documents: ", task.getException());
			}
		});

		return statusItemList;
	}

}
