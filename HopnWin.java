import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class SoftToy implements Cloneable{
    private String name ;
    public SoftToy(String _name){
        name = _name;
    }

    public String getName() {
        return name;
    }
    @Override
    public SoftToy clone(){
        try {
            SoftToy copy = (SoftToy) super.clone();
            return copy;
        }
        catch (CloneNotSupportedException exception){
            return null;
        }
}}

class Tile {
    private SoftToy softToy;
    private int id;
    public Tile(SoftToy _softToy , int _id){
        softToy = _softToy;
        id = _id;
    }

    public SoftToy getSoftToy() {
        return softToy;
    }
    public int getId(){
        return id;
    }

    }

class Calculate<Type>{
    private Type x;
    private Type y;
    public Calculate(Type _x , Type _y){
        x = _x;
        y = _y;
    }

    //public boolean calculator(Type ans){
        //if((x instanceof String) && (y instanceof String) && (ans instanceof String)){
            //return (((String) x).concat((String) y)).equals((String) ans);
        //}
        //else if ((x instanceof Integer) && (y instanceof Integer) && (ans instanceof Integer)){
            //Integer actualans = ((Integer) x) / ((Integer) y);
            //return ans.equals(actualans);
        //}
        //return false;
    //}

    public boolean calculator(Type ans){
        try {
            return ((Integer) x / (Integer) y) == (Integer) ans;
        }
        catch (ClassCastException e){
            return ((String) x + (String) y).equals((String) ans);
        }
    }
}
class Player{
    private LinkedList<SoftToy> SofToysEarned = new LinkedList<SoftToy>();
    private int rollValue;

    public LinkedList<SoftToy> getSofToysEarned() {
        return SofToysEarned;
    }
    public void addSoftToy(SoftToy softToy){
        SofToysEarned.add(softToy);
    }

    public void roll(){
        Random random = new Random();
        rollValue = random.nextInt(25);
    }

