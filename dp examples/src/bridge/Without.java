package bridge;

class TvRemote{
    
    public void on(){
        System.out.println("Tv on");
    }
    
    public void off(){
        System.out.println("Tv off");
    }
}

class MusicPlayerRemote{
    
    public void on(){
        System.out.println("Music player on");
    }
    
    public void off(){
        System.out.println("Music player off");
    }
}

public class Without {
    
    public static void main(String[] args) {
        
        TvRemote tr = new TvRemote();
        tr.on();
        tr.off();
        
        MusicPlayerRemote mp = new MusicPlayerRemote();
        mp.on();
        mp.off();
            
    }
}
