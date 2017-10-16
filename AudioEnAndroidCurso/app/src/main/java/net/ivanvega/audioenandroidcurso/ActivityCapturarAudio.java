package net.ivanvega.audioenandroidcurso;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityCapturarAudio extends Activity implements OnClickListener {
	Button btnGrabar, btnReproducir;
	boolean flag=true;
	MediaRecorder mr=null;
	MediaPlayer mp = null; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capturar_audio);
		
		//recuperar parametros
		Intent i = getIntent();
		String parametro = i.getStringExtra("miparametro");
		Toast.makeText(getBaseContext(),
				"Esta actividad recibio el siguiente parametro" + parametro
				, Toast.LENGTH_LONG).show();
		
		btnGrabar = (Button)findViewById(R.id.btnGrabar);
		btnReproducir = (Button)findViewById(R.id.btnReproducir);
		btnGrabar.setOnClickListener(this);
		btnReproducir.setOnClickListener(this);
		btnReproducir.setEnabled(false);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.equals(btnGrabar)){
			this.onGrabar(flag);
		}
		
		if (v.equals(btnReproducir)){
			this.onReproducir(flag);
		}
	}
	
	private void onGrabar(boolean accion){
		if(accion){
			btnGrabar.setText("Parar grabacion");
			flag = false;
			this.startGrabar();
		}else{
			btnGrabar.setText("Grabar audio");
			btnReproducir.setEnabled(true);
			flag= true;
			this.stopGrabar();
		}
			
	}
	
	private void onReproducir(boolean accion){
		if(accion){
			btnReproducir.setText("Parar reproduccion");
			flag = false;
			btnGrabar.setEnabled(false);
			this.startReproducir();
		}else{
			btnReproducir.setText("Reproducir audio");
			flag = true;
			btnGrabar.setEnabled(true);
			this.stopReproducir();
		}
	}
	
	private void startGrabar() {
		mr = new MediaRecorder();
		mr.setAudioSource(MediaRecorder.AudioSource.MIC);
		mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		File audio = new File(dir, "migrabacion.3gp");
		mr.setOutputFile(audio.getAbsolutePath());
		mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		try {
			mr.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mr.start();
		

	}
	
	private void stopGrabar() {
		mr.stop();
		mr.release();
		mr=null;
	}
	
	private void startReproducir(){
		mp = new MediaPlayer();
		File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		try {
			mp.setDataSource(dir.getAbsolutePath() + "/migrabacion.3gp");
			mp.prepare();
			mp.start();
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
	
	private void stopReproducir(){
		mp.stop();
		mp.release();
		mp = null;
	}
}
