package HarrysSalon;

abstract class TypeOfCuts {
    protected int price;
    protected String type;

    public TypeOfCuts(int price, String type) {
        this.price = price;
        this.type = type;
    }

    // setters
    public void setPrice(int price) {this.price = price;}
    public void setType(String type) {this.type = type;}

    // getters
    public int getPrice() {return price;}
    public String getType() {return type;}

    @Override
    public String toString() {
        return "price=" + price + ", type=" + type;
    }
}