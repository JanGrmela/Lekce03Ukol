
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

     public class Main {

            public static void main(String[] args) {

            // Hosté dle zadání
                GuestsOfHotel guestsOfHotel1 = new GuestsOfHotel("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
                GuestsOfHotel guestsOfHotel2 = new GuestsOfHotel("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));


            //Seznam hostů
                List<GuestsOfHotel> guestsOfHotels = new ArrayList<>();
                guestsOfHotels.add(guestsOfHotel1);
                guestsOfHotels.add(guestsOfHotel2);
                System.out.println("Seznam hostů:");
                for (GuestsOfHotel guestsOfHotel : guestsOfHotels) {
                    System.out.println(guestsOfHotel.getName() + " " + guestsOfHotel.getSurname() + " "+"(" + guestsOfHotel.getBirthDate() + ")");
                }
            
                Room room1 = new Room(1, 1, true, true, 1000);
                Room room2 = new Room(2, 1, true, true, 1000);
                Room room3 = new Room(3, 3, false, true, 2400);
            // Seznam pokojů
                List<Room> rooms = new ArrayList<>();
                rooms.add(room1);
                rooms.add(room2);
                rooms.add(room3);
                System.out.println("\n" + "Seznam pokojů:");
                for (Room room : rooms) {
                    System.out.println("Číslo pokoje :"+" "+room.getRoomNumber()+" "+"Počet lůžek:"+" "+room.getNumberOfBeds()+
                            " "+"Balkón:"+" "+room.isBalcony()+" "+"Výhled na moře:"+" "+room.isViewOfSea()+" "
                            +"\n" + "Cena za noc:"+" "+room.getPriceOfRoomForNight()+" "+"Kč" + "\n");
                }

            // Přidání rezervací:
                Reservation reservation1 = new Reservation(LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26),
                        false, rooms.get(0), List.of(guestsOfHotel1));
                Reservation reservation2 = new Reservation(LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 1),
                        false, rooms.get(2), List.of(guestsOfHotel1), List.of(guestsOfHotel2));

            // Seznam rezervací:
                List<Reservation> listReservationManager = new ArrayList<>();
                listReservationManager.add(reservation1);
                listReservationManager.add(reservation2);
                System.out.println("Seznam rezervací:");
                for (Reservation reservation : listReservationManager) {
                    System.out.println("Od: "+ reservation.getFirstDay() + "," +
                            " Do: " + reservation.getLastDay() + "," +
                            " Pokoj č.: " + reservation.getRoom().getRoomNumber() + "," +
                            " Počet hostů: " + reservation.getNumberOfGuests());
                }

                BookingManager bookingManager = new BookingManager();
                fillBookings(bookingManager);

                System.out.println("Prvních 8 rekreačních rezervací:");
                printFirst8RecreationalBookings(bookingManager.getBookings());

                System.out.println("Statistika hostů:");
                printGuestStatistics(bookingManager);

                System.out.println("První rezervace:");
                System.out.println("Délka první rezervace: " + reservation1.getBookingLength() + " nocí");
                System.out.println("Cena první rezervace: " + reservation1.getPrice() + ",-Kč");

                System.out.println("Celkový počet rezervací je: " + bookingManager.getBookings().size());

                System.out.println("Počet pracovních pobytů: " + bookingManager.getNumberOfWorkingBookings());
                System.out.println("Průměrný počet hostů na rezervaci: " + bookingManager.getAverageGuests());

            }
            // Další hosté dle zadání:
            public static void fillBookings (BookingManager bookingManager) {
                GuestsOfHotel guestsOfHotel3 = new GuestsOfHotel("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
                GuestsOfHotel guestsOfHotel4 = new GuestsOfHotel("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
                GuestsOfHotel guestsOfHotel5 = new GuestsOfHotel("Karolína", "Tmavá", LocalDate.of(1992, 7, 7));

                Room room2 = new Room(2, 1, true, true, 1000);
                Room room3 = new Room(3, 3, false, true, 2400);

                bookingManager.addBooking(new Reservation(LocalDate.of(2023,6,1), LocalDate.of(2023, 6, 7),
                        true, room3, List.of(guestsOfHotel3)));
                bookingManager.addBooking(new Reservation(LocalDate.of(2023,7,18), LocalDate.of(2023, 7, 21),
                        false, room2, List.of(guestsOfHotel4)));

                // Dvoudenní rezervace Karolína Tmavá:
                for (int i = 1; i <= 10; i++) {
                    LocalDate firstDay = LocalDate.of(2023, 8, i * 2 - 1);
                    LocalDate lastDay = firstDay.plusDays(1);
                    bookingManager.addBooking(new Reservation(firstDay, lastDay, false, room2, List.of(guestsOfHotel5)));
                }
                // Rezervace Karolína Tnavá na srpen
                bookingManager.addBooking(new Reservation(LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31),
                        false, room3, List.of(guestsOfHotel5)));
            }

            // Výpis všech rezervací ve formátu:
            private static void printBookings(List<Reservation> reservations) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                for (Reservation reservation : reservations) {
                    String fromDate = reservation.getFirstDay().format(formatter);
                    String toDate = reservation.getLastDay().format(formatter);
                    String mainGuestName = reservation.getGuests().getFirst().getName() + " " + reservation.getGuests().getFirst().getSurname();
                    String birthDate = reservation.getGuests().getFirst().getBirthDate().format(formatter);
                    int numberOfGuests = reservation.getGuests().size();
                    String viewOfSea = reservation.getRoom().isViewOfSea() ? "ano" : "ne";
                    int price = reservation.getPrice();

                    System.out.println(fromDate + " až " + toDate + ": " + mainGuestName + " (" + birthDate + ") [" + numberOfGuests + ", " +
                            "výhled na moře" + viewOfSea + "] za " + price + " Kč");
                }
            }

            // Výpis prvních 8 rekreačních rezervací:
            public static void printFirst8RecreationalBookings(List<Reservation> reservations) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                int count = 0;
                for (Reservation reservation : reservations) {
                    if (!reservation.getWorkingTypeOfVacation()) {
                        String fromDate = reservation.getFirstDay().format(formatter);
                        String toDate = reservation.getLastDay().format(formatter);
                        String mainGuestName = reservation.getGuests().getFirst().getName() + " " + reservation.getGuests().getFirst().getSurname();
                        String birthDate = reservation.getGuests().getFirst().getBirthDate().format(formatter);
                        int numberOfGuests = reservation.getGuests().size();
                        String viewOfSea = reservation.getRoom().isViewOfSea() ? "ano" : "ne";
                        int price = reservation.getPrice();

                        System.out.println(fromDate + " až " + toDate + ": " + mainGuestName + " (" + birthDate + ") [" + numberOfGuests + "," +
                                " výhled na moře " + viewOfSea + "] za " + price + " Kč");

                        count++;
                        if (count >= 8) {
                            break;
                        }
                    }
                }
            }

            // Celkový počet rezervací s jedním, dvěma a více hosty:
            private static void printGuestStatistics (BookingManager bookingManager) {
                int oneGuest = 0;
                int twoGuests = 0;
                int moreThanTwoGuests = 0;

                for (Reservation reservation : bookingManager.getBookings()) {
                    int guestCount = reservation.getNumberOfGuests();
                    if (guestCount == 1) {
                        oneGuest++;
                    } else if (guestCount == 2) {
                        twoGuests++;
                    } else {
                        moreThanTwoGuests++;
                    }
                }

                System.out.println("Celkový počet rezervací s jedním hostem: " + oneGuest);
                System.out.println("Celkový počet rezervací se dvěma hosty: " + twoGuests);
                System.out.println("Celkový počet rezervací s více než dvěma hosty: " + moreThanTwoGuests);
            }    ;
    }

