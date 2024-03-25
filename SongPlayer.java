

import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class SongPlayer {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        try {
            System.out.println("Enter song name:");
            String song=scan.nextLine();

            File file =new File("assetsSongPlayer/"+song+".wav");

            AudioInputStream audio=AudioSystem.getAudioInputStream(file);

            Clip clip=AudioSystem.getClip();
            clip.open(audio);

            String response="";

            while(!response.equals("Q")){
                System.out.println("P=play:S=stop:R=reset:Q=quit");
                System.out.println("Enter your choice");
                response=scan.next();
                response=response.toUpperCase();
                switch(response){
                    case "P":
                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break;
                    case "Q":
                        clip.close();
                        break;
                    default:
                        System.out.println("Not a valid response.");
                }
                System.out.println("Bye!");
            }

            scan.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
