
package gameCore;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {

	private static String fileName;

	public synchronized void play(String type) {
		switch (type) {
			case "impact":
				fileName = "ImpactSound.wav";
		}

		new Thread(new Runnable() {

			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
				}
			}
		}).start();
	}
}