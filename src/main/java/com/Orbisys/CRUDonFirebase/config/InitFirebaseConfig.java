package com.Orbisys.CRUDonFirebase.config;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Component
@SuppressWarnings("all")
public class InitFirebaseConfig {

    @PostConstruct
    public void initFirebaseConfig() {

        final FirebaseOptions options;

        try {

            // Load Firebase.json;
            InputStream serviceAccount = new ClassPathResource("firebase/firebase.json").getInputStream();

            // set FirebaseOptions from serviceAccount(input stream);
            options = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://firstproject-ebafb-default-rtdb.firebaseio.com/")
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException occurs");

        } catch (Exception allEx) {
            allEx.printStackTrace();
            System.out.println("Unknown Exception occurs");
        }

        System.out.println("Successfully init firebase");

    }
}
