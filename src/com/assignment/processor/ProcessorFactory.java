package com.assignment.processor;

import java.lang.reflect.Proxy;

import com.assignment.helper.MessageProcessor;
import com.assignment.interceptor.Interceptor;

public class ProcessorFactory {
	public Processor getInstance(){
		 return (Processor) Proxy.newProxyInstance(
	             this.getClass().getClassLoader(),
	             new Class[]{Processor.class},
	             new Interceptor(new MessageProcessor()));
		}
}
