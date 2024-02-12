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

    /**
     * Creates music with the given pitches rhythms and loops based on oneshot
     * @param pitchArray the list of pitches to use
     * @param rythymVal the list of rhythms to use alongside the pitches
     * @param oneshot should the song play once or loop
     */
    public MusicHandler(int[] pitchArray, double rythymVal, boolean oneshot){
        phrase = new Phrase();
        phrase.addNoteList(pitchArray, rythymVal);
        isOneshot = oneshot;
        Engine.musicInstances.add(this);
    }

    /**
     * Use's a phrase to play instead of defining it atomically
     * @param p phrase to play
     * @param oneshot should it play once
     */
    public MusicHandler(Phrase p, boolean oneshot){
        phrase = p;
        isOneshot = oneshot;
        Engine.musicInstances.add(this);
    }

    /**
     * Creates a random phrase within the bounds
     * @param length size of the resulting phrase
     * @param upperBound upper bound for pitch randomness
     * @param lowerBound lower bound for pitch randomness
     * @param upperRhythm upper bound for the rhythm randomness
     * @return returns a randomized phrase
     */
    public static Phrase CreateRandomPhrase(int length, int upperBound, int lowerBound, int upperRhythm){
        Phrase ph = new Phrase();

        for(int i=0; i< length; i++)
        {
            Random rand = new Random();
            int pitch = rand.nextInt(upperBound + 1 - lowerBound)+lowerBound;
            int rhythm = rand.nextInt(upperRhythm);
            ph.add(new Note(pitch, rhythm));
        }
        return ph;
    }

    /**
     * Creates a phrase with adjustable pitch randomness but locked rhythm
     * to a bound of 4
     * @param length size of the phrase
     * @param upperBound upperbound of the pitch
     * @param lowerBound lowerbound of the pitch
     * @return returns a random phrase
     */
    public static Phrase CreateRandomPhrase(int length, int upperBound, int lowerBound){
        Phrase ph = new Phrase();

        for(int i=0; i< length; i++)
        {
            Random rand = new Random();
            int pitch = rand.nextInt(upperBound + 1 - lowerBound)+lowerBound;
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

    /**
     * Stops current songs
     */
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
