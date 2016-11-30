
public class Apple implements GameThing, Edible {

	@Override
	public String getName() {
		return "An apple";
	}

	@Override
	public String getDescription() {
		return "It appears to be a green apple.";
	}
	
	@Override
	public void eat(){
		System.out.println("The apple tastes very bitter! You spit it out and toss it away.");
		AdventureEpsilon.theRoom.removeThing(AdventureEpsilon.theApple);
	}

}
