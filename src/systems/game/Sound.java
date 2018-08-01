/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Hoang
 */
public class Sound {
    private String ShootFile, CollisionFile , DeathFile, WonFile, BackgroundFile, EarnFile;
    public Sound()
    {
        WonFile= "assets/sounds/won.wav";
        EarnFile="assets/sounds/earn.wav";
        ShootFile="assets/sounds/silencer.wav";
        CollisionFile="assets/sounds/sfx_shoot.wav";
        BackgroundFile="assets/sounds/8BitMetal.wav";
        DeathFile="assets/sounds/GameOver.wav";
    }
    public Sound(String ShootFile, String CollisionFile , String DeathFile, String WonFile, String BackgroundFile, String EarnFile){
        this.ShootFile=ShootFile;
        this.CollisionFile = CollisionFile;
        this.DeathFile= DeathFile; 
        this.WonFile= WonFile;
        this.BackgroundFile=BackgroundFile;
        this.EarnFile=EarnFile;
    }
    public void Shoot()
    {
        try {        
            File soundFile = new File(ShootFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            Clip clip = AudioSystem.getClip();  
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void MonsterDied()
    {
        try {
            File soundFile = new File(CollisionFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            Clip clip = AudioSystem.getClip();  
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }        
    }
    public void GameStart()
    {
        this.stopSound();
        try {
            File soundFile = new File(BackgroundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }        
    }
    public void PlayerDeath()
    {
        this.stopSound();
        try {
            File soundFile = new File(DeathFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            Clip clip = AudioSystem.getClip();  
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }        
    }
    public void EarnAward()
    {
        try {
            File soundFile = new File(EarnFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            Clip clip = AudioSystem.getClip();  
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }        
    }
    public void WonGame()
    {
        this.stopSound();
        try {
            File soundFile = new File(WonFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            Clip clip = AudioSystem.getClip();  
            clip.open(audioIn);
            clip.start();
        } 
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }        
    }

    // Dont by Hiep.
    public void stopSound () {
        try {
            Clip clip = AudioSystem.getClip();
            clip.flush();
            clip.stop();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void stopAllSounds() {
    }
}
