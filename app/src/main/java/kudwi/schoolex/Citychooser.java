package kudwi.schoolex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harishananth on 20/06/17.
 */

public class Citychooser extends AppCompatActivity {
    String uname,uemail,url;
    Spinner spinner;
    Button next;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citychooser);
        Bundle extras=getIntent().getExtras();
        if(extras!=null) {
            uname = extras.getString("name");
            uemail = extras.getString("email");
            url = extras.getString("url");
        }

        next=(Button)findViewById(R.id.nextbut);
        next.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                launchHomeScreen();
            }
        });
        spinner=(Spinner)findViewById(R.id.spinner);
        List<String> cities=new ArrayList<>();
        cities.add("Pick a city");
        cities.add("Chennai");
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Banglore");
        cities.add("Kolkata");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cities);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                String item = spinner.getItemAtPosition(i).toString();

                // Showing selected spinner item
                Toast.makeText(Citychooser.this, "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    private void launchHomeScreen() {
        Intent intent=new Intent(Citychooser.this,MainActivity.class);
        intent.putExtra("name",uname);
        intent.putExtra("email",uemail);
        intent.putExtra("url",url);
        startActivity(intent);
        finish();
    }

    private class View {
    }
}
