package Classes;

public class Specific extends Abstract {
    public void hello() {
        System.out.println("Hello, I'm " + this.getClass() + '.');
    }

    public void run() {
        System.out.println("I'm " + this.getClass() + " & I'm running!");
    }
}
