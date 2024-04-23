import java.util.Scanner;

public class Baccarat {
    public static void main(String[] args) {
        
        int roundsPlayed = 0;
        int playerWins = 0;
        int bankerWins = 0;
        int tiedRounds = 0;

        Shoe shoe = new Shoe(6);
        Scanner scanner = new Scanner(System.in);
        shoe.shuffle();


        if (args.length > 0) {
            do {
                roundsPlayed++;

                BaccaratHand playerHand = new BaccaratHand();
                BaccaratHand bankerHand = new BaccaratHand();

                for (int i = 0; i < 2; i++) {
                    playerHand.add(shoe.deal());
                    bankerHand.add(shoe.deal());
                }

                System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());


                
                if (playerHand.value() <= 5){
                    System.out.println("Dealing a third card to player...");
                    playerHand.add(shoe.deal()); 
                    System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                    System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                } else if (playerHand.size() == 2 && bankerHand.value() <= 5) {
                    System.out.println("Dealing a third card to banker...");
                    bankerHand.add(shoe.deal()); 
                    System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                    System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                } else if (playerHand.size() == 3) {
                    if(bankerHand.value() <= 2){
                        System.out.println("Dealing a third card to banker...");
                        bankerHand.add(shoe.deal()); 
                        System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                        System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                    } else if(bankerHand.value() == 3){
                        if(playerHand.value() == 8){
                            System.out.println("Dealing a third card to banker...");
                            bankerHand.add(shoe.deal()); 
                            System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                            System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                        }
                    } else if(bankerHand.value() == 4){
                        if(playerHand.value() == 2 || playerHand.value() == 3 || playerHand.value() == 4 || playerHand.value() == 5 || playerHand.value() == 6 || playerHand.value() == 7){
                            System.out.println("Dealing a third card to banker...");
                            bankerHand.add(shoe.deal()); 
                            System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                            System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                        }
                    } else if(bankerHand.value() == 5){
                        if(playerHand.value() == 4 || playerHand.value() == 5 || playerHand.value() == 6 || playerHand.value() == 7){
                            System.out.println("Dealing a third card to banker...");
                            bankerHand.add(shoe.deal()); 
                            System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                            System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                        }
                    } else if(bankerHand.value() == 6){
                        if(playerHand.value() == 6 || playerHand.value() == 7){
                            System.out.println("Dealing a third card to banker...");
                            bankerHand.add(shoe.deal()); 
                            System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                            System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
                        }
                    }
                }
                    if (playerHand.value() > bankerHand.value()){
                        System.out.println("Player win!");
                        playerWins ++;
                    }

                    if (playerHand.value() < bankerHand.value()){
                        System.out.println("Banker win!");
                        bankerWins ++;
                    }

                    if (playerHand.value() == bankerHand.value()){
                        System.out.println("Tie");
                        tiedRounds ++;
                    }

                
                    System.out.print("Do you want to continue playing? (Y/N): ");
                    String response = scanner.nextLine();
                    if (!response.toLowerCase().startsWith("y")) {
                        System.out.println(roundsPlayed + " rounds played");
                        System.out.println(playerWins + " player wins");
                        System.out.println(bankerWins + " banker wins");
                        System.out.println(tiedRounds + " ties");
                        break;
                    }
                    
               

            } while (shoe.size() >= 6);
        } else {
            do {
                roundsPlayed++;
                BaccaratHand playerHand = new BaccaratHand();
                BaccaratHand bankerHand = new BaccaratHand();

                for (int i = 0; i < 2; i++) {
                    playerHand.add(shoe.deal());
                    bankerHand.add(shoe.deal());
                }

                System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
                System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());

                if (playerHand.isNatural()) {
                    System.out.println("Player has a Natural!");
                    playerWins++;
                } else if (bankerHand.isNatural()) {
                    System.out.println("Banker has a Natural!");
                    bankerWins++;
                } else {
                    System.out.println("Neither have a Natural!");
                    tiedRounds++;
                }


            } while (shoe.size() >=6);

            scanner.close();
        }


    }
}
