package com.mutiny;

import java.util.ArrayList;

public class MRect {
	float x;
	float y;
	float w;
	float h;

	public MRect (float x, float y, float w, float h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public ArrayList<MRect> subdivide () {
		ArrayList<MRect> result = new ArrayList<MRect>();
		result.add(
			new MRect(
				(float)(this.x),
				(float)(this.y),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		result.add(
			new MRect(
				(float)(this.x + (this.w * 0.5)),
				(float)(this.y),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		result.add(
			new MRect(
				(float)(this.x),
				(float)(this.y + (this.h * 0.5)),
				(float)(this.w * 0.5),
				(float)(this.h * 0.5)
			)
		);

		result.add(
			new MRect(
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

	boolean intersects (MRect b) {
		if ((this.y > b.y && this.y < b.y + b.h) || (b.y > this.y && b.y < this.y + this.h)) {
			return true;
		}
		return false;
	}

	boolean intersectsY (MRect b) {
		if (this.y > b.y && this.y < b.y + b.h) {
			return true;
		}
		if (b.y > this.y && b.y < this.y + b.h) {
			return true;
		}
		return false;
	}

	boolean intersectsX (MRect b) {
		if (this.x > b.x && this.x < b.x + b.w) {
			return true;
		}
		if (b.x > this.x && b.x < this.x + b.w) {
			return true;
		}
		return false;
	}
}
