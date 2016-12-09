package com.calculator;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;
import javax.jws.WebService;

public class calculator {
	
	public Object calcOperation(String oprandString) throws ScriptException{
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = "40+2";
	    System.out.println(engine.eval(oprandString));
		return engine.eval(oprandString);
	}
}
