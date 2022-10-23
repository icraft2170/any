package me.hero.customer;

public class Customer {

  public void order(String menuName, Menu menu, Cooker cooker) {
    MenuItem chooseItem = menu.choose(menuName);
    Cook cook = cooker.makeCook(chooseItem);
  }

}
