package domainobject;

/**
 * Add product information
 * <br>Barcode<br>weight<br>distance
 */
public class Product {

    public Product(String barcode, double weight, double distance) {
        this.barcode = barcode;
        this.weight = weight;
        this.distance = distance;
    }

    /**
     * barcode
     */
    private String barcode;

    /**
     * weight
     */
    private double weight;
    /**
     * distance
     */
    private double distance;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}

