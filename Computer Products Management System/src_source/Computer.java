public abstract class Computer {
    private String category;
    private String type;
    private String ID;
    private String Brand;
    private String CPU_Family;
    private int Price;

    public Computer() {
    }

    public Computer(String category, String type, String ID, String brand, String CPU_Family, int price) {
        this.category = category;
        this.type = type;
        this.ID = ID;
        Brand = brand;
        this.CPU_Family = CPU_Family;
        Price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCPU_Family() {
        return CPU_Family;
    }

    public void setCPU_Family(String CPU_Family) {
        this.CPU_Family = CPU_Family;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
