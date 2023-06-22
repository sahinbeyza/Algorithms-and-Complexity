/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beyza_nur_sahin_hw4;

/**
 *
 * @author Beyza
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Spotify {

    private Map<String, Set<String>> likedSongs;
    private Set<String> allSongs;

    public Spotify() {
        likedSongs = new HashMap<>();
        allSongs = new HashSet<>();
    }

    public void I(String name) { // kişi ekleme
        if (likedSongs.containsKey(name)) {
            System.out.println(name + " can not be created");
        } else {
            likedSongs.put(name, new HashSet<>());
        }
    }

    public void L(String name, String song) { // şarkı ekleme like şarkıları
        if (likedSongs.containsKey(name)) {
            likedSongs.get(name).add(song);
        } else {
            System.out.println(name + " is not created so Song cannot be liked");
        }
    }

    public void E(String name, String song) {
        if (likedSongs.containsKey(name) && likedSongs.get(name).contains(song)) {
            likedSongs.get(name).remove(song);
            //System.out.println(name + " doesn't like " + song);
        } else {
            System.out.println(name + " " + song + " can not be erased");
        }
    }

    public void D(String name) {
        if (likedSongs.containsKey(name)) {
            likedSongs.remove(name);
        } else {
            System.out.println(name + " is not in the list");
        }
    }

    public void P(String name) { // şarkı listeleme
        if (likedSongs.containsKey(name)) {
            Set<String> songs = likedSongs.get(name);
            if (songs.isEmpty()) {
                System.out.println(name + " has no songs");
            } else {
                System.out.println(name + " likes the following songs:");
                for (String song : songs) {
                    System.out.println(song);
                }
            }
        } else {
            System.out.println(name + " is not in the list");
        }
    }

    /*public void R(String name) {
		Set<String> likedSongsSet = likedSongs.get(name);
		if (likedSongsSet == null) {
			System.out.println(name + " is not in the list");
			return;
		}

		// create a set of all songs that the person has not liked
		Set<String> notLikedSongsSet = new HashSet<>(allSongs);
		notLikedSongsSet.removeAll(likedSongsSet);

		if (notLikedSongsSet.isEmpty()) {
			System.out.println("No songs to recommend to " + name);
			return;
		}

		// choose 5 random songs from the set of not-liked songs
		Random random = new Random();
		int count = 0;
		System.out.println("Recommendations for " + name + ":");
		while (count < 5 && !notLikedSongsSet.isEmpty()) {
			int index = random.nextInt(notLikedSongsSet.size());
			String song = (String) notLikedSongsSet.toArray()[index];
			System.out.println(song);
			notLikedSongsSet.remove(song);
			count++;
		}
	}
     */
    public void M(String name) {
        // Check if the user exists
        if (likedSongs.containsKey(name)) {
            // Get the user's liked songs
            Set<String> userLikedSongs = likedSongs.get(name);
            // Calculate the number of liked songs for each user
            Map<String, Integer> songCounts = new HashMap<>();
            for (Map.Entry<String, Set<String>> entry : likedSongs.entrySet()) {
                String user = entry.getKey();
                if (user.equals(name)) {
                    continue;
                }
                Set<String> songs = entry.getValue();
                // Calculate the number of common songs between the user and the current user
                int count = 0;
                for (String song : songs) {
                    if (userLikedSongs.contains(song)) {
                        count++;
                    }
                }
                songCounts.put(user, count);
            }
            // Print the matching results
            System.out.println("Possible friends of " + name + ":");
            for (Map.Entry<String, Integer> entry : songCounts.entrySet()) {
                String user = entry.getKey();
                int count = entry.getValue();
                if (count > 0) {
                    System.out.printf("%s %d%% match (%d songs out of %d)\n", user, 100 * count / userLikedSongs.size(),
                            count, userLikedSongs.size());
                }
            }
        } else {
            System.out.println(name + " is not in the list");
        }
    }

    public void O(String input) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;
        String[] lines = null;
        try {
            while ((line = reader.readLine()) != null) {
                lines = line.split(" ", 3);
                // System.out.println(line);
                for (String line1 : lines) {
                    // System.out.println(line1);
                    if (lines.length == 2 && line1.startsWith("I")) {
                        I(lines[1]);
                        // System.out.println(line1 + lines.length);
                        // break;
                    } else if (lines.length == 2 && line1.startsWith("P")) {

                        P(lines[1]);

                    } //	else if (lines.length == 2 && line1.startsWith("R")) {
                    //	R(lines[1]);
                    //	}
                    else if (lines.length == 2 && line1.startsWith("M")) {

                        M(lines[1]);
                    } else if (lines.length == 3 && line1.startsWith("L")) {

                        L(lines[1], lines[2]);

                    } else if (lines.length == 3 && line1.startsWith("E")) {

                        E(lines[1], lines[2]);

                    } else if (lines.length == 1 && line1.startsWith("X")) {

                        return;

                    }

                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
