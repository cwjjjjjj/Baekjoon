
import java.util.*;

public class Main {

	public static void main(String[] args) {

		//N개의 수를 가진 배열에서 M개의 수가 있으면 1, 없으면 0 출력
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		Arrays.sort(arr);
		
		for(int i = 0; i < M; i++) {
			int key = sc.nextInt();
			System.out.println(binarySearch(arr, key));
		}
		
	}

	private static int binarySearch(int[] arr, int key) {
		int start = 0;
		//length에서 1 빼주지 않으면 인덱스 꼬임...!!!
		int end = arr.length - 1;
		
		// < 아니고 <= 이 되어야 함
		// start == end 인 경우는 검사 안 하고 넘어가게 됨
		
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] == key) return 1;
			if(arr[middle] < key) start = middle + 1;
			if(arr[middle] > key) end = middle - 1;
		}
		return 0;
	}

}
