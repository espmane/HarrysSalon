package HarrysSalon;

abstract class TypeOfCuts {
     protected int price;
     protected String type;

     public TypeOfCuts (int price, String type){
         this.price = price;
         this.type= type;
     }

    public int getprice(){
        return price;
    }

    public String gettype(){
        return type;
    }



}
