package HarrysSalon.typeofcuts;

public abstract class TypeOfCuts {
    private final String type;
    private final int price;

    protected TypeOfCuts(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType(){
        return type;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return type + " - " + price;
    }
}
