package net.ivanvega.miaudiolibros.fragments;

import android.icu.text.IDNA;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;

import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.TextView;

import net.ivanvega.miaudiolibros.InfoGlobal;
import net.ivanvega.miaudiolibros.Libro;
import net.ivanvega.miaudiolibros.R;

import java.io.IOException;

/**
 * Created by alcohonsilver on 19/09/17.
 */

public class DetalleFragment extends Fragment
        implements View.OnTouchListener, MediaPlayer.OnPreparedListener,
        MediaController.MediaPlayerControl {

    public static String ARG_ID_LIBRO = "id_libro";
    MediaPlayer mediaPlayer;
    MediaController mediaController;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflador, @Nullable ViewGroup contenedor, @Nullable Bundle savedInstanceState) {

        View vista = inflador.inflate(R.layout.layout_fragment_detalle,
                contenedor, false);

        Bundle args = getArguments();
            if (args != null) {
                int position = args.getInt(ARG_ID_LIBRO);
                 ponInfoLibro(position, vista);
            } else {
                ponInfoLibro(0, vista);
            }
            return vista;
    }

    private void ponInfoLibro(int id, View vista) {

        Libro libro = Libro.ejemploLibros().elementAt(id);
        ((TextView) vista.findViewById(R.id.titulo)).setText(libro.titulo);
        ((TextView) vista.findViewById(R.id.autor)).setText(libro.autor);
        ((ImageView) vista.findViewById(R.id.portada))
                .setImageResource(libro.recursoImagen);
        vista.setOnTouchListener(this);
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaController = new MediaController(getActivity());
        Uri audio = Uri.parse(libro.urlAudio);
        try {
            mediaPlayer.setDataSource(getActivity(), audio);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            Log.e("Audiolibros", "ERROR: No se puede reproducir "+audio,e);
        }
    }

    public void ponInfoLibro(int id) {

        ponInfoLibro(id, getView());
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        Log.d("Audiolibros", "Entramos en onPrepared de MediaPlayer");
        mediaPlayer.start();
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(getView().findViewById(R.id.fragment_detalle));
                mediaController.setEnabled(true);
        mediaController.show();
    }

    @Override
    public void onStop() {
        mediaController.hide();
        try {
            mediaPlayer.stop();
            mediaPlayer.release();
        } catch (Exception e) {
            Log.d("Audiolibros", "Error en mediaPlayer.stop()"); }
        super.onStop();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mediaController.show();
        return false;
    }

    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public int getDuration() {

        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {

        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int i) {
        mediaPlayer.seekTo(i);
    }

    @Override
    public boolean isPlaying() {

        return mediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage()
    {
        return 0;
    }

    @Override
    public boolean canPause() {

        return true;
    }

    @Override
    public boolean canSeekBackward() {

        return true;
    }

    @Override
    public boolean canSeekForward() {

        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
