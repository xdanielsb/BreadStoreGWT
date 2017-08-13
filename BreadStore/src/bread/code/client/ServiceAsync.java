package bread.code.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ServiceAsync {
  void greetServer(String input, AsyncCallback<String> callback)
      throws IllegalArgumentException;
  void sum_tw0_numbers(int a, int b, AsyncCallback<Integer> callback);
}
