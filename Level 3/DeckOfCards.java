import java.util.Scanner;

public class DeckOfCards {

    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;

        String[] deck = new String[numOfCards];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {

            for (int j = 0; j < ranks.length; j++) {

                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }


    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber =
                    i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    public static String[][] distributeCards(
            String[] deck, int numberOfPlayers, int numberOfCards) {

        if (numberOfCards % numberOfPlayers != 0) {

            System.out.println(
                    "Cards cannot be equally distributed among players."
            );

            return null;
        }

        int cardsPerPlayer = numberOfCards / numberOfPlayers;

        String[][] players =
                new String[numberOfPlayers][cardsPerPlayer];

        int index = 0;

        for (int i = 0; i < numberOfPlayers; i++) {

            for (int j = 0; j < cardsPerPlayer; j++) {

                players[i][j] = deck[index];
                index++;
            }
        }

        return players;
    }

    public static void printPlayers(String[][] players) {

        if (players == null) {
            return;
        }

        for (int i = 0; i < players.length; i++) {

            System.out.println(
                    "\nPlayer " + (i + 1) + " cards:"
            );

            for (int j = 0; j < players[i].length; j++) {

                System.out.println(players[i][j]);
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] suits = {
                "Hearts",
                "Diamonds",
                "Clubs",
                "Spades"
        };

        String[] ranks = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        int numOfCards = suits.length * ranks.length;

        String[] deck = initializeDeck(suits, ranks);

        System.out.println("Total cards in deck: " + numOfCards);

        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();

        System.out.print("Enter number of players: ");
        int x = sc.nextInt();

        if (n > numOfCards) {
            System.out.println("Cannot distribute more than 52 cards.");
            sc.close();
            return;
        }

        if (x <= 0) {
            System.out.println("Number of players must be greater than 0.");
            sc.close();
            return;
        }

        if (n % x != 0) {
            System.out.println(
                    n + " cards cannot be equally distributed among "
                            + x + " players."
            );
            sc.close();
            return;
        }


        deck = shuffleDeck(deck);

        String[][] players =
                distributeCards(deck, x, n);

        printPlayers(players);

        sc.close();
    }
}
