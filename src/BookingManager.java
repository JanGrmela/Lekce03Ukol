
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

    public class BookingManager {

        private List<Reservation> listOfReservations = new ArrayList<>();

        public BookingManager(List<Reservation> listOfReservations) {
            this.listOfReservations.addAll(listOfReservations);
        }

        public BookingManager() {}

        // Metody přidané z úkolu:
        public List<Reservation> getListOfBookings() {
            return new ArrayList<>(listOfReservations); // kopie seznamu rezervací
        }

        public void setListOfBookings(List<Reservation> listOfReservations) {
            this.listOfReservations = listOfReservations;
        }
        // Vložení rezervace do seznamu
        public void addBooking(Reservation newReservation) {
            listOfReservations.add(newReservation);
        }
        // Získání rezervace se zadaným indexem ze seznamu
        public Reservation getBooking(int index) {
            return listOfReservations.get(index);
        }
        // Získání seznamu rezervací
        public void addList(List<Reservation> list) {
            listOfReservations.addAll(list);
        }

        public List<Reservation> getBookings() {
            return new ArrayList<>(listOfReservations);
        }
        // Vymazání seznamu rezervací
        public void clearBookings() {
            listOfReservations.clear();
        }

        // Počet rezervací pro pracovní pobyty:
        public int getNumberOfWorkingBookings() {
            int numberOfWorkingBookings = 0;
            for (Reservation reservation : listOfReservations) {
                if (!reservation.getWorkingTypeOfVacation()) {
                    numberOfWorkingBookings++;
                }
            }
            return numberOfWorkingBookings;
        }
        // Průměrný počet hostů na rezervaci:

        public BigDecimal getAverageGuests() {
            BigDecimal averageGuests = BigDecimal.valueOf(0);
            BigDecimal sumOfGuests = BigDecimal.valueOf(0);
            for (Reservation reservation : listOfReservations) {
                sumOfGuests = sumOfGuests.add(BigDecimal.valueOf(reservation.getNumberOfGuests()));
            }
            if (listOfReservations.size() > 0) {
                averageGuests = sumOfGuests.divide(BigDecimal.valueOf(listOfReservations.size()));
            }
            return averageGuests;
        }
    }

