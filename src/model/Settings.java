package model;

public class Settings 
{
	private int difficulty ;
	private boolean music , sound ;
	
	
	public Settings() {
		this.setDifficulty(1) ;
		this.setMusic(true) ;
		this.setSound(true) ;
		
	}
	
	
	public Settings( int difficulty, boolean music , boolean sound)
	{
		this.setDifficulty(difficulty) ;
		this.setMusic(music) ;
		this.setSound(sound) ;
		
	}

	public Settings changeSettings(int difficulty, boolean music , boolean sound)
	{
		this.difficulty = difficulty ;
		this.setMusic(music) ;
		this.sound = sound ;
		return this;
	}

	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public boolean isSound() {
		return sound;
	}


	public void setSound(boolean sound) {
		this.sound = sound;
	}


	public boolean isMusic() {
		return music;
	}


	public void setMusic(boolean music) {
		this.music = music;
	}
	
	
}
