package com.singh.vinay.hadlercalleverysecond;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnableCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

// Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                makeUseOfNewLocation(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

// Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);





        handler = new Handler();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread
                vinaySingh();
                Log.d("Handlers", "Called on main thread");
                // Repeat this the same runnable code block again another 2 seconds
                handler.postDelayed(runnableCode, 4000);
            }
        };
// Start the initial runnable task by posting through the handler
        handler.post(runnableCode);



        Intent intent = new Intent(this, ThroughServices.class);
        startService(intent);

        ComonModel comonModel = new ComonModel();
        for(int i =0;i>=10;i++){
            comonModel.setId("12");
            comonModel.setLat("12444.9");
            comonModel.setLon("1266.98");
            comonModel.setName("vinay singh");
        }
        ArrayList<ComonModel> alldata = new ArrayList<ComonModel>(Arrays.asList(comonModel));

         ArrayList<LatLongModel> oee = new ArrayList<LatLongModel>();
         LatLongModel latLongModel = new LatLongModel();
        for(ComonModel p : alldata){
            latLongModel.setLat(p.getLat());
            latLongModel.setLog(p.getLon());
            ArrayList<LatLongModel> dfg = new ArrayList<LatLongModel>(Arrays.asList(latLongModel));
            oee.addAll(dfg);
        }


        System.out.print(""+oee.toString());


    }

    private void makeUseOfNewLocation(Location location) {

    }

    private void vinaySingh() {
        Toast.makeText(MainActivity.this,"lol",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Removes pending code execution
        handler.removeCallbacks(runnableCode);
    }
}
