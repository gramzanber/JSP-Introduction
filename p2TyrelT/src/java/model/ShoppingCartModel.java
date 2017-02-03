package model;

import java.util.ArrayList;

public class ShoppingCartModel 
{
    private final ArrayList<String> item;
    private final ArrayList<Integer> quantity;
    private final ArrayList<Double> price;
    
    public ShoppingCartModel()
    {
        item = new ArrayList<>();
        quantity = new ArrayList<>();
        price = new ArrayList<>();
    }

    public void addItem(String itemName, double itemPrice)
    {
        int amount = checkAmount(itemName);
        if(amount == 0)
        {
            item.add(itemName);
            price.add(itemPrice);
            quantity.add(1);
        }
        else
        {
            quantity.set(item.indexOf(itemName), checkAmount(itemName) + 1);
        }
    }
    
    private int checkAmount(String itemName)
    {
        if(item.indexOf(itemName) == -1){return 0;}
        else
        {
            return Integer.parseInt(quantity.get(item.indexOf(itemName)).toString());
        }
    }
    
    public boolean cartEmpty(){return item.isEmpty();}
    public int numberOfItems(){return item.size();}
    public String getItemName(int index){return (String)item.toArray()[index];}
    public String getItemQauntity(int index){return quantity.toArray()[index].toString();}
    public String getItemBaseAmount(int index){return price.toArray()[index].toString();}
    public String getItemTotal(int index)
    {
        return "$" + (Double.parseDouble(quantity.toArray()[index].toString()) * Double.parseDouble(price.toArray()[index].toString()));
    }
    public String getGrandTotal(int index)
    {
        double temp = 0;
        int counter = item.size();
        for(int i = 0; i < counter; i = i + 1){temp = temp + (Double.parseDouble(quantity.toArray()[i].toString()) * Double.parseDouble(price.toArray()[i].toString()));}
        return "$" + String.format("%,.2f", temp);
    }
}
