//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Tree tree = new Tree();

    tree.insert(25);
    tree.insert(17);
    tree.insert(29);
    tree.insert(10);
    tree.insert(16);
    tree.insert(-5);
    tree.insert(60);
    tree.insert(55);

    tree.traverseInOrderDescending();
    System.out.println(tree.getMin());
    System.out.println(tree.getMax());
}
