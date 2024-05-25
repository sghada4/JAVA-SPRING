import java.util.HashMap;
import java.util.Set;

public class Songs {

  public void getMusic() {
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("title1", "lyrics1");
    trackList.put("title2", "lyrics2");
    trackList.put("title3", "lyrics3");
    trackList.put("title4", "lyrics4");
    Set<String> keys = trackList.keySet();
    for (String key : keys) {
      System.out.println(key+": "+trackList.get(key));
    }
    System.out.println("--------------------------------");
    trackList.remove("title1");
    for (String key : keys) {
      System.out.println(key+": "+trackList.get(key));
    }
  }
}
