//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Player asuna = new Player(1, "Asuna", 100);
    Player lethalBacon = new Player(2, "LethalBacon", 205);
    Player hpDeskjet = new Player(3, "HPDeskjet", 34);

    PlayerLinkedList playerLinkedList = new PlayerLinkedList();

    playerLinkedList.addToFront(asuna);
    playerLinkedList.addToFront(lethalBacon);
    playerLinkedList.addToFront(hpDeskjet);

    System.out.println(playerLinkedList.indexOf(asuna));
}
