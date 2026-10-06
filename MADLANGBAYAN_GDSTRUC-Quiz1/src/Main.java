//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    int[] numbers = new int[10];

    numbers[0] = 35;
    numbers[1] = 69;
    numbers[2] = 1;
    numbers[3] = 10;
    numbers[4] = -50;
    numbers[5] = 320;
    numbers[6] = 63;
    numbers[7] = 58;
    numbers[8] = 26;
    numbers[9] = 13;

    System.out.println("Before sorting:");
    printElements(numbers);

    reverseDescendingSelectionSort(numbers);

    System.out.println("\n\nAfter sorting:");
    printElements(numbers);
}

//Original code for Bubble Sort

private static void bubbleSort(int[] arr)
{
    for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
    {
        for (int i = 0; i < lastSortedIndex; i++)
        {
            if (arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}

//Item 1-1 (Done) - Modify the BubbleSort to sort arrays in descending order

private static void descendingBubbleSort(int[] arr)
{
    for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
    {
        for (int i = 0; i < lastSortedIndex; i++)
        {
            if (arr[i+1] > arr[i])
            {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }
    }
}

//Original code for Selection Sort

private static void selectionSort(int[] arr)
{
    for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
    {
        int largestIndex = 0;

        for (int i = 1; i <= lastSortedIndex; i++)
        {
            if (arr[i] > arr[largestIndex])
            {
                largestIndex = i;
            }
        }

        int temp = arr[lastSortedIndex];
        arr[lastSortedIndex] = arr[largestIndex];
        arr[largestIndex] = temp;
    }
}

//Item 1-2 - Modify the SelectionSort to sort arrays in descending order

private static void descendingSelectionSort(int[] arr)
{
    for (int lastSortedIndex = 0; lastSortedIndex < arr.length - 1; lastSortedIndex++)
    {
        int largestIndex = arr.length - 1;

        for (int i = largestIndex - 1; i >= lastSortedIndex; i--)
        {
            if (arr[i] > arr[largestIndex])
            {
                largestIndex = i;
            }
        }

        int temp = arr[largestIndex];
        arr[largestIndex] = arr[lastSortedIndex];
        arr[lastSortedIndex] = temp;
    }
}

/*Item 2 - Modify the Selection Sort to look for the smallest value first
           and put it at the end instead of looking for the largest
           and putting it in the beginning. (Done)*/

private static void reverseDescendingSelectionSort(int[] arr)
{
    for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
    {
        int smallestIndex = 0;

        for (int i = 1; i <= lastSortedIndex; i++)
        {
            if (arr[i] < arr[smallestIndex])
            {
                smallestIndex = i;
            }
        }

        int temp = arr[lastSortedIndex];
        arr[lastSortedIndex] = arr[smallestIndex];
        arr[smallestIndex] = temp;
    }
}

private static void printElements(int[] arr)
{
    for (int j : arr) {
        System.out.print(j + " ");
    }
}
