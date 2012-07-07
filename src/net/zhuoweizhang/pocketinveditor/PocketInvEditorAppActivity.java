package net.zhuoweizhang.pocketinveditor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;


public final class PocketInvEditorAppActivity extends PocketInvEditorActivity {

	public static final String PRO_APP_ID = "net.zhuoweizhang.pocketinveditor.pro";

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.worldselect_getpro) {
			displayGetProActivity(this);
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

	public static void displayGetProActivity(Activity ctx) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id=" + PRO_APP_ID));
		ctx.startActivity(intent);
	}
}
