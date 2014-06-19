package net.zhuoweizhang.pocketinveditor;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.*;


public final class PocketInvEditorAppActivity extends PocketInvEditorActivity {

	public static final String PRO_APP_ID = "net.zhuoweizhang.pocketinveditor.pro";

	public static final String GOOGLE_PLAY_URL = "market://details?id=";

	public static final String AMAZON_APPSTORE_URL = "amzn://apps/android?p=";

	public static final String AD_UNIT_ID = "a151b28451d9a92";

	public static final String DEVICE_ID_TESTER = "DF28838C26BDFAE7EB063BFEB7A241D3";

	public AdView adView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		adView = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder()
			.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
			.addTestDevice(DEVICE_ID_TESTER)
			.build();
		adView.loadAd(adRequest);
	}

	@Override
	protected void onPause() {
		super.onPause();
		adView.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		adView.resume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		adView.destroy();
	}

	@Override
	protected void loadContentView() {
		setContentView(R.layout.world_select);
	}

	@Override
	protected void openWorld(File worldFile) {
		Intent intent = new Intent(this, EditorAppActivity.class);
		intent.putExtra("world", worldFile.getAbsolutePath());
		startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.worldselect_getpro) {
			displayGetProActivity();
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

	public void displayGetProActivity() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse((this.getResources().getBoolean(R.bool.amazon_appstore)? AMAZON_APPSTORE_URL : GOOGLE_PLAY_URL) + PRO_APP_ID));
		try {
			this.startActivity(intent);
		} catch (Exception e) {
			displayForumsThread();
		}
	}

	public void displayForumsThread() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(AboutAppActivity.FORUMS_PAGE_URL));
		startActivity(intent);
	}
}