    public int getRollValue() {
        return rollValue;
    }
}
class Game{
    private Player player;
    private LinkedList<Tile> ListofTiles;
    public Game(){
        player = new Player();
        ListofTiles = new LinkedList<Tile>();
        SoftToy MickeyMouse = new SoftToy("Mickey Mouse");
        Tile one = new Tile(MickeyMouse,1);
        ListofTiles.add(one);
        SoftToy MineyMouse = new SoftToy("Miney Mouse");
        Tile two = new Tile(MineyMouse,2);
        ListofTiles.add(two);
        SoftToy DonaldDuck = new SoftToy("Donald Duck");
        Tile three = new Tile(DonaldDuck,3);
        ListofTiles.add(three);
        SoftToy Tom = new SoftToy("Tom");
        Tile four = new Tile(Tom,4);
        ListofTiles.add(four);
        SoftToy Jerry = new SoftToy("Jerry");
        Tile five = new Tile(Jerry,5);
        ListofTiles.add(five);
        SoftToy Phineas = new SoftToy("Phineas");
        Tile six = new Tile(Phineas,6);
        ListofTiles.add(six);
        SoftToy Ferb = new SoftToy("Ferb");
        Tile seven = new Tile(Ferb,7);
        ListofTiles.add(seven);
        SoftToy Naruto = new SoftToy("Naruto");
        Tile eight = new Tile(Naruto,8);
        ListofTiles.add(eight);
        SoftToy Sasuke = new SoftToy("Sasuke");
        Tile nine = new Tile(Sasuke,9);
        ListofTiles.add(nine);
        SoftToy Goku = new SoftToy("Goku");
        Tile ten = new Tile(Goku,10);
        ListofTiles.add(ten);
        SoftToy Vegeta = new SoftToy("Vegeta");
        Tile eleven = new Tile(Vegeta,11);
        ListofTiles.add(eleven);
        SoftToy Bheem = new SoftToy("Bheem");
        Tile twelve = new Tile(Bheem,12);
        ListofTiles.add(twelve);
        SoftToy Raju = new SoftToy("Raju");
        Tile thirteen = new Tile(Raju,13);
        ListofTiles.add(thirteen);
        SoftToy Jaggu = new SoftToy("Jaggu");
        Tile fourteen = new Tile(Jaggu,14);
        ListofTiles.add(fourteen);
        SoftToy Chutki = new SoftToy("Chutki");
        Tile fifteen = new Tile(Chutki,15);
        ListofTiles.add(fifteen);
        SoftToy Kalia = new SoftToy("Kalia");
        Tile sixteen = new Tile(Kalia,16);
        ListofTiles.add(sixteen);
        SoftToy Dholu = new SoftToy("Dholu");
        Tile seventeen = new Tile(Dholu,17);
        ListofTiles.add(seventeen);
        SoftToy Bholu = new SoftToy("Bholu");
        Tile eighteen = new Tile(Bholu,18);
        ListofTiles.add(eighteen);
        SoftToy Rajkumar = new SoftToy("Rajkumar");
        Tile nineteen = new Tile(Rajkumar,19);
        ListofTiles.add(nineteen);
        SoftToy Indumati = new SoftToy("Indumati");
        Tile twenty = new Tile(Indumati,20);
        ListofTiles.add(twenty);
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Tile> getListofTiles() {
        return ListofTiles;
    }
    public int RandomNumberGenerator(){
        Random random = new Random();
        return (1+ random.nextInt(1000));
    }
    public String RandomStringGenerator(){
        LinkedList<String> list = new LinkedList<String>();
        Random random = new Random();
        list.add("a");
        list.add("A");
        list.add("b");
        list.add("B");
        list.add("c");
        list.add("C");
        list.add("d");
        list.add("D");
        list.add("e");
        list.add("E");
        list.add("f");
        list.add("F");
        list.add("g");
        list.add("G");
        list.add("h");
        list.add("H");
        list.add("i");
        list.add("I");
        list.add("j");
        list.add("J");
        list.add("k");
        list.add("K");
        list.add("l");
        list.add("L");
        list.add("m");
        list.add("M");
        list.add("n");
        list.add("N");
        list.add("o");
        list.add("O");
        list.add("p");
        list.add("P");
        list.add("q");
        list.add("Q");
        list.add("r");
        list.add("R");
        list.add("s");
        list.add("S");
        list.add("t");
        list.add("T");
        list.add("u");
        list.add("U");
        list.add("v");
        list.add("V");
        list.add("w");
        list.add("W");
        list.add("x");
        list.add("X");
        list.add("y");
        list.add("Y");
        list.add("z");
        list.add("Z");
        String result = "";
        for (int i =0 ; i<4 ; i++){
            String a = list.get(random.nextInt(52));
            result = result.concat(a);
        }
        return result;


    }
    public void GameImplementation(){
        for (int i = 0;i<5;i++){

            System.out.print("Hit enter for hop number "+(i+1));
            Scanner sc2 = new Scanner(System.in);
            String s = sc2.nextLine();
            try {
                getPlayer().roll();
                Tile HoppedOn = getListofTiles().get(getPlayer().getRollValue());
                if((HoppedOn.getId())%2 == 0){
                    System.out.println("You have landed on tile:"+HoppedOn.getId());
                    System.out.println("You have won a "+HoppedOn.getSoftToy().getName()+" soft toy");
                    //System.out.println(HoppedOn.getSoftToy());
                    SoftToy toAddtoBucket = HoppedOn.getSoftToy().clone();
                    //System.out.println(HoppedOn.getSoftToy());
                    //System.out.println(toAddtoBucket);
                    getPlayer().getSofToysEarned().add(toAddtoBucket);
                }
                else if ((HoppedOn.getId())%2 == 1){

                    System.out.println("You have landed on tile:"+HoppedOn.getId());
                    System.out.print("Question Answer Round.Integer or String");
                    boolean done = false;
                    String IorS = new String();
                    while (!done){
                        try {
                            Scanner sc3 = new Scanner(System.in);
                            IorS = sc3.nextLine();
                            if((IorS.toLowerCase().equals("integer") || IorS.toLowerCase().equals("string"))){
                                done = true;
                            }
                            else {
                                System.out.println("Wrong Input! Please try again");
                            }

                        }
                        catch (NullPointerException e){
                            System.out.println("Try again");
                        }

                    }
                    if (IorS.toLowerCase().equals("integer")){

                        boolean done1 = false;
                        Integer x = 0;
                        Integer y = 0;
                        while (!done1){
                            try{
                                x = RandomNumberGenerator();
                                y = RandomNumberGenerator();
                                done1 = true;
                            }
                            catch (NullPointerException e){
                                System.out.println("Try again");
                            }
                        }
                        boolean done2 = false;
                        Integer ans = 0;
                        while (!done2){
                            try {
                                Scanner sc4 = new Scanner(System.in);
                                System.out.println("Calculate the quotient of "+x+" divided by "+y);
                                ans = sc4.nextInt();
                                Calculate<Integer> calculate = new Calculate<Integer>(x,y);
                                if(calculate.calculator(ans)){
                                    System.out.println("You have won "+HoppedOn.getSoftToy().getName()+" soft toy");
                                    //System.out.println(HoppedOn.getSoftToy());
                                    SoftToy toy = HoppedOn.getSoftToy().clone();
                                    //System.out.println(HoppedOn.getSoftToy());
                                    //System.out.println(toy);
                                    getPlayer().getSofToysEarned().add(toy);
                                    done2 = true;
                                }
                                else {
                                    System.out.println("Wrong answer. No soft toy won");
                                    done2 = true;
                                }
                            }
                            catch (NullPointerException e){
                                System.out.println("Try again");
                            }
                            catch (InputMismatchException e){
                                System.out.println("Wrong Input.Try again");
                            }
                        }


                    }
                    else {
                        boolean done3 = false;
                        String a = "";
                        String b = "";
                        while (!done3){
                            try{
                                a = RandomStringGenerator();
                                b = RandomStringGenerator();
                                done3 = true;
                            }
                            catch (NullPointerException e){
                                System.out.println("Try again");
                            }
                        }
                        boolean done4 = false;
                        String res = "";
                        while (!done4){
                            try {
                                Scanner sc5 = new Scanner(System.in);
                                System.out.print("Calculate the concatenation of string "+a+" with string "+b);
                                res = sc5.nextLine();
                                Calculate<String> stringCalculate = new Calculate<String>(a,b);
                                if(stringCalculate.calculator(res)){
                                    System.out.println("You have won "+ HoppedOn.getSoftToy().getName() + " soft toy");
                                    SoftToy Toy = HoppedOn.getSoftToy();
                                    //System.out.println(HoppedOn.getSoftToy());
                                    getPlayer().getSofToysEarned().add(Toy);
                                    //System.out.println(HoppedOn.getSoftToy());
                                    //System.out.println(Toy);
                                    done4 = true;
                                }
                                else {
                                    System.out.println("Wrong answer. No soft toy won");
                                    done4 = true;
                                }
                            }
                            catch (InputMismatchException e){
                                System.out.println("Wrong Input. Please try again");

                            }
                            catch (NullPointerException e){
                                System.out.println("Try again");
                            }
                        }
                    }



                }
            }
            catch (IndexOutOfBoundsException e1){
                System.out.println("You were too energetic and zoomed past all the tiles. Muddy puddle splash");
            }

        }
        System.out.println("Game over.");
        System.out.println("Soft toys you have won are -");
        try{
            for (int q = 0;q<getPlayer().getSofToysEarned().size();q++){
                System.out.print(getPlayer().getSofToysEarned().get(q).getName()+" , ");
            }
            //System.out.println(game.getPlayer().getSofToysEarned().get(game.getPlayer().getSofToysEarned().size()-1).getName());

        }
        catch (IndexOutOfBoundsException e){
            System.out.println("");
        }
    }
}

public class HopnWin {



    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        System.out.print("Hit enter to initialize the game.");
        String inp = sc1.nextLine();
        Game game = new Game();
        System.out.println("Game is ready");
        game.GameImplementation();

        }
    }




