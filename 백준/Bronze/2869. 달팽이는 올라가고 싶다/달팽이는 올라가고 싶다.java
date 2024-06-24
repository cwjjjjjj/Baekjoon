
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//나무 막대의 높이는 V
		//낮에 A미터 올라가고 밤에 B미터 떨어진다
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		//하루에 올라가는 거리는 A-B
		//But!! 정상에 올라가면 안 미끄러진다

//		int day = 0;
//		while(V>0) {
//			day++;
//			V -= A;
//			if(V>0) {
//				V += B;				
//			}
//		}
		
		int day = (V-B) / (A-B);
		if((V-B) % (A-B) != 0) day++;
		System.out.println(day);
	}
}