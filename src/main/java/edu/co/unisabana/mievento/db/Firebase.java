package edu.co.unisabana.mievento.db;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class Firebase{

    @PostConstruct
    public void inicializarFirebase(){
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("")
                    .build();

            FirebaseApp.initializeApp(options);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
