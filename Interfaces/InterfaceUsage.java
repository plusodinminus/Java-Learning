package Interfaces;

public class InterfaceUsage implements FirstInterface, SecondInterface {
    @Override
    public void hello() {
        System.out.println("Hello!");
    }

    @Override
    public void bye() {
        System.out.print("Bye!");
    }
}
