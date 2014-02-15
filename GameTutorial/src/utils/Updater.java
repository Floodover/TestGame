package utils;

import game.Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

public class Updater {

	private static String currentVersion, newVersion;
	public int update = 0; // Used to keep track of how many updates have
							// occured

	public static void checkForUpdate(boolean isAuto) {
		currentVersion = TextFile.readFile("./version.txt");
		
		try {
			URL site = new URL("https://raw.github.com/Floodover/TestGame/master/GameTutorial/version.txt");
			ReadableByteChannel rbc = Channels.newChannel(site.openStream());
			FileOutputStream fos = new FileOutputStream ("./version.txt");
			fos.getChannel().transferFrom(rbc, 0, 1 << 24);
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		newVersion = TextFile.readFile("./version.txt");
		
		if (currentVersion.equals(newVersion)) {
			if(!isAuto)
				doNotUpdate();
		} else {
			Object[] options = 
				{
					"Update",
					"Do not Update"
				};
			int temp = JOptionPane.showOptionDialog(null, "An update has been found (current version:" 
				+ currentVersion+ " new version: " + newVersion, "Update", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
			if(temp ==1)
				return;
			else {
				TextFile.writeFile("./version.txt", newVersion);
				
			}
		}
		
		
	}
	
	private static void finishUpdate() {
		JOptionPane.showMessageDialog(null,  "Game has been updated ", "Update", JOptionPane.INFORMATION_MESSAGE);
		Game.exit();
	}

	private static void doNotUpdate() {
		JOptionPane.showMessageDialog(null, "No update found", "Update", JOptionPane.INFORMATION_MESSAGE);
		return;
	}

}
