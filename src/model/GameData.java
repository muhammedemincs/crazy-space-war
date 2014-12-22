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
	
	//Methods
	
	public void  writeToFileExample(String str) {
		
			try {
	 
				String content = str ;
	 
				File file = new File("/users/mkyong/filename.txt");
	 
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
		
	}
	
	public boolean isInTopList()
	{
		
		
	}
	
	public void writeScoreToFile(int score)
	{
		String str =score+"";
		writeToFileExample(str);
	}
	
	
	
	

}
