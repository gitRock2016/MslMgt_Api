package com.muscle.repository.entity;

import com.muscle.domain.Personal;

/**
 * DBのコード値から対応するドメインを返却する
 * @author rock
 *
 */
public class DBCode {
	// TODO DBのコード値はJava上はStringで管理したほうがよくない？intでもったからといってコード値同士で計算はしない
	// TODO あわせてテーブル定義の型もcharなどに変更したほうがいい気がする
	
	public static Personal.Sex getPersonalSex(int val){
		if(1==val) return Personal.Sex.Man;
		if(2==val) return Personal.Sex.Woman;
		throw new IllegalStateException("性別：コード値に定義されていない値です："+val);
	}
	public static Personal.Activitity getPersonalActivity(int val){
		if(0==val) return Personal.Activitity.Low;
		if(1==val) return Personal.Activitity.Normal;
		if(2==val) return Personal.Activitity.High;
		throw new IllegalStateException("アクティビティ：コード値に定義されていない値です："+val);
	}
}
