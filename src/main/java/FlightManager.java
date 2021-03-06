public class FlightManager {

    private Flight flight;


    public FlightManager(Flight flight) {
        this.flight = flight;

    }

    public double calculateTotalBagWeightAllowance() {
        return this.flight.getPlaneType().getPlaneWeight()/2;
    }

    public double calculateBagAllowance() {
        return calculateTotalBagWeightAllowance()/this.flight.getPlaneType().getPlaneCapacity();
    }

    public double calculateTotalWeightOfBags() {
        return this.flight.countPassengers() * calculateBagAllowance();
    }

    public double calculateLeftWeight() {
        return calculateTotalBagWeightAllowance() - calculateTotalWeightOfBags();
    }



    public void bookPassengerOnFlight(Flight flight, Passenger passenger, int[] seats) {
        if (flight.countAvailableSeats() > 0){
            flight.addPassengers(passenger);
            passenger.setFlight(flight);
            flight.assignRandomSeatToPassenger(passenger, seats);
        }
    }


}
