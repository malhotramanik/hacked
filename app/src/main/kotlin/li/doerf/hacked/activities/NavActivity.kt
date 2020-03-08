package li.doerf.hacked.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.crashlytics.android.Crashlytics
import li.doerf.hacked.R


class NavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)
        title = getString(R.string.app_name)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_nav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_privacypolicy -> {
                try {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://doerfli.github.io/hacked/privacy"))
                    startActivity(browserIntent)
                } catch (e: ActivityNotFoundException) {
                    Log.e(TAG, "caught ActivityNotFoundException", e)
                    Crashlytics.logException(e)
                    makeText(applicationContext, getString(R.string.unable_to_start_browser, "https://doerfli.github.io/hacked/privacy"), Toast.LENGTH_LONG).show()
                }
                true
            }
            R.id.action_visit_hibp -> {
                try {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://haveibeenpwned.com"))
                    startActivity(browserIntent)
                } catch (e: ActivityNotFoundException) {
                    Log.e(TAG, "caught ActivityNotFoundException", e)
                    Crashlytics.logException(e)
                    makeText(applicationContext, getString(R.string.unable_to_start_browser, "https://haveibeenpwned.com"), Toast.LENGTH_LONG).show()
                }
                true
            }
            R.id.action_settings -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    companion object {
        private val TAG = "NavActivity"
    }
}
