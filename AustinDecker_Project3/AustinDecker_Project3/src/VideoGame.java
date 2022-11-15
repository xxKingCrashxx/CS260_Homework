import java.io.Serializable;
import java.util.Objects;

public class VideoGame implements Serializable, Comparable<VideoGame>{
    private int price;
    private String name;

    public VideoGame(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {return price;}

    public String getName() {return name;}

    public void setPrice(int price) {this.price = price;}

    public void setName(String name) {this.name = name;}

    @Override
    public int compareTo(VideoGame o) {
        if(this.price == o.price)
            return 0;
        else if(this.price > o.price)
            return 1;
        else
            return -1;
    }

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
    @Override
    public int hashCode(){
        return Objects.hash(price, name);
    }
    
}
