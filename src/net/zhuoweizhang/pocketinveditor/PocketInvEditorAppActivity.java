package net.zhuoweizhang.pocketinveditor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;


public final class PocketInvEditorAppActivity extends PocketInvEditorActivity {

	public static final String PRO_APP_ID = "net.zhuoweizhang.pocketinveditor.pro";

	public static final String GOOGLE_PLAY_URL = "market://details?id=";

	public static final String AMAZON_APPSTORE_URL = "amzn://apps/android?p=";

	@Override
	protected void loadContentView() {
		setContentView(R.layout.world_select);
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
