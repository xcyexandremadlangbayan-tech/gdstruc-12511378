//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    System.out.println("Input the value to find: ");
    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();

    int[] numbers = {5, 5, 4, 5, 4, 4, 1, 2, 5, 5, 1, 5, 1, 4, 5, 4, 1, 1, 2, 3};
    duplicateSearch(numbers, value);
}

public static void duplicateSearch(int[] dataSet, int value)
{
    int[] positions = new int[5];
    int instances = 0;

    for (int i = 0; i < dataSet.length; i++)
    {
        if (instances == positions.length) //in case there are more instances than assumed
        {
            int[] newArray = new int[positions.length * 2];
            System.arraycopy(positions, 0, newArray, 0, positions.length);
            positions = newArray;
        }

        if (dataSet[i] == value)
        {
            instances++;
            positions[instances - 1] = i + 1; //stores the positions
        }
    }

    //prints the results of the search
    System.out.println("\nThe dataset contains " + instances + " instances of " + value);

    if (instances != 0) //prints positions if instances were found
    {
        System.out.println("\nLocated Positions: ");

        for (int i = 0; i < positions.length; i++)
        {
            if (positions[i] != 0) //ensures no empty slots in the array are printed
            {
                System.out.println(i + 1 + " - " + positions[i]);
            }
        }
    }
}
