package amm.milestone3.classi;

/**
 *
 * @author Riccardo Balia 65106
 */
public class ObjectSale {

    public String name;
    public String imageURL;
    public String description;
    public Double price;
    public Integer availability;

    public String category;
    public Integer ID;
    
    /* Costruttori */
    public ObjectSale()
    {}
    
    public ObjectSale(String name,String imageURL, String description,Double price, Integer availability, String category,Integer ID)
    {
            this.name=name;
            this.imageURL=imageURL;
            this.description=description;
            this.price=price;
            this.availability=availability;
            this.category=category;
            this.ID=ID;
    }
    
    /* Metodi */
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public Integer getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }
    

}
