public class Level {
    private final int floor;
    private final ParkingSpot[] spots;

    public Level(int floor, int BusCap, int CarCap, int MotoCap){
        this.floor = floor;
        sopts = new ParkingSpot[BusCap+CarCap+MotoCap];
        for (int i=0; i<spots.length;i++){
            if (i<BusCap){
                spots[i] = new ParkingSpot(Type.BUS);
            }
            else if (i>=BusCap && i<BusCap + CarCap ){
                spots[i] = new ParkingSpot(Type.CAR);
            } else {
                spots[i] = new ParkingSpot(Type.MOTOR);
            }
        }
    }

    public boolean canPark(Vehicle v){
        for (ParkingSpot spot : spots){
            if (spot.canPark(v)){
                return true;
            }
        }
        return false;
    }

    public boolean goPark(Vehecle v){
        if (!canPark(v)){
            return false;
        }
        for (ParkingSpot spot: spots){
            if (spot.goPark(v)){
                return true;
            }
        }
        return false;
    }
    public int numOfAvailableSpot(Vehicle v){
        int count = 0;
        for (ParkingSpot spot: spots){
            if(spot.canPark(v)){
                count+=1;
            }
        }
        return count;
    }

}