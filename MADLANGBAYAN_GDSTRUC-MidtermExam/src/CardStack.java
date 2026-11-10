import java.util.EmptyStackException;

public class CardStack {
    private Card[] stack;
    private int top;
    private String name;
    private int numberOfCards = 0;

    public Card[] getStack()
    {
        return stack;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CardStack(int capacity, String name)
    {
        stack = new Card[capacity];
        this.name = name;
    }

    public void push(Card card)
    {
        if (top == stack.length)
        {
            Card[] newStack = new Card[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = card;
    }

    public Card pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        Card poppedCard = stack[--top];
        stack[top] = null;
        return poppedCard;
    }

    public Card peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isEmpty()
    {
        return top == 0;
    }

    public int getNumberOfCards()
    {
        numberOfCards = 0;
        for (int i = top - 1; i >= 0; i--)
        {
            if (stack[i] != null)
            {
                numberOfCards++;
            }
        }
        return numberOfCards;
    }

    public void printStack()
    {
        System.out.println("Current " + name + ": ");

        if (isEmpty())
        {
            System.out.println("Currently empty");
        }
        else
        {
            for (int i = top - 1; i >= 0; i--)
            {
                System.out.println(stack[i].getName());
            }
        }
    }
}
