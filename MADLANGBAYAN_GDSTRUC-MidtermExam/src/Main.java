//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    CardStack playerDeck = new CardStack(30, "Player Deck");
    CardStack discardedPile = new CardStack(30, "Discarded Pile");
    CardStack playerPile = new CardStack(30, "Player's Pile");

    for (int i=0; i < 30; i++)
    {
        playerDeck.push(new Card());
    }

    int turn = 1;
    int command, numberOfCards, numberOfCommands;
    System.out.println("\nThe rules are simple:\n3 random commands per turn will dictate whether you draw or discard a card from any pile");
    System.out.println("Game ends if the player deck is empty");
    new java.util.Scanner(System.in).nextLine();

    System.out.println("Clubs, Diamonds, Hearts, Spades");
    System.out.println("Input the card suit you would prefer: ");
    Scanner suitScanner = new Scanner(System.in);
    String suit = suitScanner.nextLine();
    suit = suit.substring(0,1).toUpperCase() + suit.substring(1);

    System.out.println("\nAce, Two - Ten, Jack, Queen, King");
    System.out.println("Input the card rank you would prefer: ");
    Scanner rankScanner = new Scanner(System.in);
    String rank = rankScanner.nextLine();
    rank = rank.substring(0,1).toUpperCase() + rank.substring(1);
    new java.util.Scanner(System.in).nextLine();

    System.out.println("If a card matches the suit or rank, you repeat whatever command is given");
    System.out.println("This can help or hurt a turn (it's recursive too). Enjoy!");
    new java.util.Scanner(System.in).nextLine();

    do
    {
        numberOfCommands = 1;
        System.out.println("\nTurn " + turn + ":");
        do
        {
            System.out.println("\nCommand " + numberOfCommands + ":");
            command = (int) (Math.random() * 3 + 1);
            numberOfCards = (int) (Math.random() * 5 + 1);

            if (command == 1)
            {
                System.out.println("Draw " + numberOfCards + " card/s.");

                displaceCards(playerDeck, playerPile, numberOfCards, suit, rank);
            }

            if (command == 2)
            {
                System.out.println("Discard " + numberOfCards + " card/s.");

                displaceCards(playerPile, discardedPile, numberOfCards, suit, rank);
            }

            if (command == 3)
            {
                System.out.println("Get " + numberOfCards + " card/s from the discarded pile.");

                displaceCards(discardedPile, playerPile, numberOfCards, suit, rank);
            }

            playerPile.printStack();
            System.out.println("\n" + "Remaining cards in the player deck: " + playerDeck.getNumberOfCards());
            System.out.println("\n" + "Cards in the discarded pile: " + discardedPile.getNumberOfCards());

            numberOfCommands++;
            new java.util.Scanner(System.in).nextLine();
        } while (numberOfCommands <= 3 && !playerDeck.isEmpty());

        turn++;
        new java.util.Scanner(System.in).nextLine();
    } while (!playerDeck.isEmpty());
}

public void displaceCards(CardStack initialStack, CardStack destinationStack, int numberOfCards, String suit, String rank)
{
    if (initialStack.isEmpty())
    {
        System.out.println("\nPile is empty. Command disregarded.");
        new java.util.Scanner(System.in).nextLine();
    }

    else
    {
        boolean cardMatch;
        do
        {
            Card firstCard = initialStack.peek();
            cardMatch = firstCard.getName().contains(suit) || firstCard.getName().contains(rank);

            for (int i = 1; i <= numberOfCards; i++)
            {
                if (initialStack.isEmpty())
                {
                    System.out.println("\nPile size beyond no. of cards needed.");
                    break;
                }
                else
                {
                    firstCard = initialStack.pop();
                    destinationStack.push(firstCard);
                }
            }
            new java.util.Scanner(System.in).nextLine();

            if (cardMatch && !initialStack.isEmpty())
            {
                System.out.println("You have a card match! " + numberOfCards + " more card/s will be pulled later!");
                new java.util.Scanner(System.in).nextLine();
            }
        } while (cardMatch && !initialStack.isEmpty());
    }
}
