package HarrysSalon;

public class HairColoring extends TypeOfCuts{
    private String Color;

    public HairColoring (int price, String type, String Color) {
        super(price, type);
        this.Color = Color;
    }

    public String getColor(){return Color;}


}
