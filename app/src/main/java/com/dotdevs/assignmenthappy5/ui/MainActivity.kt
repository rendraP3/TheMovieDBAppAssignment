package com.dotdevs.assignmenthappy5.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dotdevs.assignmenthappy5.R
import com.dotdevs.assignmenthappy5.ui.movie.MovieViewModel
import com.dotdevs.assignmenthappy5.utils.Status
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

private const val REQUEST_CODE_PERMISSIONS = 5000
private val REQUIRED_PERMISSIONS = arrayOf(
    Manifest.permission.INTERNET,
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.ACCESS_NETWORK_STATE
)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavBar: BottomNavigationView

    companion object {
        private val TAG = MainActivity::class.java.simpleName

        fun notifier(context: Context, msg: String, length: Int) =
            if (length == 0) Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        else Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupViews()
    }

    private fun initViews() {
        bottomNavBar = findViewById(R.id.bottom_nav_view)
    }

    private fun setupViews() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavBar.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.nav_home,
                R.id.nav_tv,
                R.id.nav_favorite
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionGranted()) {
                return
            } else {
                notifier(this, "Permission not granted by user.", 0)
            }
        }
    }

    private fun allPermissionGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }
}