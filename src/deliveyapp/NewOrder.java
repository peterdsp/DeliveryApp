package deliveyapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewOrder {
    private String idApp;
    private String idOrder;
    private String DateOrder;
    private String NameClient;
    private String NameItem;
    private String CountUnits;
    private String PriceNetItem;
    private String PercentageTax;
    public NewOrder(){
    }
    public NewOrder(String idApp, String idOrder, String DateOrder, String NameClient, 
                    String NameItem, String CountUnits, String PriceNetItem, String PercentageTax) {
        this.idApp=idApp;
        this.idOrder=idOrder;
        this.DateOrder=DateOrder;
        this.NameClient=NameClient;
        this.NameItem=NameItem;
        this.CountUnits=CountUnits;
        this.PriceNetItem=PriceNetItem;
        this.PercentageTax=PercentageTax;
    }

    public String getidApp() {
        return idApp; 
    }

    public void setidApp(String idApp) {
        this.idApp = idApp;
    }

    public String getidOrder() {
        return idOrder;
    }

    public void setidOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(String DateOrder) {
        this.DateOrder = DateOrder;
    }
    public String getNameClient() {
        return NameClient;
    }

    public void setNameClient(String NameClient) {
        this.NameClient = NameClient;
    }
    public String getNameItem() {
        return NameItem;
    }

    public void setNameItem(String NameItem) {
        this.NameItem = NameItem;
    }
    public String getCountUnits() {
        return CountUnits;
    }

    public void setCountUnits(String CountUnits) {
        this.CountUnits = CountUnits;
    }
    public String getPriceNetItem() {
        return PriceNetItem;
    }

    public void setPriceNetItem(String PriceNetItem) {
        this.PriceNetItem = PriceNetItem;
    }
    public String getPercentageTax() {
        return PercentageTax;
    }

    public void setPercentageTax(String PercentageTax) {
        this.PercentageTax = PercentageTax;
    }

    @Override
    public String toString() {
        return idOrder + "    " + DateOrder + "    " + NameClient+"    "+NameItem+"    "
                +CountUnits+"    "+PriceNetItem+"$"+"    "+PercentageTax+"%";
    }  
    public String SavetoString() {
        idApp="18390189";
        return idApp + ";" + idOrder + ";" + DateOrder + ";" + NameClient+";"+NameItem+";"
                +CountUnits+";"+PriceNetItem+";"+PercentageTax;
    } 
    
}