package me.hero.customer;

public class Cooker {

  public Cook makeCook(MenuItem menuItem) {
    return new Cook(menuItem);
  }
}
