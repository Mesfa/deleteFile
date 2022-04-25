package com.socket.Net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class TestDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        InetAddress addr = InetAddress.getByName("www.baidu.com");
        String HostName = addr.getHostName();
        String IP = addr.getHostAddress();
        System.out.println(HostName);
        System.out.println(IP);
        InetAddress addr1 = InetAddress.getLoopbackAddress();
        System.out.println(addr1);
        //获取所有接口

        try {
//            Enumeration iface = NetworkInterface.getNetworkInterfaces();//接口中不允许创建实例，使用循环打印
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces();ifaces.hasMoreElements();){
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
//                String strInterIface = iface.getDisplayName();
//                System.out.println(strInterIface);
                final String strInterface = iface.getName();
                for (Enumeration inetaddress = iface.getInetAddresses();inetaddress.hasMoreElements();){
                    InetAddress inet = (InetAddress)  inetaddress.nextElement();
                    System.out.println(inet);
                    /*
                    /fe80:0:0:0:c953:5291:61c2:b1f%utun5
                     /fe80:0:0:0:61d9:6fee:645e:32fd%utun4
                        /fe80:0:0:0:d2a3:4060:ab9b:2cc1%utun3
                        /fe80:0:0:0:ce81:b1c:bd2c:69e%utun2
                        /fe80:0:0:0:333b:c776:6eea:fd64%utun1
                        /fe80:0:0:0:1ae:dce8:5dfe:620c%utun0
                        /fe80:0:0:0:fc2d:e6ff:fef9:d0e7%llw0
                        /fe80:0:0:0:fc2d:e6ff:fef9:d0e7%awdl0
                        /fe80:0:0:0:acdb:12ff:fe2a:8d5e%anpi0
                        /fe80:0:0:0:acdb:12ff:fe2a:8d5f%anpi1
                        /fe80:0:0:0:acdb:12ff:fe2a:8d60%anpi2
                        /fd49:d9d6:4dc8:0:18df:e897:5bbc:573d%en0
                        /fe80:0:0:0:1ce7:1538:f079:a7ff%en0
                        /10.1.2.190
                        /fe80:0:0:0:0:0:0:1%lo0
                        /0:0:0:0:0:0:0:1%lo0
                        /127.0.0.1
                     */
                    if (inet instanceof Inet4Address){
                        String strIp = inet.getHostAddress();
                        System.out.printf("%-10s %-5s %-6s %-15s\n",
                            "InterfaceName",
                            strInterface,
                            "Ipv4",
                            strIp);
                    }
                    else {
                        String strIp = inet.getHostAddress();
                        System.out.printf("%-10s %-5s %-6s %-20s\n",
                            "InterfaceName",
                            strInterface,
                            "Ipv6",
                            strIp);
                        byte[] ip = inet.getAddress();
                    }
                }
                //根据名称获取IP
//               if (iface instanceof Inet4Address){}
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
