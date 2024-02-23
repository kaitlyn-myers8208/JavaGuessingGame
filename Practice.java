public class Practice {
    public static void main(String[] args) {
        int myInt = 4;
        System.out.println("This is my int: " + myInt);
        String name = "Kaitlyn";
        System.out.println("This is my name: " + name);
        float myFloat = 3.2f;
        System.out.println("This is my float: " + myFloat);
        boolean myBool = true;
        System.out.println("This is my booleon: " + myBool);
        int yourInt = 4, hisInt = 3, herInt = 20;
        System.out.println("The three ints together is: " + (yourInt + hisInt + herInt));
        int yourInt2, hisInt2, herInt2;
        yourInt2 = hisInt2 = herInt2 = 12;
        System.out.println("The three ints together is: " + (yourInt2 + hisInt2 + herInt2));
        System.out.println("The length of my string is: " + name.length());

        myInt = 12;
        System.out.println("My int is now: " + myInt);
    }
}
