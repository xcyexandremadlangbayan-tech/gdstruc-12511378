import java.util.NoSuchElementException;

public class PlayerQueue {

    private Player[] queue;
    private int front;
    private int back;
    private int numberOfPlayers = 0;

    public PlayerQueue(int capacity)
    {
        queue = new Player[capacity];
    }

    public void add(Player player)
    {
        if (back == queue.length)
        {
            Player[] newQueue = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[back] = player;
        back++;
        numberOfPlayers++;
    }

    public  Player remove()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        Player removedPlayer =  queue[front];
        queue[front] = null;
        front++;
        numberOfPlayers--;

        if (size() == 0)
        {
            front = 0;
            back = 0;
            numberOfPlayers = 0;
        }

        return removedPlayer;
    }

    public Player peek()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size()
    {
        return back - front;
    }

    public int getNumberOfPlayers() {
        numberOfPlayers = 0;
        for (int i = front; i < back; i++)
        {
            if (queue[i] != null)
            {
                numberOfPlayers++;
            }
        }
        return numberOfPlayers;
    }

    public void printQueue()
    {
        System.out.println("\n" + "Game Queue: ");

        if (size() == 0)
        {
            System.out.println("Currently empty");
        }
        else
        {
            for (int i = front; i < back; i++)
            {
                System.out.println("Player " + queue[i].getId());
            }
        }
    }
}
