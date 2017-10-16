package net.ivanvega.audioenandroidcurso;

import java.io.File;
import java.io.IOException;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnPreparedListener, OnCompletionListener {
	MediaPlayer mp;

	public void checkPermissionExternalStorage ( AppCompatActivity thisActivity){
		// Here, thisActivity is the current activity
		if (ContextCompat.checkSelfPermission(thisActivity,
				Manifest.permission.WRITE_EXTERNAL_STORAGE)
				!= PackageManager.PERMISSION_GRANTED) {

			// Should we show an explanation?
			if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
					Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

				// Show an expanation to the user *asynchronous
				// ly* -- don't block
				// this thread waiting for the user's response! After the user
				// sees the explanation, try again to request the permission.
				Toast.makeText(this,"No hay permiso", Toast.LENGTH_SHORT).show();


			} else {

				// No explanation needed, we can request the permission.

				ActivityCompat.requestPermissions(thisActivity,
						new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
						1001);

				// MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
				// app-defined int constant. The callback method gets the
				// result of the request.
			}
		}else{
			//doThings();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		switch (requestCode) {
			case 1001: {
				//premission to read storage
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {

					// permission was granted, yay! Do the
					// contacts-related task you need to do.
					//doThings();
				} else {

					// permission denied, boo! Disable the
					// functionality that depends on this permission.
					Toast.makeText(this, "We Need permission Storage", Toast.LENGTH_SHORT).show();
				}
				return;
			}

			// other 'case' lines to check for other
			// permissions this app might request
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.checkPermissionExternalStorage(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void btnRecurso_click(View v) {
		MediaPlayer mp = MediaPlayer.create
				(this, R.raw.low_rider);
		mp.start();
				
	}
	
	public void btnDispositivo_click(View v) {
		mp = new MediaPlayer();
		
		File dirMusic = Environment.getExternalStoragePublicDirectory
		(Environment.DIRECTORY_MUSIC);
		String ruta = dirMusic.getAbsolutePath() + "/sonata.mp3";
		try {
			mp.setDataSource(ruta);
			mp.setOnCompletionListener(this);
			mp.setOnPreparedListener(this);
			mp.prepareAsync();
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mp.seekTo(1000 * 60 * 1);
		mp.start();
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		mp.release();
		mp = null;
		File dirMusic = Environment.getExternalStoragePublicDirectory
		(Environment.DIRECTORY_MUSIC);
		String ruta = dirMusic.getAbsolutePath() + "/06 Searchin.mp3";
		try {
			mp = new MediaPlayer();
			mp.setDataSource(ruta);
			mp.prepareAsync();
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void btnCapturarAudio_click(View v) {
		Intent iCapt =
				new Intent("net.ivanvega.audioenandroidcurso.CAPTURARAUDIO");
		iCapt.putExtra("miparametro", "Este es un parametro pasado");
		startActivity(iCapt);
	}
	
	public void btnTomarPic_click(View v) {
		startActivity(new
				Intent(this, CapturaFoto.class));
	}

	public void video(View v) {
		startActivity(new
				Intent(this, CapturaVideo.class));
	}
}
