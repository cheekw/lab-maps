package edu.uw.kwc19.maplab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker to mgh and move camera
        val mgh = LatLng(47.655,  -122.3078)
        mMap.addMarker(
            MarkerOptions()
                .position(mgh)
                .title("ducks that dwell here poop everywhere")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mgh))
        val rectOptions =  PolylineOptions()
            .add(LatLng(47.653975, -122.308101))
            .add(LatLng(47.653581, -122.307981))
            .add(LatLng(47.653922, -122.307833))
            .add(LatLng(47.653577, -122.307640))
            .add(LatLng(47.653995, -122.307549))
            .color(R.color.huskyPurple)
        mMap.addPolyline(rectOptions)
    }
}
