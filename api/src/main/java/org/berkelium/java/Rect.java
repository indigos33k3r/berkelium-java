package org.berkelium.java;

public class Rect {

	public final int x;
	public final int y;
	public final int w;
	public final int h;

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public int left() {
		return x;
	}

	public int top() {
		return y;
	}

	public int right() {
		return x + w;
	}

	public int bottom() {
		return y + h;
	}

	public int width() {
		return w;
	}

	public int height() {
		return h;
	}

	public Rect translate(int i, int j) {
		return new Rect(x + i, y + j, w, h);
	}

	public Rect intersect(Rect rect) {
		int rx = Math.max(left(), rect.left());
		int ry = Math.max(top(), rect.top());
		int rr = Math.min(right(), rect.right());
		int rb = Math.min(bottom(), rect.bottom());
		if (rx >= rr || ry >= rb)
			rx = ry = rr = rb = 0; // non-intersecting
		return new Rect(rx, ry, rr - rx, rb - ry);
	}

	@Override
	public String toString() {
		return x + "x" + y + "/" + w + "x" + h;
	}
}