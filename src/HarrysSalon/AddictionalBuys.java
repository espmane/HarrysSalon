package HarrysSalon;

public enum AddictionalBuys {
    HAIR_WAX("Hair wax", 200),
    BRUSH("Brush", 300),
    SHAMPOO("Shampoo", 150);

    private final String label;
    private final int price;

    // Constructor til at sætte label + pris
    AddictionalBuys(String label, int price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return label + " (" + price + " kr)";
    }
}
