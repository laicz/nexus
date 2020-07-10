package com.zhou.haizhi.nexus.base.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Create by zhoumingbing on 2020-05-22
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("60.205.135.176");
        System.out.println(inetAddress);
        boolean siteLocalAddress = inetAddress.isSiteLocalAddress();
        System.out.println(siteLocalAddress);
    }

}
