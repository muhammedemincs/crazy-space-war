package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 


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
	 
				File file = new File("/Users/muhammedemincs/git/crazy-space-war/score.txt");
	 
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
	
	public int getHighScores()
	{
		return 0;
	}
	
	public boolean isInTopList()
	{
		
		
		
		return true;
	}
	
	private void writeScoreToFile(String name, int score)
	{
		String myname = name+" ";
		String str =score+"";
		String laststr=myname+str+"/n";
		writeToFileExample(laststr);
	}
	
	private void readScoreToFile()
	{
		
	}
	
	

}
