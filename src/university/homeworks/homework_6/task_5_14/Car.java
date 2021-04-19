public class Car extends Toy{
    String brand;
    String model;
    String color;

    Car(String brand, String model, String color, String size, int price) {
        super(size, price);
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "* Car " +
                "\nBrand: " + brand +
                "\nModel: " + model +
                "\nColor: " + color +
                "\n" + super.toString();
    }
}
