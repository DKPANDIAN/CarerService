package com.uniquecaterer.service.rest.constant;

public final class Constants {
	
	public Constants() {
		throw new IllegalAccessError("Constants :: Unreachable class to get instance");
	}

	
	public static final String API_COMMON_ENDPOINT_PREFIX="/api/vi";
	public static final String API_SAVE_CATERER_ENDPOINT="/caterers/save";
	public static final String API_FIND_CATERER_ENDPOINT="/caterers/{id}";
	public static final String API_FINDBYCITYNAME_CATERER_ENDPOINT="/caterers/findByCityName";
	
}
