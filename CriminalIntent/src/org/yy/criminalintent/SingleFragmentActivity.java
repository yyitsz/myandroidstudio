package org.yy.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public abstract class SingleFragmentActivity extends ActionBarActivity {
	protected abstract Fragment createFragment();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentById(R.id.frameContainer);
		if(fragment == null) {
			fragment = createFragment();
			fragmentManager.beginTransaction()
				.add(R.id.frameContainer, fragment)
				.commit();
		}
	}

	
}
