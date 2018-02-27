package mengfw.thrift.test.consumer;

import mengfw.thrift.api.service.ThriftTestService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Consumer {

    public static void main(String[] args) {
        TTransport transport;
        try {
            transport = new TSocket("localhost", 1234);
            TProtocol protocol = new TBinaryProtocol(transport);
            ThriftTestService.Client client = new ThriftTestService.Client(protocol);
            transport.open();
            String mengfanwu = client.sayHello("mengfanwu");
            System.out.println(mengfanwu);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
