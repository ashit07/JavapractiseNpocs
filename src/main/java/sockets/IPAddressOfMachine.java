package sockets;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressOfMachine {
  public static void main(String[] args) {
    try {
      InetAddress IP = InetAddress.getLocalHost();
      System.out.println("Ip is " + IP.getHostAddress());
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
