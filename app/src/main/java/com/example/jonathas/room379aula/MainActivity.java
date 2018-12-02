package com.example.jonathas.room379aula;





import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static MyAppDatabase myAppDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(
                getApplicationContext(),
                MyAppDatabase.class,
                "userDB").allowMainThreadQueries().
                build();


        fragmentManager.beginTransaction().add(
                R.id.frameConteiner, new HomeFragment()
        ).commit();

    }
}
