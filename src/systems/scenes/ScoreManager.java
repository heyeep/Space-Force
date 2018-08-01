/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication10;

import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
/**
 *
 * @author Mark Chang
 */
public class ScoreManager {
    public static void main(String[] args)
	{
		//Perform actions here
		String [][] tmp = getScores();
		System.out.print(tmp[0][1]);
	}
	public ScoreManager()
	{
	}
	/**  
	 * Inserts score onto the scoreboard text file ("scores.txt")
	 * 0=rank, 1=name, 2=date, 3=gamemode, 4=score
	 * Input Parameter "score": String following the pattern of "0,string,string,int,int"
	 * The rank int and date string can be whatever you want, it's going to be overwritten anyways.
	 */
	public static void insertScore(String score)
	{
		BufferedReader reader;
		String[] scorelist = new String[10];
		for(int i = 0; i<10; i++) //Initializing array to "Null"
		{
			scorelist[i] = "0,null,-/-/-,0,0";
		}
		try{ //Reads the file into scorelist array
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
		String[] newScore = score.split(","); // 0=rank, 1=name, 2=date, 3=gamemode, 4=score
		for(int i = 0; i< 10; i++)
		{
			System.out.print(scorelist[i]);
			String[] temp = scorelist[i].split(",");
			if(Integer.parseInt(newScore[4]) < Integer.parseInt(temp[4]))
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
		if(insert <= 10)
		{
			scorelist[insert] = score;
		}
		String[] cmp1, cmp2;
		cmp1 = scorelist[insert].split(",");
		cmp2 = scorelist[insert+1].split(",");
		if(insert != 10 && cmp1[4].equals(cmp2[4]) == false)
		{
			if(insert <=9)
			{
				try{
					FileWriter fileWriter = new FileWriter("scores.txt", false);
					for(int i = 0; i<10; i++)
					{
						if(!scorelist[i].equals("0,null,-/-/-,0,0"))
						{
							String[] temp = scorelist[i].split(",");
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
							LocalDateTime now = LocalDateTime.now(); 
							fileWriter.write(Integer.toString(i+1) + "," + temp[1] + "," + dtf.format(now) + "," + temp[3] + "," + temp[4] + "\n");
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
	public static String[][] getScores()
	{
		BufferedReader reader;
		String[][] scorelist = new String[10][5];
		for(int i = 0; i<10; i++) //Initializing array to "Null"
		{
			for(int j = 0; j<5; j++)
			{
				scorelist[i][j] = "null";
			}
		}
		try{
			reader = new BufferedReader(new FileReader("scores.txt"));
			String line = reader.readLine();
			int counter = 0;
			while(line != null && counter < 10) //10 scores maximum
			{
				if(line != null)
				{
					String[] tmp = line.split(",");
					scorelist[counter][0] = tmp[0];
					scorelist[counter][1] = tmp[1];
					scorelist[counter][2] = tmp[2];
					scorelist[counter][3] = tmp[3];
					scorelist[counter][4] = tmp[4];
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
		return scorelist;
	}
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
				String temp =(output[0] + " " + output[1]+ " " + output[2] + " " + output[3]+ " " + output[4] + "\n");
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
