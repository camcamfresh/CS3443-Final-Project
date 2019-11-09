package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author Cary Inzerello & Cameron Salazar
 *
 */
public class HighScore {
	private static final String fileName = "src/resources/highscores.csv";
	private static ArrayList<HighScore> allScores = null;
	
	private int score;
	private String name;
	
	/**
	 * @apiNote Reads highscores.csv, if scores is null. Appends objects to allScores ArrayList.
	 * @param score
	 * @param name
	 */
	public HighScore(int score, String name) {
		super();
		this.score = score;
		this.name = name;
		
		if(allScores == null){
			loadScoresFromFile();
		}
		allScores.add(this);
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @apiNote This method loads HighScore objects from highscores.csv and store in allScores.
	 * @apiNote allScores must be null and will assigned a new HighScore ArrayList.
	 */
	public static void loadScoresFromFile() {
		if(allScores == null) {
			
			allScores = new ArrayList<HighScore>();
			File scoresFile = new File(fileName);
			Scanner scoresScanner = null;
			
			try {
				scoresScanner = new Scanner(scoresFile);
				
				while(scoresScanner.hasNextLine()) {
					String [] tokens = scoresScanner.nextLine().split(",");
					if(tokens.length == 2) {
						new HighScore(Integer.valueOf(tokens[1].trim()), tokens[0]);
					}
				}
				
			}
			catch (FileNotFoundException e) {
				try {
					scoresFile.createNewFile();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			finally {
				if(scoresScanner != null) {
					scoresScanner.close();
				}
			}
		}
	}
	
	/**
	 * 
	 * @return sorted ArrayList of known HighScore objects.
	 */
	public static ArrayList<HighScore> getAllUserScores(){
		if(allScores == null) {
			loadScoresFromFile();
		}
		
		if(allScores.size() > 1) {
			allScores.sort(new Comparator<HighScore>() {
				@Override
				public int compare(HighScore o1, HighScore o2) {
					return o2.getScore() - o1.getScore();
				};
			});
		}
		
		return allScores;
	}
	
	/**
	 * @apiNote This method should be called whenever new HighScore objects should be written to file.
	 */
	public static void saveToFile() {
		if(allScores == null) {
			loadScoresFromFile();
		}
		
		File scoresFile = new File(fileName);
		try {
			FileWriter scoresToFile = new FileWriter(scoresFile);
			
			for(HighScore score : allScores) {
				scoresToFile.write(score.getName() + ", " + String.valueOf(score.getScore()));
			}
			
			scoresToFile.close();
			allScores = null;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
