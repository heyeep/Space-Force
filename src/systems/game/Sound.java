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
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang
 */
 //hoang
public class Sound {
    private String ShootFile, CollisionFile , DeathFile, WonFile, BackgroundFile, EarnFile, BackgroundWindow;
    private Clip clipBackGroundGame, clipCollision, clipDeath, clipWon, clipEarn,clipShoot, clipBackgroundMainWindow;
    public Sound()
    {
        WonFile= "assets/sounds/won.wav";
        EarnFile="assets/sounds/earn.wav";
        ShootFile="assets/sounds/silencer.wav";
        CollisionFile="assets/sounds/sfx_shoot.wav";
        BackgroundFile="assets/sounds/8BitMetal.wav";
        DeathFile="assets/sounds/GameOver.wav";
        BackgroundWindow="assets/sounds/window.wav";
    }
    public Sound(String ShootFile, String CollisionFile , String DeathFile, String WonFile, String BackgroundFile, String EarnFile, String BackgroundWindow){
        if(!"".equals(ShootFile) || ShootFile!=null)
            this.ShootFile=ShootFile;
        else
            this.ShootFile="silencer.wav";
        if(!"".equals(CollisionFile) || CollisionFile!=null)
            this.CollisionFile = CollisionFile;
        else
            this.CollisionFile="sfx_shoot.wav";
        if(!"".equals(DeathFile) || DeathFile!=null)
            this.DeathFile= DeathFile; 
        else
            this.DeathFile="GameOver.wav";
        if(!"".equals(WonFile) || WonFile!=null)    
            this.WonFile= WonFile;
        else
            this.WonFile="won.wav";
        if(!"".equals(BackgroundFile) || BackgroundFile!=null)
            this.BackgroundFile=BackgroundFile;
        else
            this.BackgroundFile="8BitMetal.wav";
        if(!"".equals(EarnFile) || EarnFile!=null)
            this.EarnFile=EarnFile;
        else
            this.EarnFile="earn.wav";
        if(!"".equals(BackgroundWindow) || BackgroundWindow!=null)
            this.BackgroundWindow=EarnFile;
        else
            this.BackgroundWindow="window.wav";
    }
    public String getShootFile(){
        return this.ShootFile;
    }
    public void setShootFile(String s){
        if(!"".equals(s)||s!=null)
            this.ShootFile=s;
        else
            this.ShootFile="silencer.wav";
    }
    public String getCollisionFile(){
        return this.CollisionFile;
    }
    public void setCollisionFile(String s){
        if(!"".equals(s)||s!=null)
            this.CollisionFile=s;
        else 
            this.CollisionFile="sfx_shoot.wav";
    }
    public String getDeathFile(){
        return this.DeathFile;
    }
    public void setDeathFile(String s){
        if(!"".equals(s)||s!=null)
            this.DeathFile=s;
        else 
            this.DeathFile="GameOver.wav";
    }
    public String getWonFile(){
        return this.WonFile;
    }
    public void setWonFile(String s){
        if(!"".equals(s)||s!=null)
            this.WonFile=s;
        else
            this.WonFile="won.wav";
    }
    public String getBackgroundFile(){
        return this.BackgroundFile;
    }
    public void setBackgroundFile(String s){
        if(!"".equals(s)||s!=null)
            this.BackgroundFile=s;
        else
            this.BackgroundFile="8BitMetal.wav";
    }
    public String getEarnFile(){
        return this.EarnFile;
    }
    public void setEarnFile(String s){
        if(!"".equals(s)||s!=null)
            this.EarnFile=s;
        else 
            this.EarnFile="earn.wav";
    }
    
    public String getBackgroundWindow(){
        return this.BackgroundWindow;
    }
    public void setBackgroundWindow(String s){
        if(!"".equals(s)||s!=null)
            this.BackgroundWindow=s;
        else
            this.BackgroundWindow="window.wav";
    }
    public void Shoot()
    {
        try {        
            File soundFile = new File(ShootFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            clipShoot = AudioSystem.getClip();  
            clipShoot.open(audioIn);
            clipShoot.start();
            
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
            clipCollision = AudioSystem.getClip();  
            clipCollision.open(audioIn);
            clipCollision.start();
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
            clipBackGroundGame = AudioSystem.getClip();  
            clipBackGroundGame.open(audioIn);
            clipBackGroundGame.start();
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
       try {        
            File soundFile = new File(DeathFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            clipDeath = AudioSystem.getClip();  
            clipDeath.open(audioIn);
            clipDeath.start();
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
            clipEarn = AudioSystem.getClip();  
            clipEarn.open(audioIn);
            clipEarn.start();
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
       try {        
            File soundFile = new File(WonFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
            clipWon = AudioSystem.getClip();  
            clipWon.open(audioIn);
            clipWon.start();
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
    public void StopSoundBackgroundGame(){
        if(clipBackGroundGame!=null)
                clipBackGroundGame.stop();
    }
    public void PlaySoundBackgroundGame(){
        if(clipBackGroundGame!=null)
                clipBackGroundGame.start();
    }
    public void StopSoundCollision(){
        if(clipCollision!=null)
                clipCollision.stop();
    }
    public void PlaySoundCollision(){
        if(clipCollision!=null)
                clipCollision.start();
    }
    public void StopSoundDeath(){
         if(clipDeath!=null)
                clipDeath.stop();
    }
    public void PlaySoundDeath(){
         if(clipDeath!=null)
                clipDeath.start();
    }
    public void StopSoundEarn(){
         if(clipEarn!=null)
                clipEarn.stop();
    }
    public void StartSoundEarn(){
         if(clipEarn!=null)
                clipEarn.start();
    }
    public void StopSoundWon(){
        if(clipWon!=null)
                clipWon.stop();
    }
    public void StartSoundWon(){
        if(clipWon!=null)
                clipWon.start();
    }
    public void StopSoundShoot(){
        if(clipShoot!=null)
                clipShoot.stop();
    }
    public void StartSoundShoot(){
        if(clipShoot!=null)
                clipShoot.start();
    }
    public void StopSoundBackgroundWindow(){
        if(clipBackgroundMainWindow!=null)
                clipBackgroundMainWindow.stop();
    }
    public void StartSoundBackgroundWindow(){
        if(clipBackgroundMainWindow!=null)
                clipBackgroundMainWindow.start();
    }
    public void StopAllSounds(){
        try{
            if(clipBackGroundGame!=null)
                clipBackGroundGame.stop();
            if(clipCollision!=null)
                clipCollision.stop();
            if(clipDeath!=null)
                clipDeath.stop();
            if(clipEarn!=null)
                clipEarn.stop();
            if(clipWon!=null)
                clipWon.stop();
            if(clipShoot!=null)
                clipShoot.stop();
            if(clipBackgroundMainWindow!=null)
                clipBackgroundMainWindow.stop();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Can't stop all sounds. Error: " + e.getMessage());
        }
    }
    //end Hoang
    // Hiep
    public void stopSound () {
        try {
            Clip clip = AudioSystem.getClip();
            clip.flush();
            clip.stop();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }
    // End
}
