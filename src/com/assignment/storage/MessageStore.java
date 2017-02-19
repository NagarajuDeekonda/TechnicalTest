package com.assignment.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.assignment.entity.EntityComparator;
import com.assignment.object.Entity;

public class MessageStore {
	
	private MessageStore(){
		
	}
	
	public static MessageStore getInstance(){
		return INSTANCE;
	}
	
	private static final MessageStore INSTANCE = new MessageStore();
	
	public static List<Entity> outgoingEntities = new ArrayList<Entity>();
	
	public static List<Entity> incomingEntities = new ArrayList<Entity>();
	
	EntityComparator comparator = new EntityComparator();
	
	public void storeOutgoingEntities(Entity entity){
		outgoingEntities.add(entity);
		Collections.sort(outgoingEntities,comparator);
	}
	
	public void storeIncomingEntities(Entity entity){
		incomingEntities.add(entity);
		Collections.sort(incomingEntities,comparator);
	}
}
