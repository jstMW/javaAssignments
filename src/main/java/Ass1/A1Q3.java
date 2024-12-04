Package Ass1;
public class A1Q3 {
    public static void main(String[] args) {
        EntityList<Integer> enemy = new EntityList<>();

        for (int i=0; i<100; i++) {
            enemy.addLast(i);
        }

        for (int i=0; i<100; i++) {
            if (enemy.updateAll()) {
                break;
            } else {
                System.out.println("the size is --> " + enemy.size());
            }
        }
        System.out.println("Player hit!");
    }
}
