
import java.util.Scanner;

public class App {
    
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7,8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        SkipListSet<Integer> sls = new SkipListSet<>();
        sls.numLevel = 6;

        for (Integer integer : arr) {
            sls.add(integer);
        }

        sls.print();
        System.out.print("Nhap so ban muon xoa: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        sls.remove(a);
        
        sls.print();


    }
}
