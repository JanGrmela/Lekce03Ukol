
import java.time.LocalDate;
import java.util.List;

    public class Reservation {

        private LocalDate firstDay;
        private LocalDate lastDay;
        private Boolean WorkingTypeOfVacation;
        private Room room;
        private List<GuestsOfHotel> guestsOfHotels;
        private List<GuestsOfHotel> otherGuestsOfHotels;

        public Reservation(LocalDate firstDay, LocalDate lastDay, Boolean WorkingTypeOfVacation, Room room, List<GuestsOfHotel> guestsOfHotels, List<GuestsOfHotel> otherGuestsOfHotels) {
            this.firstDay = firstDay;
            this.lastDay = lastDay;
            this.WorkingTypeOfVacation = WorkingTypeOfVacation;
            this.room = room;
            this.guestsOfHotels = guestsOfHotels;
            this.otherGuestsOfHotels = otherGuestsOfHotels;
        }

        public Reservation(LocalDate firstDay, LocalDate lastDay, Boolean WorkingTypeOfVacation, Room room, List<GuestsOfHotel> guestsOfHotels) {
            this.firstDay = firstDay;
            this.lastDay = lastDay;
            this.WorkingTypeOfVacation = WorkingTypeOfVacation;
            this.room = room;
            this.guestsOfHotels = guestsOfHotels;
        }

        public LocalDate getFirstDay() {
            return firstDay;
        }

        public void setFirstDay(LocalDate firstDay) {
            this.firstDay = firstDay;
        }

        public LocalDate getLastDay() {
            return lastDay;
        }

        public void setLastDay(LocalDate lastDay) {
            this.lastDay = lastDay;
        }

        public Boolean getWorkingTypeOfVacation() {
            return WorkingTypeOfVacation;
        }

        public void setWorkingTypeOfVacation(Boolean workingTypeOfVacation) {
            WorkingTypeOfVacation = workingTypeOfVacation;
        }

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public List<GuestsOfHotel> getGuests() {
            return guestsOfHotels;
        }

        public void setGuests(List<GuestsOfHotel> guestsOfHotels) {
            this.guestsOfHotels = guestsOfHotels;
        }

        public List<GuestsOfHotel> getOtherGuests() {
            return otherGuestsOfHotels;
        }

        public void setOtherGuests(List<GuestsOfHotel> otherGuestsOfHotels) {
            this.otherGuestsOfHotels = otherGuestsOfHotels;
        }

        public int getNumberOfGuests() { // Počet hostů
            return guestsOfHotels.size();
        }

        // Počet nocí pro danou rezervaci:
        public int getBookingLength() {
            return (int) java.time.temporal.ChronoUnit.DAYS.between(firstDay, lastDay);
        }

        // Cena podle počtu nocí pro danou rezervaci:
        public int getPrice() {
            return room.getPriceOfRoomForNight()*getBookingLength();
        }

        @Override
        public String toString() {
            return "Booking{" +
                    "firstDay=" + firstDay +
                    ", lastDay=" + lastDay +
                    ", isWorkingTypeOfVacation=" + WorkingTypeOfVacation +
                    ", room=" + room +
                    ", guest=" + guestsOfHotels +
                    ", otherGuests=" + otherGuestsOfHotels +
                    '}';
        }

    }

