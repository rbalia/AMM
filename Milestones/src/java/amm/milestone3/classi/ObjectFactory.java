package amm.milestone3.classi;

import java.util.ArrayList;
/**
 *
 * @author Riccardo Balia 65106
 */
public class ObjectFactory{
    
    private static ObjectFactory singleton;

    public static ObjectFactory getInstance() {
        if (singleton == null) {
            singleton = new ObjectFactory();
        }
        return singleton;
    }
    
    //Lista Oggetti
    private ArrayList<ObjectSale> objectList = new ArrayList<>();
    /* Costruttore */
    public ObjectFactory()
    {  
        ObjectSale object1 = new ObjectSale();
        object1.setName("O-Mg");
        object1.setImageURL("./Immagini/Accendino1.jpg");
        object1.setPrice(18.70);
        object1.setAvailability(14);
        object1.setCategory("lighters");
        object1.setID(10);
        objectList.add(object1);
        
        ObjectSale object2 = new ObjectSale();
        object2.setName("Poker");
        object2.setImageURL("./Immagini/Accendino2.jpg");
        object2.setPrice(17.90);
        object2.setAvailability(21);
        object2.setCategory("lighters");
        object2.setID(11);
        objectList.add(object2);
        
        ObjectSale object3 = new ObjectSale();
        object3.setName("Spectrum");
        object3.setImageURL("./Immagini/Accendino3.jpg");
        object3.setPrice(21.50);
        object3.setAvailability(9);
        object3.setCategory("lighters");
        object3.setID(12);
        objectList.add(object3);
        
        ObjectSale object4 = new ObjectSale();
        object4.setName("Pietrine");
        object4.setImageURL("./Immagini/Ricambi1.jpg");
        object4.setPrice(0.80);
        object4.setAvailability(56);
        object4.setCategory("accessories");
        object4.setID(13);
        objectList.add(object4);
        
        ObjectSale object5 = new ObjectSale();
        object5.setName("Stoppino");
        object5.setImageURL("./Immagini/Ricambi2.jpg");
        object5.setPrice(0.40);
        object5.setAvailability(47);
        object5.setCategory("accessories");
        object5.setID(14);
        objectList.add(object5);
        
        ObjectSale object6 = new ObjectSale();
        object6.setName("Candle");
        object6.setImageURL("./Immagini/Accessori1.jpg");
        object6.setPrice(7.90);
        object6.setAvailability(19);
        object6.setCategory("accessories");
        object6.setID(15);
        objectList.add(object6);
    }
   
    
    

    public ArrayList<ObjectSale> getObjectList() 
    { 
        return objectList;
    }
    
    //Restituisco l'oggetto che corrispondono a un un id   
    public ObjectSale getObjectListByID(Integer targetID) 
    {
        if (objectList!=null){    
            for(ObjectSale f: objectList) {
                    if(f.ID.equals(targetID))
                        return f;           
            }
        }
        return null; //se non c'è corrispondenza
    }
    
    //Restituisco gli oggetti che corrispondono a una categoria
    public ArrayList<ObjectSale> getObjectListByCategory(String targetCategory) {
        
        ArrayList<ObjectSale> matchedObjects = new ArrayList<>();

        if (objectList!=null){
            for(ObjectSale f: objectList) {
                    if(f.category.equals(targetCategory))
                        matchedObjects.add(f);          
            }
        }
        else
            return null;
        
        return matchedObjects;
    }
}
