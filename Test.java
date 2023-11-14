public class Test {

	public static void main(String[] args) {
        Game g = new Game(10);

        if(args[0].equals("stratA"))
            g.strategyA();

        else if(args[0].equals("stratB"))
            g.strategyB();

        else System.out.println("Please enter stratA or stratB");

        g.printBored();
	}
}
