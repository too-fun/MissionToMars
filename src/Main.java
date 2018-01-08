import java.util.ArrayList;
/*
* Main Class for Mission to Mars homework Udacity Java OOP course
*
*
* */
public class Main {
    public static void main(String [] args){
        Simulation simulation = new Simulation();                                //Crate an instance of Simulation class
        ArrayList<Item> phase1items = simulation.loadItems("Phase-1.txt"); // Get Items form text file into ArrayList
        ArrayList<Item> phase2items = simulation.loadItems("Phase-2.txt");

        ArrayList<Rocket> fleetU1phase1 = simulation.loadU1(phase1items);  //Load phase1 items into U1 rockets
        System.out.println("Phase1 with U1 rockets");
        System.out.println("We need to send " + fleetU1phase1.size()+" U1 rockets");
        int totalBudgetU1phase1 = simulation.runSimulation(fleetU1phase1);  //run simulation and calculate total cost of budget (failed and succesful rockets totaly)

        ArrayList<Rocket> fleetU1phase2 = simulation.loadU1(phase2items);
        System.out.println("Phase2 with U1 rockets");
        System.out.println("We need to send " + fleetU1phase2.size()+" U1 rockets");
        int totalBudgetU1phase2 = simulation.runSimulation(fleetU1phase2);

        ArrayList<Rocket> fleetU2phase1 = simulation.loadU2(phase1items);
        System.out.println("Phase1 with U2 rockets");
        System.out.println("We need to send " + fleetU2phase1.size()+" U2 rockets");
        int totalBudgetU2phase1 = simulation.runSimulation(fleetU2phase1);

        ArrayList<Rocket> fleetU2phase2 = simulation.loadU2(phase2items);
        System.out.println("Phase2 with U2 rockets");
        System.out.println("We need to send " + fleetU2phase2.size()+" U2 rockets");
        int totalBudgetU2phase2 = simulation.runSimulation(fleetU2phase2);

        System.out.println("U1 phase1 budget: " + totalBudgetU1phase1);    //Print results
        System.out.println("U1 phase2 budget: " + totalBudgetU1phase2);
        System.out.println("U2 phase1 budget: " + totalBudgetU2phase1);
        System.out.println("U2 phase2 budget: " + totalBudgetU2phase2);

    }
}
