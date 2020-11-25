package com.gojek.coding.parkinglot.challenge.service.impl;

import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParkingSlotHelper {

  private TreeSet<Integer> slots;

  public ParkingSlotHelper(TreeSet<Integer> slots) {
    this.slots = slots;
  }

  public boolean blockSlot(int i) {
    return slots.remove(i);
  }

  public int getSlot() {
    return slots.isEmpty() ? -1 : slots.first();
  }

  public LinkedList<Integer> getFreeSlotStatus() {
    LinkedList<Integer> freeSlots = slots.stream().collect(Collectors.toCollection(LinkedList::new));
    return freeSlots;
  }

  public boolean unBlockSlot(int slot) {
    return slots.contains(slot) ? false : slots.add(slot);
  }

}
