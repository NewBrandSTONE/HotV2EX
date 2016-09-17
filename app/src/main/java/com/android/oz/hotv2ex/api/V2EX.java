package com.android.oz.hotv2ex.api;

/**
 * @author O.z Young
 * @date 16/9/16
 * @desc 这里保存着V2EX公开的API
 */
public class V2EX {

    public static final String API_BASE_URL = "https://www.v2ex.com/api/";
    public static final String API_LATEST = API_BASE_URL + "topics/latest.json";
    public static final String API_ALL_NODE = API_BASE_URL + "nodes/all.json";
    public static final String API_REPLIES = API_BASE_URL + "replies/show.json";
    public static final String API_TOPIC = API_BASE_URL + "topics/show.json";
    public static final String API_USER = API_BASE_URL + "members/show.json";

}
