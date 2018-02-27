package mengfw.thrift.test.provider;

import mengfw.thrift.api.service.ThriftTestService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Main {
    public static void main(String[] args) {
        try {
            TServerSocket serverTransport = new TServerSocket(1234);
            ThriftTestService.Processor processor = new ThriftTestService.Processor(new ThriftTestServiceImpl());
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);
            TThreadPoolServer.Args arg = new TThreadPoolServer.Args(serverTransport);
            arg.processor(processor);
            arg.protocolFactory(portFactory);
            TServer server = new TThreadPoolServer(arg);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
