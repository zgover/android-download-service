// Zachary Gover
// MDF3 - 1610
// MainActivity

package com.gover.zachary.downloadservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

	public final String[] IMAGES = {
		"MgmzpOJ.jpg", "VZmFngH.jpg", "ptE5z9u.jpg",
		"4QKO8Up.jpg", "Vm2UdDH.jpg", "C040ctB.jpg",
		"MScR8za.jpg", "tM1bsAH.jpg", "fS1lKZx.jpg",
		"h8e5rBX.jpg", "KBtUxzq.jpg", "wYXWJZz.jpg",
		"LOUwRC4.jpg", "7ZSQfIu.jpg", "XLJiKqp.jpg",
		"nXVLE9W.jpg", "HYQuj4b.jpg", "R8YIb8d.jpg",
		"cLv3TVc.jpg", "f7pMMdA.jpg", "Dl1aIHV.jpg",
		"UE3ng26.jpg", "1oyYfr0.jpg", "YSJ28fr.jpg",
		"Ey39hl5.jpg", "HAnhjCI.jpg", "En3J4ZF.jpg",
		"wr65Geg.jpg", "7D35kbV.jpg", "Z2WQBPI.jpg"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Setup Action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Determine selection
		switch(item.getItemId()) {
			case R.id.start_download:
				startDownload();
				break;
			default:
				break;
		}

		return true;
	}

	private void startDownload() {
		// Start the intent image service
		Intent intent = new Intent(this, ImageService.class);
		intent.putExtra("Some key", "Some value");
		startService(intent);
	}
}
