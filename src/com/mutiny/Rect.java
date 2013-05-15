package com.mutiny;

import java.util.ArrayList;
import processing.core.*;

public class Rect {

	public float x;
	public float y;
	public float w;
	public float h;

	public Rect (float x, float y, float w, float h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public PVector origin () {
		return new PVector(this.x, this.y);
	}

	public ArrayList<Rect> subdivide () {
		ArrayList<Rect> result = new ArrayList<Rect>();
		result.add(
			new Rect(
				(float)(this.x),
				(float)(this.y),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		result.add(
			new Rect(
				(float)(this.x + (this.w * 0.5)),
				(float)(this.y),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		result.add(
			new Rect(
				(float)(this.x),
				(float)(this.y + (this.h * 0.5)),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		result.add(
			new Rect(
				(float)(this.x + (this.w * 0.5)),
				(float)(this.y + (this.h * 0.5)),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		return result;
	}

	public String toString () {
		return "x: " + x + ", y: " + y + ", w: " + w + ", h: " + h;
	}

	boolean intersects (Rect b) {
		if ((this.y > b.y && this.y < b.y + b.h) || (b.y > this.y && b.y < this.y + this.h)) {
			return true;
		}
		return false;
	}

	boolean intersectsY (Rect b) {
		if (this.y > b.y && this.y < b.y + b.h) {
			return true;
		}
		if (b.y > this.y && b.y < this.y + b.h) {
			return true;
		}
		return false;
	}

	boolean intersectsX (Rect b) {
		if (this.x > b.x && this.x < b.x + b.w) {
			return true;
		}
		if (b.x > this.x && b.x < this.x + b.w) {
			return true;
		}
		return false;
	}
}
