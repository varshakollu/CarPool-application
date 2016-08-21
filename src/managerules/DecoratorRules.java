package managerules;

public abstract class DecoratorRules extends Rules {

	protected Rules rules;
	
	public DecoratorRules(Rules rules){
		this.rules=rules;
	}
	
	public boolean verifyRule(){
		rules.verifyRule();
		return false;
	}
	
}
