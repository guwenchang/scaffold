package com.smart.auth.center.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author guwenchang
 * @date 2019-06-14
 */
public class IpUtils {

    /**
     * 获取IP
     *
     * @return ip
     */
    public static String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}