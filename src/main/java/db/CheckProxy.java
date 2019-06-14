package db;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

public class CheckProxy {

  public static void main(String[] args) {
    try {

      System.setProperty("java.net.useSystemProxies", "true");
      List l = ProxySelector.getDefault().select(
          new URI("https://repo1.maven.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/"));

      for (Iterator iter = l.iterator(); iter.hasNext();) {

        Proxy proxy = (Proxy) iter.next();

        System.out.println("proxy hostname : " + proxy.type());

        InetSocketAddress addr = (InetSocketAddress) proxy.address();

        if (addr == null) {

          System.out.println("No Proxy");

        } else {

          System.out.println("proxy hostname : " + addr.getHostName());

          System.out.println("proxy port : " + addr.getPort());

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
