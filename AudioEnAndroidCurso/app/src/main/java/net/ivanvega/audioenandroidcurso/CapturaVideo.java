package net.ivanvega.audioenandroidcurso;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class CapturaVideo extends Activity {
	VideoView vvw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_captura_video);
		vvw= (VideoView)findViewById(R.id.vvw);
		vvw.setMediaController(
				new MediaController(this));
	}
	
	public void click(View v) {
		startActivityForResult
		(new Intent(MediaStore.ACTION_VIDEO_CAPTURE),
				0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Uri video = data.getData();
		vvw.setVideoURI(video);
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.captura_video, menu);
		return true;
	}

}
