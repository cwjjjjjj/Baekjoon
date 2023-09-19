
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int sortedArr []; //매번 새로 만들지 말고 클래스변수로 선언하기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sortedArr = new int[arr.length];
		mergeSort(arr, 0, N-1);
		for(int a : arr) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	//분할 과정
	public static void mergeSort(int arr[], int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	//병합 과정
	public static void merge(int arr[], int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		//클래스변수로 선언된 배열에 크기만 지정해주는 선언법
		
		while(L <= mid && R <= right) {
			if(arr[L]<=arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for(int j = R; j <= right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}
}