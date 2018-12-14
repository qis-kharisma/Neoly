package com.example.qis_rnd.neoly.MapGPS;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

public class accessgps implements LocationListener {
  Context context;
  Location loc;
    public accessgps(Context c){
      context=c;  }
  public Location ambilLokasi(){
      LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
      boolean statusGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);//net
      if  (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
          Toast .makeText(context, "Akses lokasi tidak diijinkan", Toast.LENGTH_LONG).show();

          }
       if(statusGPS){
          lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10,this );
          loc=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
       }else {
          Toast.makeText(context, " aktifkan gps terlebih dahulu", Toast.LENGTH_SHORT).show();
       }


        return loc;
  }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
