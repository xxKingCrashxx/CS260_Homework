import java.io.Serializable;
import java.util.Objects;

/**
 * VideoGame class which holds the properties of video games.
 * @author Austin Decker
 * @version 1.0
 */
public class VideoGame implements Serializable, Comparable<VideoGame>{
    private double price;
    private String name;

    public VideoGame(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice() {return price;}

    public String getName() {return name;}

    public void setPrice(int price) {this.price = price;}

    public void setName(String name) {this.name = name;}

    /**
     * Compares two VideoGame Objects' hashcode.  If  obj1 > obj2 -> obj1.compareTo(obj2) returns 1.
     * if obj1 == obj2 -> obj1.compareTo(obj2) returns 0.  if obj1 < obj2 -> obj1.compareT(obj2) returns -1.
     * @param o
     * @return int
     */
    @Override
    public int compareTo(VideoGame o) {
        int videoGameIntValue = this.hashCode();
        int comparedVideoGameObjectIntValue = o.hashCode();

        if(videoGameIntValue == comparedVideoGameObjectIntValue)
            return 0;
        else if(videoGameIntValue > comparedVideoGameObjectIntValue)
            return 1;
        else
            return -1;
    }
    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(o == null)
            return false;
        if(!(o instanceof VideoGame))
            return false;
        
        VideoGame videoGame = (VideoGame)o;
        return Objects.equals(this.name, videoGame.name) && this.price == videoGame.price;
    }
    
    /** 
     * @return int
     */
    @Override
    public int hashCode(){
        return Objects.hash(price, name);
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        return string.append(name + ":" + "$" + price).toString();
    }
    
}
