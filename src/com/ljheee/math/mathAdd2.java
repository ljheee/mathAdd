package com.ljheee.math;

import java.util.ArrayList;

public class mathAdd2 {
	public static byte[] Add(byte[] aa, byte[] bb) {
			//�ѵ�һ��ֵ���aa
			System.out.println("��һ��ֵ");
			for (int i = 0; i < aa.length; i++) {
				aa[i] = (byte) (aa[i] - '0');
				System.out.print(aa[i]);
			}
			System.out.println();
			//�ѵڶ���ֵ���bb
			System.out.println("�ڶ���ֵ");
			for (int i = 0; i < bb.length; i++) {
				bb[i] = (byte) (bb[i] - '0');
				
				System.out.print(bb[i]);
			}
			System.out.println();
			byte[] cc = new byte[Math.max(aa.length, bb.length)];
			for (int i = 0; i < cc.length; i++) {
				cc[i] = 0;
			}
			
			//���϶̵Ĵ浽cc��ת������ͬ���ȡ�ǰ���0
			ArrayList<Byte> dd = new ArrayList<Byte>();
			int length = Math.min(aa.length, bb.length);
			if (aa.length > length) {
				int x = aa.length - length;
				for (int i = 0; i < bb.length; i++) {
					cc[x] = bb[i];
					x++;
				}
				System.out.println("ת�����ֵ1");
				for (int i = 0; i < cc.length; i++) {
					System.out.print(cc[i]);
				}
				System.out.println();
				dd = add1(aa, cc);
			} else if (bb.length > length) {
				int x = bb.length - length;
				for (int i = 0; i < aa.length; i++) {
					cc[x] = aa[i];
					x++;
				}
				System.out.println("ת�����ֵ2");
				for (int i = 0; i < cc.length; i++) {
					System.out.print(cc[i]);
				}
				System.out.println();
				dd = add1(bb, cc);
			} else {
				System.out.println("ת�����ֵ3");
				dd = add1(aa, bb);
			}
			byte[] ee = new byte[dd.size()];
			int j = 0;
			for (int i = ee.length - 1; i >= 0; i--) {
				ee[j] = dd.get(i);
				j++;
			}
			return ee;
	}
	//���,���Ŵ������������
	private static ArrayList<Byte> add1(byte[] aa, byte[] bb) {
		ArrayList<Byte> list = new ArrayList<Byte>();
		for (int i = aa.length - 1; i >= 0; i--) {
			list.add((byte) (aa[i] + bb[i]));
		}
		int jinwei;
		for (int j = 0; j < list.size(); j++) {
			jinwei = j + 1;
			if (list.get(j) >= 10) {
				list.set(j, (byte) (list.get(j) % 10));
				if (jinwei < list.size()) {
					list.set(jinwei, (byte) (list.get(jinwei) + 1));
				} else {
					list.add((byte) 1);
				}

			}
		}
		return list;
	}
}
