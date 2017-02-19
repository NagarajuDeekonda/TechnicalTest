package com.assignment.entity;

import java.util.Comparator;

import com.assignment.object.Entity;

public class EntityComparator implements Comparator<Entity>{

	public int compare(Entity e1, Entity e2) {
		return -(e1.getPriceInUSD().compareTo(e2.getPriceInUSD()));
	}
	
}
