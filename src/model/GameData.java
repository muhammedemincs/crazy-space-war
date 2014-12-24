package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 


public class GameData 
{
	//Properties
	GameLevel level ;
	Settings setting ;
	private int[] topList;
	
	//Methods
	
	
	public GameData()
	{
		level = new GameLevel() ;
		setting = new Settings();
		topList = new int[3];
		
	}
	
	public void  writeToFileExample(String str) {
		
			try {
	 
				String content = str ;
	 
				File file = new File("score.txt");
	 
				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}
	 
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();
	 
				System.out.println("Done");
	 
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//to be done
	public ArrayList<String> getHighScores()
	{
		ArrayList<String> l = new ArrayList<String>();
		//get list from file and return
		return l;
	}
	
	
	//to be done
	public boolean isInTopList(int score)
	{	
		return true;
	}
	
	//to be done
	private void readScoreToFile()
	{
		
	}

	public void updateHighScores(String name, int score) {
		String str = name + " " + score + "\n";
		writeToFileExample(str);
	}
	
	

}
