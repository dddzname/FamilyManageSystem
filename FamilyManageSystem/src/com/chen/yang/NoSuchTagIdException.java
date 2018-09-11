package com.chen.yang;

public class NoSuchTagIdException extends Exception {
	int tagId;

	public NoSuchTagIdException(int tagId) {
		this.tagId = tagId;
	}

	public int getTagId() {
		return tagId;
	}
}
