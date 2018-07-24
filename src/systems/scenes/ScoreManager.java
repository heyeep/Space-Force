/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.io.*;
/**
 *
 * @author Mark Chang
 */
public class ScoreManager {
    public static void main(String[] args)
    {
        //Performa actions here
        insertScore("Mark,999");
    }
    /**
     * Inserts score onto the scoreboard text file ("scores.txt")
     * Input Parameter "score": String following the pattern of "string,int"
     */
    public static void insertScore(String score)
    {
        BufferedReader reader;
        String[] scorelist = new String[10];
        for(int i = 0; i<10; i++) //Initializing array to "Null"
            {
                scorelist[i] = "null,0";
            }
        try{
            reader = new BufferedReader(new FileReader("scores.txt"));
            String line = reader.readLine();
            int counter = 0;
            while(line != null && counter < 10) //10 scores maximum
                {
                    if(line != null)
                        {
                            scorelist[counter] = line;
                        }
                    line = reader.readLine();
                    counter ++;
                }
            reader.close();
        }
        catch(IOException e)
            {
                e.printStackTrace();
            }
        int insert = 0;
        String[] newScore = score.split(",");
        for(int i = 0; i< 10; i++)
            {
                String[] temp = scorelist[i].split(",");
                if(Integer.parseInt(newScore[1]) < Integer.parseInt(temp[1]))
                    {
                        insert = i+1;
                    }
            }
        String tmp;
        for(int i = 9; i!= insert-1; i--)//scooting everything over
            {
                if(i != 9)
                    {
                        scorelist[i+1] = scorelist[i];
                    }
            }
        if(insert != 10)
            {
                scorelist[insert] = score;
            }
        if(insert != 10 && scorelist[insert].equals(scorelist[insert+1]) == false)
            {
                if(insert <=9)
                    {
                        try{
                            FileWriter fileWriter = new FileWriter("scores.txt", false);
                            for(int i = 0; i<10; i++)
                                {
                                    if(!scorelist[i].equals("null,0"))
                                        {
                                            fileWriter.write(scorelist[i]+"\n");
                                        }
                                }
                            fileWriter.close();
                        }
                        catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                    }
            }
    }
    //Prints score from scores.txt
    public static void printScores()
    {
        BufferedReader reader;
        String[] scorelist = new String[10];
        for(int i = 0; i<10; i++) //Initializing array to "Null"
            {
                scorelist[i] = "null";
            }
        try{
            reader = new BufferedReader(new FileReader("scores.txt"));
            String line = reader.readLine();
            int counter = 0;
            while(line != null && counter < 10) //10 scores maximum
                {
                    if(line != null)
                        {
                            scorelist[counter] = line;
                        }
                    line = reader.readLine();
                    counter ++;
                }
            reader.close();
        }
        catch(IOException e)
            {
                e.printStackTrace();
            }
        for(int i = 0; i< 10; i++)
            {
                if(!scorelist[i].equals("null"))
                    {
                        String[] output = scorelist[i].split(",");
                        String temp =String.format(output[0] + ": " + output[1] + "\n");
                        System.out.print(temp);
                    }
            }
    }
    //Clears the text file of any previous scores
    public static void clear()
    {
        try{
            FileWriter fileWriter = new FileWriter("scores.txt", false);
            for(int i = 0; i<10; i++)
                {
                    fileWriter.write("");
                }
            fileWriter.close();
        }
        catch(IOException e)
            {
                e.printStackTrace();
            }
    }
}
