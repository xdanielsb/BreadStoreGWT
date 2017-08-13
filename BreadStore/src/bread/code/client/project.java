package bread.code.client;

import bread.code.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class project implements EntryPoint {
 
  private static final String SERVER_ERROR = "An error occurred while ";
  private final ServiceAsync service = GWT.create(Service.class);

  public void onModuleLoad() {
    
    final Button sendButton = new Button("Send");
    final TextBox nameField = new TextBox();
    final Label errorLabel = new Label();

    RootPanel.get("name").add(nameField);
    RootPanel.get("send").add(sendButton);
    RootPanel.get("label").add(errorLabel);

    nameField.setFocus(true);
    nameField.selectAll();

    
    
    class DefaultCallBack implements AsyncCallback<String>{
      public void onFailure(Throwable caught) {
        // Show the RPC error message to the user
        errorLabel.setText("Remote Procedure Call - Failure");
      }

      @Override
      public void onSuccess(String result) {
        errorLabel.setText(result.toString());
      }
    }

    class MyHandler implements ClickHandler, KeyUpHandler {
      public void onClick(ClickEvent event) {
        sendNameToServer();
      }

      @Override
      public void onKeyUp(KeyUpEvent event) {
        // TODO Auto-generated method stub
        
      }
      private void sendNameToServer() {
        // First, we validate the input.
        errorLabel.setText("");
        String textToServer = nameField.getText();
        if (!FieldVerifier.isValidName(textToServer)) {
          errorLabel.setText("Please enter at least four characters");
          return;
        }  
        service.greetServer(textToServer, new DefaultCallBack());
      }

    }

    MyHandler handler = new MyHandler();
    sendButton.addClickHandler(handler);
  }
}
