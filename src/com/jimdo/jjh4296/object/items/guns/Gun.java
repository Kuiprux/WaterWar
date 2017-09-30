package com.jimdo.jjh4296.object.items.guns;

import com.jimdo.jjh4296.object.items.Item;

public class Gun extends Item {
	
	public final int maxBullet;
	public final int bullet;
	public final int coolTime;
	public final int damage;

	public Gun(String name, int maxBullet, int bullet, int coolTime, int damage) {
		super(name);
		this.maxBullet = maxBullet;
		this.bullet = bullet;
		this.coolTime = coolTime;
		this.damage = damage;
	}
}
