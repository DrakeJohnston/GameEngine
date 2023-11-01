package com.drake.engine;

import com.drake.engine.core.Engine;
import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

import java.util.Random;

public class MusicHandler implements Runnable {

    Phrase phrase;
    boolean isOneshot;
    private boolean isActive = true;

    public MusicHandler(int[] pitchArray, double rythymVal, boolean oneshot){
        phrase = new Phrase();
        phrase.addNoteList(pitchArray, rythymVal);
        isOneshot = oneshot;
        Engine.musicInstances.add(this);
    }
    public MusicHandler(Phrase p, boolean oneshot){
        phrase = p;
        isOneshot = oneshot;
        Engine.musicInstances.add(this);
    }

    public static Phrase CreateRandomPhrase(int length, int upperBound, int lowerBound, int upperRhythm){
        Phrase ph = new Phrase();

        for(int i=0; i< length; i++)
        {
            Random rand = new Random();
            int pitch = rand.nextInt(lowerBound, upperBound);
            int rhythm = rand.nextInt(upperRhythm);
            ph.add(new Note(pitch, rhythm));
        }
        return ph;
    }
    public static Phrase CreateRandomPhrase(int length, int upperBound, int lowerBound){
        Phrase ph = new Phrase();

        for(int i=0; i< length; i++)
        {
            Random rand = new Random();
            int pitch = rand.nextInt(lowerBound, upperBound);
            int rhythm = rand.nextInt(4);
            ph.add(new Note(pitch, rhythm));
        }
        return ph;
    }

    public void PlayCurrentPhraseOneshot(){
        Play.midi(phrase);
    }

    public void PlayCurrentPhraseRepeat(){
        Mod.repeat(phrase);
        Play.midi(phrase);
    }

    public void StopSong(){
        Play.stopMidi();
        Play.stopAudio();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void run() {
        if(isActive) {
            if (isOneshot) {
                PlayCurrentPhraseOneshot();
            } else {
                PlayCurrentPhraseRepeat();
                run();
            }
        }else{
            StopSong();
        }
    }
}
