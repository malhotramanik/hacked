package li.doerf.hacked.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import li.doerf.hacked.ui.fragments.SettingsFragment;

/**
 * Created by moo on 01/12/15.
 */
public class SettingsActivity extends AppCompatActivity {
    private final String LOGTAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SettingsFragment settingsFragment = new SettingsFragment();
        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, settingsFragment)
                .commit();
    }
}
