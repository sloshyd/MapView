package sloshyd.uk.mapview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

/*There are three ways to display a map
    SupportMapFragment
    MapFragment (Fragment API) - Froyo and above
    MapView (not part of Fragment API)

    Selecting MapActivity - creates a MapFragment but set up much easier to set up
    as most is done by IDE on set up (it will get SHA1 debug.keystore) and do imports
    and configuration to the Manifest.

    Setting up MapView

    create the following permission in the manifest

     <permission
        android:name="uk.sloshyd.gmapsapp.permissoion.MAPS_RECIEVED"
            android:protectionLevel = "signature"/>

    <uses-permission android:name="uk.sloshyd.gmapsapp.permissoion.MAPS_RECIEVED"/>
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="com.google.android.providers.gsf.permission.READ_GSERVICES" />
    <!--
 The ACCESS_COARSE/FINE_LOCATION permissions are not required to use
         Google Maps Android API v2, but are recommended.
    -->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

    <uses-feature
        android:glEsVersion="0x00020000"
        android:required="true" />

    Find debug.keystore

    (on VIAO laptop is on C:/users/darren brooks/.android/debug.keystore")
    Default would usually be in the java/jre/bin
    in c:/program files/java/jre1.8.0_25\bin run the following
    keytool -list - keystore "C:/users/darren brooks/.android/debug.keystore"
    password: android

    Note use " " as the space between darren and brooks will cause it to fail

    IMPORTANT must add GooglePlayService by adding a line in build.gradle(module:app)

    compile 'com.google.android.gms:play-services:7.0.0' IMPORTANT must update the
    version when play-services are updated

    IMPORTANT: once the mapView has been created inorder for it to be visible need to
    override onCreate(), onPause(), onResume(), onDestroy() (good to do for onLowMemory(),
    and onStatusResume())
    and in these methods need to add the same method calls form mapView ie in onCreate()
    add mapView.onCreate()

    MainActivity - uses xml to control map

*/
public class MainActivity extends ActionBarActivity {

    GoogleMap mMap;
    MapView mapView;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
       return super.onOptionsItemSelected(item);
    }
}
