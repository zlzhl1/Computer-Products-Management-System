public class Tablet extends Computer {
    private double ScreenSize = 0;

    public Tablet() {
    }

    public Tablet(String category, String type, String ID, String brand, String CPU_Family, double screenSize, int price) {
        super(category, type, ID, brand, CPU_Family, price);
        ScreenSize = screenSize;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(int screenSize) {
        ScreenSize = screenSize;
    }
}
