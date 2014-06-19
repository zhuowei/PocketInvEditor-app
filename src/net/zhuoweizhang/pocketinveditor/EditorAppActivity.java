package net.zhuoweizhang.pocketinveditor;

import android.os.Bundle;

import com.google.android.gms.ads.*;

public class EditorAppActivity extends EditorActivity {
	private AdView adView;
	private InterstitialAd interstitial;
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		adView = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder()
			.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
			.addTestDevice(PocketInvEditorAppActivity.DEVICE_ID_TESTER)
			.build();
		adView.loadAd(adRequest);

		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(PocketInvEditorAppActivity.AD_UNIT_ID);
		AdRequest adRequest2 = new AdRequest.Builder()
			.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
			.addTestDevice(PocketInvEditorAppActivity.DEVICE_ID_TESTER)
			.build();
		interstitial.loadAd(adRequest2);
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
	public void finish() {
		displayInterstitial();
		super.finish();
	}

	private void displayInterstitial() {
		if (interstitial.isLoaded()) interstitial.show();
	}
}
