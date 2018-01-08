/*
* Simulation class for methods
*
*
* */


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    //load items to an ArrayList from text file
    ArrayList<Item> loadItems(String textFile){

        ArrayList<Item> loadItems = new ArrayList<Item>(); //Create ArrayList for loading items and returning method
        String strTemp; //temproary string for each line in text file
        try{
            File file = new File(textFile);         //open text file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                strTemp = scanner.nextLine().trim();
                int eqInd = strTemp.indexOf('=');        // get index of '=' sign in string
                if( eqInd!= -1){
                    Item itemTemp = new Item();          //Crate new item
                    itemTemp.name = strTemp.substring(0,eqInd);      //Left side of '=' sign is item's name
                    strTemp = strTemp.substring(eqInd+1);
                    try{
                        itemTemp.weight = Integer.parseInt(strTemp);    //Right side of '=' sign is item's weight
                    }catch (Exception e){                               //if it is not readable int(for no digit characters..)
                        itemTemp.weight = 0;                            //informate user and give '0' kg to this item's weight
                        System.out.println(itemTemp.name + "'s weight isn't digit:" + strTemp);
                    }finally {
                        loadItems.add(itemTemp);  //add this item to ArrayList<Item> loadItems
                    }
                }else{  //if there is no '=' sign, informate user and pass this line..
                    System.out.println("There is'nt '=' sign in this line:" + strTemp);
                }
            }
            scanner.close();
        }catch (Exception e){  //Exception for problems about reading file
            e.printStackTrace();
            System.out.println("Problem about text file!");
        }
        return loadItems;  //
    }


    //Prepare U1 rockets for lauching.. Load U1 rockets
    ArrayList<Rocket> loadU1(ArrayList<Item> loadItemsOriginal){

        ArrayList<Rocket> loadedU1s =new ArrayList<Rocket>();
        Item tempItem = new Item();
        ArrayList<Item> loadItems = (ArrayList<Item>) loadItemsOriginal.clone();  // clone Itemlist for not change original List

        while(!loadItems.isEmpty()){  // do it until all items loaded to rockets, and removed from the item array list
            U1 tempU1 = new U1();     // crate new U1 rocket for this turn
            int itemIndex = 0;        // start loading from the first item in the list,
            while(itemIndex<loadItems.size()){   // Try each item in the list to load,to Rocket
                tempItem = loadItems.get(itemIndex);  //get item
                if(tempU1.canCarry(tempItem)){          //if it is possible load item to rocket
                    tempU1.carry(tempItem);
                    loadItems.remove(itemIndex);       // and remove from item list
                    itemIndex--;                        //decrement itemIndex becouse of removing item(filling gap, slide down one)
                }
                itemIndex++;                        //for the next item increment index
            }
            loadedU1s.add(tempU1);              //Rocket capacitiy is full, becouse we tried all items to load rocket. now this rocket is ready to adding rocket list
        }
        return loadedU1s;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> loadItemsOriginal){ // Same logic with loadU1

        ArrayList<Rocket> loadedU2s =new ArrayList<Rocket>();
        Item tempItem = new Item();
        ArrayList<Item> loadItems = (ArrayList<Item>) loadItemsOriginal.clone();

        while(!loadItems.isEmpty()){
            U2 tempU2 = new U2();
            int itemIndex = 0;
            while(itemIndex<loadItems.size()){
                tempItem = loadItems.get(itemIndex);
                if(tempU2.canCarry(tempItem)){
                    tempU2.carry(tempItem);
                    loadItems.remove(itemIndex);
                    itemIndex--;
                }
                itemIndex++;
            }
            loadedU2s.add(tempU2);
        }
        return loadedU2s;
    }


    //
    int runSimulation(ArrayList<Rocket> rocketArray){
        int totalBudget = 0;  //counters
        int succRockets = 0;
        int failedRockets = 0;
        boolean isRocketSuccessful = true;
        for(Rocket rocket : rocketArray){   //for each rocket in list do this
            do{
                totalBudget+=rocket.rocketCost;  // increment budget for this trial
                isRocketSuccessful = rocket.launch() & rocket.land();  // ??successful lauch and land??
                System.out.print(rocketArray.indexOf(rocket)+1 + ". Rocket: ");   //give information about current rocket order
                if(isRocketSuccessful){
                    System.out.println("Successfull");
                    succRockets++;
                }else{
                    System.out.println("Failed");
                    failedRockets++;
                }
            }while (!isRocketSuccessful); // do it until this rocket Successful
        }
        System.out.println(succRockets + " rockets successful");
        System.out.println(failedRockets + " rockets failed");
        return totalBudget;  //result total budge for this simulation run
    }


}