package com.ljheee.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class mathCheng {
	public static void main(String[] args) {
		cheng();
	}
	private static void cheng() {
		try (BufferedReader in = new BufferedReader(new FileReader(new File("word.txt")))) {
			String a = in.readLine();
			String b = in.readLine();
			byte[] aa = a.getBytes();
			byte[] bb = b.getBytes();
			ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
			int x;
			int y;	
			int z = 0;
			for (int i = 0; i < aa.length; i++) {
				for (int j = 0; j < bb.length; j++) {
					list.add(new StringBuilder().append((aa[i] - '0') * (bb[j] - '0') + ""));
					//计算0的个数
					x = aa.length - 1 - i;
					y = bb.length - 1 - j;
					for (int k = 0; k < x + y; k++) {
						list.get(z).append("0");
					}
					z++;
				}
			}
			//调用加法，将list求和
			byte[] ff = new byte[list.size()];
			String str = "0";
			byte[] ee = str.getBytes();
			for (int i = 0; i < ee.length; i++) {
				ee[i] = (byte) (ee[i]);
			}
			for (int i = 0; i < list.size(); i++) {
				ff = list.get(i).toString().getBytes();
				for (int j = 0; j < ff.length; j++) {
					ff[j] = (byte) (ff[j]);
				}

				ee = mathAdd2.Add(ee, ff);//????
				for (int j = 0; j < ee.length; j++) {
					ee[j] = (byte) (ee[j] + '0');
				}
				System.out.println("结果1");
				for (int j = 0; j < ee.length; j++) {
					System.out.print(ee[j] - '0');
				}
			}
			System.out.println();
			System.out.println("结果");
			for (int i = 0; i < ee.length; i++) {
				System.out.print(ee[i] - '0');
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
