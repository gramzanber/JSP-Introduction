package model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class Utility
{
    public static List<SelectItem> cityList() {return availableCities;}
    public static List<SelectItem> languageList() {return languagelist;}
    
    private final static List<SelectItem> availableCities;
    static
    {
        availableCities = new ArrayList<>();
        availableCities.add(new SelectItem("-- choose --"));
        availableCities.add(new SelectItem("Edmond"));
        availableCities.add(new SelectItem("Oklahoma City"));
        availableCities.add(new SelectItem("Moore"));
        availableCities.add(new SelectItem("Norman"));
        availableCities.add(new SelectItem("Honolulu"));
        availableCities.add(new SelectItem("Sapporo"));
        availableCities.add(new SelectItem("Kyoto"));
        availableCities.add(new SelectItem("Seoul"));
    }
    
    public final static List<SelectItem> languagelist;
    static
    {
        languagelist = new ArrayList<>();
        languagelist.add(new SelectItem("Java"));
        languagelist.add(new SelectItem("C++"));
        languagelist.add(new SelectItem("Pascal"));
        languagelist.add(new SelectItem("C#"));
        languagelist.add(new SelectItem("Cobol"));
        languagelist.add(new SelectItem("Ruby"));
    }
}
