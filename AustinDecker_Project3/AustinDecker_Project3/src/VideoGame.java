import java.io.Serializable;

public class VideoGame implements Serializable, Comparable<VideoGame>{
    int price;
    String name;

    public VideoGame(String name, int price){
        //TODO
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(VideoGame o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
