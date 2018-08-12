package com.key.util;

import java.sql.Timestamp;
import java.time.Instant;

public class CommonUtils {

	
	public static Timestamp getCurrentTimestamp() {
		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		Timestamp  currentTimestamp = new Timestamp(timeStampMillis);
		return currentTimestamp;
	}
	
}
