
    public class Room {
        private int roomNumber;
        private int numberOfBeds;
        private boolean Balcony;
        private boolean ViewOfSea;
        private int priceOfRoomForNight;

        public Room(int roomNumber, int numberOfBeds, boolean Balcony, boolean ViewOfSea, int priceOfRoomForNight) {
            this.roomNumber = roomNumber;
            this.numberOfBeds = numberOfBeds;
            this.Balcony = Balcony;
            this.ViewOfSea = ViewOfSea;
            this.priceOfRoomForNight = priceOfRoomForNight;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public int getNumberOfBeds() {
            return numberOfBeds;
        }

        public void setNumberOfBeds(int numberOfBeds) {
            this.numberOfBeds = numberOfBeds;
        }

        public boolean isBalcony() {
            return Balcony;
        }

        public void setBalcony(boolean balcony) {
            Balcony = balcony;
        }

        public boolean isViewOfSea() {
            return ViewOfSea;
        }

        public void setViewOfSea(boolean viewOfSea) {
            ViewOfSea = viewOfSea;
        }

        public int getPriceOfRoomForNight() {
            return priceOfRoomForNight;
        }

        public void setPriceOfRoomForNight(int priceOfRoomForNight) {
            this.priceOfRoomForNight = priceOfRoomForNight;
        }
    }

