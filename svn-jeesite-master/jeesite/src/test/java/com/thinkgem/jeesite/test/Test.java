package com.thinkgem.jeesite.test;

import com.thinkgem.jeesite.modules.terminal.service.TicketInfoServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int number = 0;
//		number = Integer.parseInt(br.readLine());
//		double points[] = new double[number];
//		int count = 0;
//		while(count < number){
//			points[count++] = Double.parseDouble(br.readLine());
//		}
//		Arrays.sort(points);
//		int head = 0, tail = number-1;
//		double target = (double) 180;
//		double result = 0;
//		for(;head < number-1; head++) {
//			while (head < tail) {
//				double offset = points[tail] - points[head];
//				if (offset <= target) {
//					result = Math.max(result, offset);
//					break;
//				}
//				if (offset > target) {
//					result = Math.max(result, (double) (360 - offset));
//					tail--;
//				}
//			}
//			tail = number - 1;
//		}
//		System.out.println(result);
//	}
		public static void main(String[] args) {

			String mString = "ababbaababba";
			char[] arrs = mString.toCharArray();
			maxLength_d(arrs);
		}
	public static void maxLength_d(char[] arrs){
		int i,j,temp = 0,length=0;
		for(i=0;i<arrs.length;i++){
			for(j=i;j<arrs.length-1;j++){
				if(arrs[j]!=arrs[j+1]){
					if(j+1-i>length){
						length = j+1-i;
						temp=i;
					}
				}
				else{
					break;
				}
			}
		}
		if(length>0){
			for(i=0;i<length;i++){
				System.out.print(arrs[temp++]);
			}
		}
	}
}
