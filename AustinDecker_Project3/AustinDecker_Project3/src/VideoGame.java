import java.io.Serializable;

public class VideoGame implements Serializable, Comparable<VideoGame>{
    private int price;
    private String name;

    public VideoGame(String name, int price){
        //TODO
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
    
}
