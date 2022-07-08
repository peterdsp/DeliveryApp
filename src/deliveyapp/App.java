
package deliveyapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class App extends JFrame{
    private JMenu fileMenu, helpMenu;
    private JMenuBar menuBar;
    private JMenuItem newItem, openItem, saveItem, saveAsItem, statItem, aboutItem, exitItem;
    public ArrayList<NewOrder> usersList;
    public TextArea delArea;
    private JLabel path, pathArea1, pathArea2;
    JFileChooser savefile, openfile;
    JButton submitB=new JButton("Confirm Delivery"),clear=new JButton("        Clear Form         ");
    JTextField orderIDTF, orderDateTF, clientNameTF, itemNameTF, unitsCountTF, netItemPriceTF, taxPercentageTF;
    JTextField totalOrdersTF ,netCostTF, grCostTF, expOrderTF, chOrderTF;
    private JButton itemNew, itemOpen, itemSave, itemSaveAs, itemStat, itemAbout, itemExit;
    private JPanel optionsWithBtns, pathMessage;
    public App(){
        super();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        menuBar = new JMenuBar();
        delArea = new TextArea(20,70);
        usersList = new ArrayList();
        path=new JLabel();
        pathArea1=new JLabel();
        pathArea2=new JLabel();
        savefile = new JFileChooser();
        openfile = new JFileChooser();
        orderIDTF = new JTextField(25);
        orderDateTF= new JTextField(25);
        clientNameTF=new JTextField(25);
        itemNameTF=new JTextField(25);
        unitsCountTF=new JTextField(25);
        netItemPriceTF=new JTextField(25);
        taxPercentageTF=new JTextField(25);
        totalOrdersTF = new JTextField(25);
        netCostTF= new JTextField(25);
        grCostTF=new JTextField(25);
        expOrderTF=new JTextField(25);
        chOrderTF=new JTextField(25);
        itemNew=new JButton("New order");
        itemOpen=new JButton("Open order");
        itemSave=new JButton("Save");
        itemSaveAs=new JButton("Save As");
        itemStat=new JButton("Statistics");
        itemAbout=new JButton("About");
        itemExit=new JButton("Exit");
        optionsWithBtns=new JPanel();
        pathMessage=new JPanel();
    };
    public void MainApp(){
        this.setLayout(new GridLayout(3,1));
            fileMenu.setMnemonic('F');
            helpMenu.setMnemonic('H');
            
            newItem = fileMenu.add("New order"); 
            newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
            newItem.addActionListener(new newItemListener());
            
            openItem = fileMenu.add("Open order");        
            openItem.addActionListener(new openItemListener());
            openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
            
            fileMenu.addSeparator();
            
            saveItem = fileMenu.add("Save"); 
            saveItem.addActionListener(new saveAsItemListener());
            saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK)); 
            
            saveAsItem = fileMenu.add("Save As");
            saveAsItem.addActionListener(new saveAsItemListener());
            saveAsItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));
            
            fileMenu.addSeparator();
            
            statItem=fileMenu.add("Statistics");
            statItem.addActionListener(new StatListener());
            statItem.setAccelerator(KeyStroke.getKeyStroke('T', Event.CTRL_MASK));
            
            aboutItem = helpMenu.add("About"); 
            aboutItem.addActionListener(new aboutItemListener());
            aboutItem.setAccelerator(KeyStroke.getKeyStroke('I', Event.CTRL_MASK));
            
            fileMenu.addSeparator();
            
            exitItem = fileMenu.add("Exit");
            exitItem.addActionListener(new exitItemListener());
            exitItem.setAccelerator(KeyStroke.getKeyStroke('Q', Event.CTRL_MASK));  
            
            menuBar.add(fileMenu);
            menuBar.add(helpMenu);
            
        this.add(menuBar);
        
            setJMenuBar(menuBar);   
            pathMessage.add(pathArea1);
            pathMessage.add(pathArea2);
            
        this.add(pathMessage);
        
            delArea.setEditable(false);
        this.add(delArea);
        
            itemNew.addActionListener(new newItemListener());
            itemOpen.addActionListener(new openItemListener());
            itemSave.addActionListener(new saveAsItemListener());
            itemSaveAs.addActionListener(new saveAsItemListener());
            itemStat.addActionListener(new StatListener());
            itemAbout.addActionListener(new aboutItemListener());
            itemExit.addActionListener(new exitItemListener());
            
                optionsWithBtns.add(itemNew);
                optionsWithBtns.add(itemOpen);
                optionsWithBtns.add(itemSave);
                optionsWithBtns.add(itemSaveAs);
                optionsWithBtns.add(itemStat);
                optionsWithBtns.add(itemAbout);
                optionsWithBtns.add(itemExit);
                
        this.add(optionsWithBtns);
        this.setSize(576, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the application ?",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
    }
    
    
    public class newItemListener implements ActionListener{
        public void actionPerformed(ActionEvent nN){
            String cmes = nN.getActionCommand();
            if (cmes=="New order"){
                JFrame NewO = new JFrame();
                NewO.setLayout(new FlowLayout(FlowLayout.LEFT));
                
                JLabel orderID = new JLabel("Order ID\t");
                JLabel orderDate= new JLabel("Order Date\t");
                JLabel clientName=new JLabel("Client Name\t");
                JLabel itemName=new JLabel("Item Name\t");
                JLabel unitsCount=new JLabel("Units Count\t");
                JLabel netItemPrice=new JLabel("Net Item Price\t");
                JLabel taxPercentage=new JLabel("Tax Percentage\t");
                JLabel em=new JLabel("                                                           ");
                
                NewO.add(submitB);
                
                NewO.add(orderID);
                NewO.add(orderIDTF);
                
                NewO.add(orderDate);
                NewO.add(orderDateTF);
                
                NewO.add(clientName);
                NewO.add(clientNameTF);
                
                NewO.add(itemName);
                NewO.add(itemNameTF);
                
                NewO.add(unitsCount);
                NewO.add(unitsCountTF);
                
                NewO.add(netItemPrice);
                NewO.add(netItemPriceTF);
                
                NewO.add(taxPercentage);
                NewO.add(taxPercentageTF);
                
                NewO.add(em);
                NewO.add(submitB);
                submitB.addActionListener(new newOrderListener());
                
                NewO.add(clear);
                clear.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        orderIDTF.setText("");
                        orderDateTF.setText("");
                        clientNameTF.setText("");
                        itemNameTF.setText("");
                        unitsCountTF.setText("");
                        netItemPriceTF.setText("");
                        taxPercentageTF.setText("");
                    }
                });
                
                NewO.setResizable(false);
                NewO.setSize(295, 465);
                NewO.setTitle("New Order");
                NewO.setVisible(true);
                NewO.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
            }
        }
    }
    
    
    public class newOrderListener implements ActionListener{
        public void actionPerformed(ActionEvent nOL) {
                String orderIDTX=orderIDTF.getText();
                String orderDateTX=orderDateTF.getText();
                String clientNameTX=clientNameTF.getText();
                String itemNameTX=itemNameTF.getText();
                String unitsCountTX=unitsCountTF.getText();
                String netItemPriceTX=netItemPriceTF.getText();
                String taxPercentageTX=taxPercentageTF.getText();
                    NewOrder user = new NewOrder();
                if (!orderIDTX.isEmpty() & !orderDateTX.isEmpty() & !clientNameTX.isEmpty() & !itemNameTX.isEmpty() & !unitsCountTX.isEmpty() & !netItemPriceTX.isEmpty() & !taxPercentageTX.isEmpty()){ 
                    int flag=0, flag1=0, flag2=0;
                    try { 
                        Integer.parseInt(unitsCountTX);
                    }  
                    catch (NumberFormatException e)  
                    { 
                        JOptionPane.showMessageDialog(null, "Please fill the 'Units Count' textfield with an integer!", 
                                "Failure", JOptionPane.ERROR_MESSAGE);
                        flag=1;
                    } 
                    try { 
                        Double.parseDouble(netItemPriceTX);     
                    }  
                    catch (NumberFormatException e)  
                    { 
                        JOptionPane.showMessageDialog(null, "Please fill the 'Net Item Price' textfield with a double or an integer!",
                                "Failure", JOptionPane.ERROR_MESSAGE);
                        flag1=1;
                    } 
                    try { 
                        Double.parseDouble(taxPercentageTX);
                    }  
                    catch (NumberFormatException e)  
                    { 
                        JOptionPane.showMessageDialog(null, "Please fill the 'Tax Percentage' textfield with a double or an integer!",
                                "Failure", JOptionPane.ERROR_MESSAGE);
                        flag2=1;
                    } 
                    if (flag==0 & flag1==0 & flag2==0){
                        user.setidOrder(orderIDTX);
                        user.setDateOrder(orderDateTX);
                        user.setNameClient(clientNameTX);
                        user.setNameItem(itemNameTX);
                        user.setCountUnits(unitsCountTX);
                        user.setPriceNetItem(netItemPriceTX);
                        user.setPercentageTax(taxPercentageTX);
                        usersList.add(user);
                        delArea.append(user.toString());
                        delArea.append("\n");
                    }
                } 
                else{
                    JOptionPane.showMessageDialog(null, "Please fill all the textfields to complete the order!", "Failure", JOptionPane.ERROR_MESSAGE);
                }
        }
    }
    
    
    private class aboutItemListener implements ActionListener{
        public void actionPerformed(ActionEvent nA){
            About nOrder=new About();
            nOrder.Info();
        }
    }
    
    
    private class exitItemListener implements ActionListener{
        public void actionPerformed(ActionEvent eX){
            int choose = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the application ?",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
            if (choose == JOptionPane.YES_OPTION)
                    System.exit(0);
        }
    }
    
            
    private class openItemListener implements ActionListener{
        public void actionPerformed(ActionEvent oI){
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(openItem);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = fc.getSelectedFile().getPath();
                if (fileName != null && !fileName.isEmpty()) {
                    pathArea1.setText("Path of the file you opened:");
                    pathArea2.setText(fileName);
                    loadFromFile(fileName);
                }
            }
        }
    }
    
    
    private class saveAsItemListener implements ActionListener{
        public void actionPerformed(ActionEvent sA){
                if (usersList.isEmpty()) {
                    JOptionPane.showMessageDialog(saveAsItem ,
                            "Nothing to save",
                            "File access error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(saveAsItem );
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String fileName = fc.getSelectedFile().getPath();
                    if (fileName != null && !fileName.isEmpty())
                        saveUsersList(fileName);
                }
        }   
    }
    
    
    public class StatListener implements ActionListener{
        public void actionPerformed(ActionEvent nN){
            JFrame Stat = new JFrame();
            Stat.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            JLabel totalOrders = new JLabel("Total number of orders\t");
            JLabel netCost= new JLabel("Total net cost of orders\t");
            JLabel grCost=new JLabel("Total gross cost of orders\t");
            JLabel expOrder=new JLabel("The code ID of the most expensive order(gross cost)\t");
            JLabel chOrder=new JLabel("The code ID of the most cheap order(gross cost)\t");
            
            Stat.add(totalOrders);
            Stat.add(totalOrdersTF);
            Stat.add(netCost);
            Stat.add(netCostTF);
            Stat.add(grCost);
            Stat.add(grCostTF);
            Stat.add(expOrder);
            Stat.add(expOrderTF);
            Stat.add(chOrder);
            Stat.add(chOrderTF);
            
            totalOrdersTF.setEditable(false);
            netCostTF.setEditable(false);
            grCostTF.setEditable(false);
            expOrderTF.setEditable(false);
            chOrderTF.setEditable(false);
            
            /*  1.Συνολικός αριθμός των παραγγελιών
                2.συνολικό κόστος παραγγελιών (καθαρό και μικτό) 
                3.κωδικός της ακριβότερης παραγγελίας (όσον αφορά τη μικτή τιμή)
                4.κωδικός της φθηνότερης παραγγελίας (όσον αφορά τη μικτή τιμή)*/
            
            String content=delArea.getText(),line,ordeRID = null,orderDATE = null,clientNAME = null,itemNAME = null,unitsCOUNT = null,
                    netItemPRICE = null,taxPercenTAGE = null;
            String orderIDArr[]= new String [10000];
            int unitsCountArr[]=new int [1000], c=0, finalSumOrder=0;
            double netItemPriceArr[]=new double [1000], taxPercentageArr[]=new double [1000], netSumPrice=0, grossSumPrice=0
                    , priceOrderArr[]=new double [1000];
            
                Scanner scFile=new Scanner(content);
                while(scFile.hasNext()){
                    line=scFile.nextLine();
                    Scanner scLine=new Scanner(line);
                    ordeRID=scLine.next();
                    orderIDArr[c]=ordeRID;
                    orderDATE=scLine.next();
                    clientNAME=scLine.next();
                    itemNAME=scLine.next();
                    unitsCOUNT=scLine.next();
                    unitsCountArr[c]=Integer.parseInt(unitsCOUNT);
                    netItemPRICE=scLine.next();
                    netItemPRICE=netItemPRICE.substring(0, netItemPRICE.length()-1);
                    netItemPriceArr[c]=Double.parseDouble(netItemPRICE);
                    taxPercenTAGE=scLine.next();
                    taxPercenTAGE=taxPercenTAGE.substring(0, taxPercenTAGE.length()-1);
                    taxPercentageArr[c]=Double.parseDouble(taxPercenTAGE);
                    scLine.close();  
                    c++;
                }
                
                scFile.close();
                finalSumOrder=c;
                totalOrdersTF.setText(Integer.toString(finalSumOrder));
                
            for (c=0;c<finalSumOrder;c++){
                netSumPrice=netSumPrice+netItemPriceArr[c]*unitsCountArr[c];
                grossSumPrice=grossSumPrice+(((netItemPriceArr[c]*unitsCountArr[c])*taxPercentageArr[c])/100)+(netItemPriceArr[c]*unitsCountArr[c]);
                priceOrderArr[c]=(((netItemPriceArr[c]*unitsCountArr[c])*taxPercentageArr[c])/100)+(netItemPriceArr[c]*unitsCountArr[c]);
            }
            netCostTF.setText(String.format("%.2f",netSumPrice)+"$");
            grCostTF.setText(String.format("%.2f",grossSumPrice)+"$");
            expOrderTF.setText(orderIDArr[getMax(priceOrderArr, finalSumOrder)]);
            chOrderTF.setText(orderIDArr[getMin(priceOrderArr, finalSumOrder)]);
            
            Stat.setResizable(false);
            Stat.setSize(310, 280);
            Stat.setTitle("Statistics");
            Stat.setVisible(true);
            Stat.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }
    
    
    public static int getMax(double[] inputArray,int size){
        int pos = 0;
        double maxValue = inputArray[0]; 
        for(int i=1;i < size;i++){ 
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
                pos=i;
            }
        } 
        return pos; 
    }
 
 
    public static int getMin(double[] inputArray,int size){ 
        int pos = 0;
        double minValue = inputArray[0]; 
        for(int i=0;i<size;i++){ 
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
                pos=i;
            }
        } 
        return pos; 
    } 
    
    
    private void saveUsersList(String fileName) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(fileName, true));
            for (NewOrder user : usersList) {
                file.write(user.SavetoString());
                file.newLine();
            }
            file.close();
            JOptionPane.showMessageDialog(saveAsItem ,
                    usersList.size() + " records saved to " + fileName,
                    "Save completed",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException ex) {
        }
    }
    
    
    private void loadFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            String[] textF;
            NewOrder user;
            while (reader.ready()) {

                line = reader.readLine();
                textF = line.split(";");

                if (textF.length == 8) {
                    user = new NewOrder(textF[0], textF[1], textF[2], textF[3], textF[4], textF[5], textF[6], textF[7]);
                    usersList.add(user);
                }
                
            }
            reader.close();
            showList();
        } catch (FileNotFoundException ex) {
            //error handling here
        } catch (IOException ex) {
            //error handling here
        }
    }
    
    
    private void showList() {
        for(NewOrder user: usersList) {
            delArea.append(user.toString());
            delArea.append("\n");
        }
    }
    
}
