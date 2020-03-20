public class Main{
public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while(read.hasNextLine()) {
            String r = read.nextLine();
            String[] boxs = r.split(" ");
            ArrayList<Character> A = new ArrayList<Character>();
            ArrayList<Character> B = new ArrayList<Character>();
            for(int i = 0; i < boxs[0].length(); i++) {
                A.add(boxs[0].charAt(i));
            }
            for(int i = 0; i < boxs[1].length(); i++) {
                B.add(boxs[1].charAt(i));
            }
            for(int i = 0; i < B.size(); i++) {
                if(A.contains(B.get(i))) {
                    A.remove(A.get(A.indexOf(B.get(i))));
                    B.remove(i);
                    i--;
                }
            }
            if(B.size() == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            A = null;
            B = null;
        }
    }
    