package com.android.oz.hotv2ex.http;

/**
 * @author O.z Young
 * @date 16/9/16
 * @desc 这里保存着V2EX公开的API
 */
public class V2EX {

    /**
     * V2EX前缀
     */
    public static final String API_BASE_URL = "https://www.v2ex.com/api/";

    /**
     * 最新话题
     */
    public static final String API_LATEST = API_BASE_URL + "topics/latest.json";

    /**
     * 获取所有节点信息
     */
    public static final String API_ALL_NODE = API_BASE_URL + "nodes/all.json";

    /**
     * 获取回复的信息
     */
    public static final String API_REPLIES = API_BASE_URL + "replies/show.json";

    /**
     * 获取话题详细内容
     */
    public static final String API_TOPIC = API_BASE_URL + "topics/show.json";

    /**
     * 获取会员信息
     */
    public static final String API_USER = API_BASE_URL + "members/show.json";

}
