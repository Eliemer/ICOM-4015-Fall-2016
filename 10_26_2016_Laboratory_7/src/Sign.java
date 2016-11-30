public class Sign implements GameThing, Readable, Edible
{
	public String getName()
	{
		return "A sign that appears to be made completely out of chocolate!";
	}
	public String getDescription()
	{
		return "This is a small wooden sign. There seems to be some partially faded writing in it.";
	}
	public void read(){
		System.out.println("You can see the following message: \"John was here!\"");
	}
	public void eat(){
		System.out.println("Why are you doing this....");
		AdventureEpsilon.theRoom.removeThing(AdventureEpsilon.theSign);
		System.out.println("You ate the whole sign, you fatass...");
	}
}
