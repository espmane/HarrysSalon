package HarrysSalon;

import HarrysSalon.typeofcuts.TypeOfCuts;

public class Appointment {
    private final String customerName;
    private final TypeOfCuts cut;
    private boolean paid;

    public Appointment(String customerName, TypeOfCuts cut) {
        this.customerName = customerName;
        this.cut = cut;
        this.paid = false;
    }

    public boolean isPaid(){
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public TypeOfCuts getCut() {
        return cut;
    }

    @Override
    public String toString() {
        return customerName + " (" + cut.getType() + " — " + cut.getPrice() + " kr)";
    }
}