public class U1 extends Rocket{

    U1(){
        //initilize U1 rocket specific informations
        rocketWeight = 10000;      //kg
        maxRocketWeight = 18000;  //kg
        rocketCost = 100;         //million $
        probLaunchExp = 5;  //probability of explotion at launch (per %)
        probLandCrash = 1;    //probability of crash at land (per %)

    }

    public boolean launch(){
        double chanceExp =  ((double) rocketWeight) * probLaunchExp / maxRocketWeight ; //k% * (cargo carried / cargo limit)
        //rocketWeight/maxRocketWeight ratio is beetween = 0 and 1
        //So chanceExp is beetween 0 and 5  %
        //Random number*100 is between 0 and 99
        //if this random lower than chanceExp, explotion occurs
        if( (100 *Math.random()) < chanceExp) {
            return false;
        }

        return true;

    }

    public boolean land(){
        double chanceCrash =  ((double) rocketWeight) * probLandCrash / maxRocketWeight ; //k% * (cargo carried / cargo limit)
        //Same logic

        if( (100 *Math.random()) < chanceCrash) {
            return false;
        }

        return true;

    }
}