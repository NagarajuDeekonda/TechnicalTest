package com.assignment.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


import com.assignment.helper.MessageProcessor;
import com.assignment.helper.ToBeValidated;
import com.assignment.helper.ValidateUtil;
import com.assignment.object.Entity;


public class Interceptor implements InvocationHandler{
	
	private MessageProcessor messageProcessor;

	  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		  if(method.isAnnotationPresent(ToBeValidated.class)){
		  ValidateUtil util = new ValidateUtil();
		  util.validate((Entity)args[0]);
		  }
          return method.invoke(this.messageProcessor, args);
      }
		public Interceptor(MessageProcessor messageProcessor){
			this.messageProcessor = messageProcessor;
		}
}
