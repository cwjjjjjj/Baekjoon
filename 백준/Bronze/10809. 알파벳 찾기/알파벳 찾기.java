
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] arr = new int[S.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = S.charAt(i);
		} //단어 철자를 아스키코드로 배열에 저장
		
		int[] where = new int[26]; //있는지 없는지 여부+있다면 어디있는지
		Arrays.fill(where, -1); //안 쓰였으면 -1
		for (int i = 0; i < arr.length; i++) { //단어 길이만큼 검사
			int alph = arr[i]-97; // alph=0은 a, 2는 b...
			if(where[alph] == -1 && arr[i] != 0) { //이미 들어있는 경우 냅둔다
				where[alph] = i;
			}
		}
		for (int i : where) {
			System.out.print(i+" ");
		}
		
	}
}