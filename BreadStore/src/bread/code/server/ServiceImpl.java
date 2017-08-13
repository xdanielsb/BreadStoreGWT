package bread.code.server;

import bread.code.client.Service;
import bread.code.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ServiceImpl extends RemoteServiceServlet implements Service {

  public String greetServer(String input) throws IllegalArgumentException {
    // Verify that the input is valid. 
    return "Hello " + input;
  }

  @Override
  public Integer sum_tw0_numbers(int a, int b) {
    // TODO Auto-generated method stub
    return a+b;
  }

}
