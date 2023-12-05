package Assignment;
public class Phone {
   private int ID;
   private String Name;
   private double Price;
   private int Amount;
   private int Year;
   
   public Phone(){      
   }
    public Phone(int ID, String Name, double Price, int Amount, int Year) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Amount = Amount;
        this.Year = Year;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }  
}
