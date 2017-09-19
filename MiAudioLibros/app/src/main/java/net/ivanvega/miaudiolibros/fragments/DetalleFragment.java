package net.ivanvega.miaudiolibros.fragments;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;

import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController.MediaPlayerControl;

/**
 * Created by alcohonsilver on 19/09/17.
 */

public class DetalleFragment extends Fragment
        implements View.OnTouchListener, MediaPlayer.OnPreparedListener,
        MediaController.MediaPlayerControl {
    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void seekTo(int i) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
