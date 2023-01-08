package lambdasinaction.chatper2;

public class MeaningOfThie {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        var runnable = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        MeaningOfThie instance = new MeaningOfThie();
        instance.doIt();
    }
}
