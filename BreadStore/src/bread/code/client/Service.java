package bread.code.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface Service extends RemoteService {
 public String greetServer(String name) throws IllegalArgumentException;
 public  Integer sum_tw0_numbers(int a, int b); 
}
