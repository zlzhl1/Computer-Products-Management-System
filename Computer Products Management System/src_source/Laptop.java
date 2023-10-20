public class Laptop extends Computer {
    private int Memorysize = 0;
    private int SSD_capacity = 0;
    private double ScreenSize = 0;

    public Laptop() {
    }

    public Laptop(String category, String type, String ID, String brand, String CPU_Family, int memorysize, int SSD_capacity, double screenSize, int price) {
        super(category, type, ID, brand, CPU_Family, price);
        Memorysize = memorysize;
        this.SSD_capacity = SSD_capacity;
        ScreenSize = screenSize;
    }

    public int getMemorysize() {
        return Memorysize;
    }

    public void setMemorysize(int memorysize) {
        Memorysize = memorysize;
    }

    public int getSSD_capacity() {
        return SSD_capacity;
    }

    public void setSSD_capacity(int SSD_capacity) {
        this.SSD_capacity = SSD_capacity;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(int screenSize) {
        ScreenSize = screenSize;
    }

}
