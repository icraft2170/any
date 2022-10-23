package me.hero.customer;

import java.util.Objects;

public class MenuItem {

  private final String name;
  private final int price;

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public MenuItem(String name, int price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MenuItem)) {
      return false;
    }
    MenuItem menuItem = (MenuItem) o;
    return getPrice() == menuItem.getPrice() && Objects.equals(getName(),
        menuItem.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPrice());
  }

  public boolean matches(String name) {
    return this.name.equals(name);
  }
}
