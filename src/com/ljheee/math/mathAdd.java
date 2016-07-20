package com.ljheee.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class mathAdd {
	public static void main(String[] args) {
		Add();
	}

	private static void Add() {
		try (BufferedReader in = new BufferedReader(new FileReader(new File("word.txt")));) {
			String a = in.readLine();
			String b = in.readLine();
			byte[] aa = a.getBytes();
			byte[] bb = b.getBytes();

			for (int i = 0; i < aa.length; i++) {
				aa[i] = (byte) (aa[i] - '0');
				System.out.print(aa[i]);
			}
			System.out.println();
			for (int i = 0; i < bb.length; i++) {
				bb[i] = (byte) (bb[i] - '0');
				System.out.print(bb[i]);
			}
			System.out.println();
			byte[] cc = new byte[Math.max(aa.length, bb.length)];
			for (int i = 0; i < cc.length; i++) {
				cc[i] = 0;
			}
			
			
			int length = Math.min(aa.length, bb.length);
			if (aa.length > length) {
				int x = aa.length - length;
				for (int i = 0; i < bb.length; i++) {
					cc[x] = bb[i];
					x++;
				}
				for (int i = 0; i < cc.length; i++) {
					System.out.print(cc[i]);
				}
				System.out.println();
				add1(aa, cc);
			} else if (bb.length > length) {
				int x = bb.length - length;
				for (int i = 0; i < aa.length; i++) {
					cc[x] = aa[i];
					x++;
				}
				for (int i = 0; i < cc.length; i++) {
					System.out.print(cc[i]);
				}
				System.out.println();
				add1(bb, cc);
			} else {
				add1(aa, bb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void add1(byte[] aa, byte[] bb) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = aa.length - 1; i >= 0; i--) {
			list.add(aa[i] + bb[i]);
		}
		int jinwei;
		for (int j = 0; j < list.size(); j++) {
			jinwei = j + 1;
			if (list.get(j) >= 10) {
				list.set(j, list.get(j) % 10);
				if (jinwei < list.size()) {
					list.set(jinwei, list.get(jinwei) + 1);
				} else {
					list.add(1);
				}

			}
		}
		for (int j = list.size() - 1; j >= 0; j--) {
			System.out.print(list.get(j));
		}
	}
}
