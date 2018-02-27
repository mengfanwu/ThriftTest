package mengfw.thrift.test.provider;

import mengfw.thrift.api.service.ThriftTestService;
import org.apache.thrift.TException;

public class ThriftTestServiceImpl implements ThriftTestService.Iface{


    @Override
    public String sayHello(String name) throws TException {
        return "hello " + name;
    }
}
