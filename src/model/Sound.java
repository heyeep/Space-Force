/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication10;

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
        CollisionFile = "";
        DeathFile= ""; 
        WonFile= "";
        BackgroundFile="";
        EarnFile="";
        ShootFile="silencer.wav";
        CollisionFile="sfx_shoot.wav";
        BackgroundFile="8BitMetal.wav";
        DeathFile="GameOver.wav";
    }
    public Sound(String ShootFile){
        this.ShootFile=ShootFile;
        CollisionFile = "";
        DeathFile= ""; 
        WonFile= "";
        BackgroundFile="";
        EarnFile="";
        //ShootFile="silencer.wav";
        CollisionFile="sfx_shoot.wav";
        BackgroundFile="8BitMetal.wav";
        DeathFile="GameOver.wav";
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
     public void Death()
    {
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
}
