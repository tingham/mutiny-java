package com.mutiny;

import processing.core.*;
import processing.core.PApplet;

public class Dot implements PConstants {
	public float r;
	public float g;
	public float b;
	public float a;
	public float power;
	public float x;
	public float y;

	public Dot (float r, float g, float b, float a, float power) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		this.power = power;
	}

	public Dot (float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Dot (float x, float y, float r, float g, float b, float a, float power) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		this.power = power;
	}

	public int Color () {
		this.r = (float)Math.max(0.0, Math.min(1.0, this.r));
		this.g = (float)Math.max(0.0, Math.min(1.0, this.g));
		this.b = (float)Math.max(0.0, Math.min(1.0, this.b));
		this.a = (float)Math.max(0.0, Math.min(1.0, this.a));

		int red = (int)this.r;
		int green = (int)this.g;
		int blue = (int)this.b;
		int alpha = (int)this.a;

		return  ((int)(Math.round(a * (0xFF))) << 24) |
			((int)(Math.round(r * (0xFF))) << 16) |
			((int)(Math.round(g * (0xFF))) << 8)  |
			((int)(Math.round(b * (0xFF))));
	}
}
