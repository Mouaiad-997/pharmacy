
package pharmacy;



public class Drug {
        private int id;
        private int price; 

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    private String Name;
    private String TheManufactureCompany;
    private String TypeOfTreatment;
    private String TheDateOfPurchase;
       private String ExpirationDate;
    public Drug()
    {
       super(); 
    }
        public Drug(int id, String Name, String TheManufactureCompany,String TypeOfTreatment,String TheDateOfPurchase,String ExpirationDate ) {
         super();
        this.id = id;
        this.Name = Name;
        this.TheManufactureCompany = TheManufactureCompany;
        this.TypeOfTreatment = TypeOfTreatment;
        this.TheDateOfPurchase = TheDateOfPurchase;
        this.ExpirationDate = ExpirationDate;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTheManufactureCompany() {
        return TheManufactureCompany;
    }

    public void setTheManufactureCompany(String TheManufactureCompany) {
        this.TheManufactureCompany = TheManufactureCompany;
    }

    public String getTypeOfTreatment() {
        return TypeOfTreatment;
    }

    public void setTypeOfTreatment(String TypeOfTreatment) {
        this.TypeOfTreatment = TypeOfTreatment;
    }

    public String getTheDateOfPurchase() {
        return TheDateOfPurchase;
    }

    public void setTheDateOfPurchase(String TheDateOfPurchase) {
        this.TheDateOfPurchase = TheDateOfPurchase;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    
    
}
