/*
* Interface for SpaceShip
* We have only one kind Spaceship(Rocket), there is no need interface but i am gaining experience
* */

public interface SpaceShip {
    boolean launch();              //true means Successful lounch
    boolean land();
    boolean canCarry(Item item);  //true means SpaceShip has eough capacitiy for this item
    void carry(Item item);         //add item to spaceship
}