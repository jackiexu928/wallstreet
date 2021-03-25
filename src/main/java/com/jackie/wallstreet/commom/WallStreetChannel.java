package com.jackie.wallstreet.commom;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 要闻，A股，美股，港股，外汇，商品
 *
 * @author xujj
 * @date 2021/3/24
 */
public enum WallStreetChannel {
    GLOBAL("要闻", "global-channel"), A_STOCK("A股", "a-stock-channel");
    private String name;
    private String channel;

    WallStreetChannel(String name, String channel) {
        this.name = name;
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public String getChannel() {
        return channel;
    }
}
