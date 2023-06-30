package interviewPractice;


	import java.util.*;

	public class RecentlyPlayedSongsStore {

	    private final int capacity;
	    private final Map<String, List<String>> songsByUser;

	    public RecentlyPlayedSongsStore(int capacity) {
	        this.capacity = capacity;
	        this.songsByUser = new HashMap<>();
	    }

	    public void addSong(String song, String user) {
	        List<String> songs = songsByUser.getOrDefault(user, new ArrayList<>());
	        songs.add(song);
	        if (songs.size() > capacity) {
	            songs.remove(0);
	        }
	        songsByUser.put(user, songs);
	    }

	    public List<String> getRecentlyPlayedSongs(String user) {
	        return songsByUser.getOrDefault(user, new ArrayList<>());
	    }

	    public static void main(String[] args) {
	        RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(3);
	        store.addSong("S1", "user1");
	        store.addSong("S2", "user1");
	        store.addSong("S3", "user1");
	        store.addSong("S4", "user1");

	        List<String> songs = store.getRecentlyPlayedSongs("user1");
	        System.out.println(songs); // should print [S2, S3, S4]

	        store.addSong("S5", "user1");

	        songs = store.getRecentlyPlayedSongs("user1");
	        System.out.println(songs); // should print [S3, S4, S5]
	    }
	}


