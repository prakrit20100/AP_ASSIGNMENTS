
import java.util.Random;
import java.util.Scanner;


class Floor{
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String _type) {
        type = _type;
    }

}

class Snake{
    private String type;

    public String getType() {
        return type;
    }



    public void setType(String _type) {
        type = _type;
    }



}
class Ladder extends Floor{
    private final int PointsforthatFloor = 2;

    public Ladder(String _type){
        this.setType(_type);
    }

    public int getPointsforthatFloor() {
        return PointsforthatFloor;
    }
}

class Elevator extends Floor{
    private final int PointsforthatFloor = 4;

    public Elevator(String _type){
        this.setType(_type);
    }


    public int getPointsforthatFloor() {
        return PointsforthatFloor;
    }
}

class Empty extends Floor{
    private final int PointsforthatFloor = 1;

    public Empty(String _type){
        this.setType(_type);
    }

    public int getPointsforthatFloor() {
        return PointsforthatFloor;
    }
}

class NormalSnake extends Snake{
    private final int PointforthatFloor = -2;

    public NormalSnake(String _type){
        this.setType(_type);
    }

    public int getPointforthatFloor() {
        return PointforthatFloor;
    }
}

class KingCobra extends Snake{

    private final int PointsforthatFloor = -4;

    public KingCobra(String _type){
        this.setType(_type);
    }

    public int getPointsforthatFloor() {
        return PointsforthatFloor;
    }
}



class Player{
    private final String name;
    private int level;
    private int PointsEarned;
    public Player(String _name , int _level){
        name = _name;
        level = _level;
        PointsEarned=0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getPointsEarned() {
        return PointsEarned;
    }

    public void setPointsEarned(int _pointsEarned) {
        PointsEarned = _pointsEarned;
    }

    public void setLevel(int _level) {
        level = _level;
    }
    public void changeLevel(int x){
        level = level+x;
    }
}

 class Dice {
    Random random = new Random();
    private final int numFaces;
    private int faceValue;

    public Dice(int _numFaces) {
        numFaces = _numFaces;
        roll();
    }
    public void roll() {
        int curr_faceValue = 1 + random.nextInt(numFaces);
        setFaceValue(curr_faceValue);
    }
    private void setFaceValue (int value) {
        if (value <= numFaces)
            faceValue = value;
    }
    public int getFaceValue() {
        return faceValue;
    }
    public int getNumFaces() {
        return numFaces;
    }


}





public class SnakeandLadders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String PlayerName = new String();
        String input = new String();
        Empty empty = new Empty("Empty");
        Ladder ladder = new Ladder("Ladder");
        Elevator elevator = new Elevator("Elevator");
        NormalSnake normalSnake = new NormalSnake("Normal Snake");
        KingCobra kingCobra = new KingCobra("King Cobra");
        System.out.println("Enter the player name and hit enter");
        PlayerName=sc.nextLine();
        Player player = new Player(PlayerName,-1);
        System.out.println("Hit enter to start the game");
        input=sc.nextLine();
        Dice dice = new Dice(2);
        dice.roll();
        if (input.equals("")){
            while (player.getLevel()!=0){
                System.out.println("Dice gave "+dice.getFaceValue());
                if(dice.getFaceValue()==2){
                    System.out.println("Game cannot start till you get 1");
                }
                else if (dice.getFaceValue()==1) {
                    player.setLevel(dice.getFaceValue() + player.getLevel());
                    player.setPointsEarned(empty.getPointsforthatFloor());
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached the "+empty.getType()+" floor");
                    System.out.println("Total points:"+player.getPointsEarned());
                    break;

                }
                System.out.println("Hit enter to roll the dice");
                input= sc.nextLine();
                if (input.equals("")){
                    dice.roll();
                }
            }
        }
        System.out.println("Hit enter to roll the dice");
        input= sc.nextLine();
        if (input.equals("")){
            dice.roll();
            while (player.getLevel()!=13){
                System.out.println("Dice gave "+dice.getFaceValue());
                player.changeLevel(dice.getFaceValue());
                if (player.getLevel()==1){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==2){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+elevator.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ elevator.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                    player.changeLevel(8);
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==3){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==4){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==5){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+normalSnake.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+normalSnake.getPointforthatFloor());
                    System.out.println("Total points: "+player.getPointsEarned());
                    player.changeLevel(-4);
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==6){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==7){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==8){
                    System.out.println("Player position floor"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+ladder.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ ladder.getPointsforthatFloor());
                    System.out.println("Total points :"+player.getPointsEarned());
                    player.changeLevel(4);
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==9){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==10){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==11){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+kingCobra.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ kingCobra.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                    player.changeLevel(-8);
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==12){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                }
                else if (player.getLevel()==13){
                    System.out.println("Player position floor:"+player.getLevel());
                    System.out.println(player.getName()+" has reached "+empty.getType()+" floor");
                    player.setPointsEarned(player.getPointsEarned()+ empty.getPointsforthatFloor());
                    System.out.println("Total points:"+player.getPointsEarned());
                    System.out.println("Game over");
                    System.out.println("Total points accumulated by "+player.getName()+" is "+player.getPointsEarned());
                    break;
                }
                else if (player.getLevel()>13){
                    player.setLevel(12);
                    System.out.println("Player cannot move");
                }
                System.out.println("Hit enter to roll the dice");
                input= sc.nextLine();
                if (input.equals("")){
                    dice.roll();
                }
            }

        }










    }
}
