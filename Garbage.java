class Demo {
    int x;

    Demo(int x) {
        this.x = x;
        System.out.println("Object created, x = " + x);
    }

    // finalize method
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called for x = " + x);
    }
}

public class Main {
    public static void main(String[] args) {

        Demo d1 = new Demo(10);
        Demo d2 = new Demo(20);

        // Make objects eligible for garbage collection
        d1 = null;
        d2 = null;

        // Request garbage collection
        System.gc();

        try {
            Thread.sleep(1000); // give GC time (not guaranteed)
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("End of program");
    }
}
