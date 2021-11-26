import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Inetaddress {
    @Test
    public void InetAdressTest() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLoopbackAddress();
        System.out.println(inetAddress);
        InetAddress[] baidu = InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.toString(baidu));
        byte[] bytes = {127,0,0,1};
        InetAddress byAddress = InetAddress.getByAddress(bytes);
        System.out.println(byAddress);

    }

}
