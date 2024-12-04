Package Ass1;
import java.util.Random;
public class EntityList<Integer> extends DoublyLinkedList<Integer>{
    private boolean checkRemove(Node<Integer> n) {
        Random rand = new Random();
        return rand.nextInt(20)==0; //since it will number 0 int 1/20 chance!
    }
    private boolean checkCollided(Node<Integer> n) {
        Random rand = new Random();
        return rand.nextInt(500)==0;
    }
    public boolean updateAll() {
        boolean flag = false;
        Node<Integer> node = header;
        for(int i=0; i<size; i++) {
            node = node.getNext();
            if (checkRemove(node)) {
                remove(node);
            } else if (checkCollided(node)) {
                flag = true;
            }
        }
        return flag;
    }

}
