package com.pp.idgenerater;

import java.util.UUID;

public class RandomIDGenerator {

	public static String IDGenerator() {
		System.out.println("randomIdGenerater is called");
		return UUID.randomUUID().toString().substring(0, 10);
}
}
