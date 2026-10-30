public class PlayerLinkedList {
    private PlayerNode head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize() {
        size = 0;
        PlayerNode current = head;
        while (current != null) {
            size++;
            current =  current.getNextPlayer();
        }
    }

    public boolean contains(Player player) {
        PlayerNode node = new PlayerNode(player);
        return contains(node);
    }

    public boolean contains(PlayerNode node) {
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(node.getPlayer())){
                return true;
            }
            current =  current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player) {
        PlayerNode node = new PlayerNode(player);
        return indexOf(node);
    }

    public int indexOf(PlayerNode node) {
        int index = 0;

        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(node.getPlayer())) {
                return index;
            }
            current =  current.getNextPlayer();
            index++;
        }

        return -1;
    }

    public void addToFront(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size += 1;
    }

    public void removeFirstElement() {
        PlayerNode element = head;
        head = head.getNextPlayer();
        element.setNextPlayer(null);
        size -= 1;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current =  current.getNextPlayer();
        }
        System.out.println("null");
    }
}
