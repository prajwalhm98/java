Package Abstraction;
public class Bike {
	abstract void run();
	}
class Honda extends Bike{
	void run()
	{
		System.out.println("running safetly");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike obj=new Honda();
		obj.run();


	}

}
