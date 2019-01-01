package com.pigexpense.home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;
import com.pigexpense.home.Expense;


public class Home {

	public static void main(String args[]) throws IOException {
		
		System.out.println("HI");
		FileInputStream serviceAccount =
				new FileInputStream("./src/main/key/serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://munnyhunny-53807.firebaseio.com/")
				.build();

		FirebaseApp.initializeApp(options);
		
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference();
		DatabaseReference reff = ref.child("expenses");
		
		Map<String, Expense> users = new HashMap<String, Expense>();
		users.put("alanisawesome", new Expense("Pig", 3, "a New Programming Language"));
		users.put("gracehop", new Expense("Pig", 3, "a New Programming Language"));

		reff.setValueAsync(users);
		
		DatabaseReference newPostRef = reff.push();
		newPostRef.setValueAsync(new Expense("Pig", 3, "a New Programming Language"));

	}

}
