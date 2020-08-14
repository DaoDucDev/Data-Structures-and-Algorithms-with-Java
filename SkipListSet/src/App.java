
public class App {

    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

        SkipListSet<Integer> sls = new SkipListSet<>();
        sls.numLevel = 6;

        for (Integer integer : arr) {
            sls.add(integer);
            //sls.numElement++;
        }

        System.out.println("===========SKIP LIST SET============");
        System.out.println("Size of skip list set is " + sls.size());

        sls.print();
        // System.out.println();
        System.out.println();

        System.out.println("ITERATE THROUGH ELEMENTS");
        SkipListIterator<Integer> iterator = (SkipListIterator<Integer>) sls.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nREMOVE 12, 2, 0");
        System.out.println("REMOVING 12");
        sls.remove(12);
        sls.print();

        System.out.println();
        System.out.println("REMOVING 2");
        if(sls.contains(2)){
            sls.remove(2);
        }
        sls.print();

        if (sls.contains(0) == false) {
            System.out.println("Didn't remove 0, cause not in the list");
        }

        // REMOVE 19, 29, 12

        System.out.println("ADDING 2");
        sls.add(2);
        sls.print();

    }
}
