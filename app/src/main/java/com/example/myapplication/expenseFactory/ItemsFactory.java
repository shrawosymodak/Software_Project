package com.example.myapplication.expenseFactory;

public class ItemsFactory {
    public Items getItems(String item)
    {
        if(item == null)
        {
            return null;
        }
        if(item.equalsIgnoreCase("BILLS"))
        {
            return new Bills();
        }
        else if(item.equalsIgnoreCase("SHOPPING"))
        {
            return new Shopping();
        }
        else if(item.equalsIgnoreCase("FOOD"))
        {
            return new Foods();
        }
        else if(item.equalsIgnoreCase("GROCERIES"))
        {
            return new Groceries();
        }
        else if(item.equalsIgnoreCase("Miscellaneous"))
        {
            return new Miscellaneous();
        }
        else if(item.equalsIgnoreCase("Transport"))
        {
            return new Transport();
        }
        return null;

    }
}
