package builder;

class HolidayPackages{
    private final String flight;
    private final String hotel;
    private final boolean airportPickup;
    private final boolean sightSeing;
    private final boolean insurance;
    
    public HolidayPackages(HolidayPackageBuilder builder){
        this.flight = builder.getFlight();
        this.hotel = builder.getHotel();
        this.airportPickup = builder.isAirportPickup();
        this.sightSeing = builder.isSightSeing();
        this.insurance = builder.isInsurance();
    }
    
    public void showDeails(){
        System.out.println("Package includes :");
        System.out.println("Flight : "+flight);
        System.out.println("Hotel : "+hotel);
        System.out.println("Airport pickup : "+airportPickup);
        System.out.println("Sight seing : "+sightSeing);
        System.out.println("Insurence : "+insurance);
    }
}

class HolidayPackageBuilder{
    private String flight;
    private String hotel;
    private boolean airportPickup;
    private boolean sightSeing;
    private boolean insurance;

    public String getFlight() {
        return flight;
    }

    public HolidayPackageBuilder setFlight(String flight) {
        this.flight = flight;
        return this;
    }

    public String getHotel() {
        return hotel;
    }

    public HolidayPackageBuilder setHotel(String hotel) {
        this.hotel = hotel;
        return this;
    }

    public boolean isAirportPickup() {
        return airportPickup;
    }

    public HolidayPackageBuilder setAirportPickup(boolean airportPickup) {
        this.airportPickup = airportPickup;
        return this;
    }

    public boolean isSightSeing() {
        return sightSeing;
    }

    public HolidayPackageBuilder setSightSeing(boolean sightSeing) {
        this.sightSeing = sightSeing;
        return this;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public HolidayPackageBuilder setInsurance(boolean insurance) {
        this.insurance = insurance;
        return this;
    }
    
    public HolidayPackages build(){
        return new HolidayPackages(this);
    }
    
    
}

public class Q1 {
    
    public static void main(String[] args) {
        
        HolidayPackages hpb = new HolidayPackageBuilder()
                .setFlight("Colombo to Canada")
                .setHotel("ABC")
                .setAirportPickup(true)
                .setSightSeing(true)
                .setInsurance(true)
                .build();
        
        hpb.showDeails();
    }
}
