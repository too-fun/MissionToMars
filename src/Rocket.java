public class Rocket implements SpaceShip{

    int rocketWeight;      //kg
    int maxRocketWeight;  //kg
    int rocketCost;         //million $
    int probLaunchExp;  //probability factor of explotion at launch (per %)
    int probLandCrash;    //probability factor of crash at land (per %)

    public boolean launch(){return true;} //in specific rocket class, method will be override
    public boolean land(){return true;} //in specific rocket class, method will be override
    public boolean canCarry(Item item){  //true for Rocket has enough capacity or vice versa
        if(item.weight + this.rocketWeight > this.maxRocketWeight){
            return false;
        }else{
            return true;
        }
    }

    public void carry(Item item){   //add an item to Rocket, rocketWeight increase by item weight
        this.rocketWeight += item.weight;
    }
}