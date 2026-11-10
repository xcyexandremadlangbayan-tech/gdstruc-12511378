//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    PlayerQueue matchmakingQueue = new PlayerQueue(7);
    int game = 1;
    int lastId = 0;
    int turn = 1;

    do
    {
        new java.util.Scanner(System.in).nextLine();
        do
        {
            System.out.println("Turn " + turn);
            int players = (int) ((Math.random() * 7) + 1);

            for (int i = 0; i < players; i++)
            {
                lastId += 1;
                matchmakingQueue.add(new Player(lastId));
            }

            System.out.println(players + " players were added to the queue");

            turn++;
            new java.util.Scanner(System.in).nextLine();
        } while (matchmakingQueue.getNumberOfPlayers() < 5);

        System.out.println("Game " + game + "\n");
        System.out.println("Active Players: ");
        for (int i = 0; i < 5; i++)
        {
            System.out.println(matchmakingQueue.remove());
        }

        matchmakingQueue.printQueue();
        game++;
    } while (game <= 10);

}
