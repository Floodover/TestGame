package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Updater {

	private static String currentVersion, newVersion;
	public int update =0; //Used to keep track of how many updates have occured
	
	
	public static void checkForUpdate(boolean isAuto) {
		currentVersion = TextFile.readFile("./version.txt");
		
		try {
			URL site = new URL("PUT VERSION TXT LOCATION HERE");
			ReadableByteChannel rbc = Channels.newChannel(site.openStream());
			FileOutputStream fos = new FileOutputStream ("./version.txt");
			fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
