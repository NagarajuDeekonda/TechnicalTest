package com.assignment.processor;

import com.assignment.helper.*;
import com.assignment.object.*;

public interface Processor {
	@ToBeValidated public void process(Entity entity);
	
	static Processor newProcessor() {
        ProcessorFactory processorFactory = new ProcessorFactory();
        return processorFactory.getInstance();
    }
}
