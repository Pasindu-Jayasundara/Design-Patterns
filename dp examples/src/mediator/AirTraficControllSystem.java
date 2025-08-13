package mediator;

interface ATCTower{
    void requestTakeOff(Plane airplane);
    void requestLanding(Plane airplane);
}

class Controller implements ATCTower{

    @Override
    public void requestTakeOff(Plane airplane) {
        airplane.notifyATC("Requesting to Takeoff");
    }

    @Override
    public void requestLanding(Plane airplane) {
        airplane.notifyATC("Requesting to Land");
    }
}

// college interface
interface Plane{
    void takeOff();
    void land();
    void notifyATC(String message);
}

// concrete college
class PrivateJet implements Plane{

    private ATCTower mediator;
    
    public PrivateJet(ATCTower mediator){
        this.mediator = mediator;
    }
    
    @Override
    public void takeOff() {
        mediator.requestTakeOff(this);
    }

    @Override
    public void land() {
        mediator.requestLanding(this); 
    }

    @Override
    public void notifyATC(String message) {
        System.out.println("Private Jet : "+ message);
    }
}

public class AirTraficControllSystem {
    public static void main(String[] args) {
        
        ATCTower tower = new Controller();
        
        Plane plane1 = new PrivateJet(tower);
        Plane plane2 = new PrivateJet(tower);
        Plane plane3 = new PrivateJet(tower);
        
        plane1.land();
        plane2.takeOff();
        plane3.notifyATC("Plane 3 taxiing"); 
    }
}
