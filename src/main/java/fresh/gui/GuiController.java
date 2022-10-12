package fresh.gui;

import burp.IContextMenuInvocation;
import burp.IHttpRequestResponse;
import burp.IMessageEditor;
import burp.ITab;
import fresh.Fresh;
import fresh.gui.panels.MainGui;
import javax.swing.*;
import java.awt.*;

public class GuiController implements ITab {
    MainGui mainGui;

    public GuiController() {
        mainGui = new MainGui();
    }

    public void receiveInvocation(IContextMenuInvocation invocation) {
        IHttpRequestResponse[] requestResponseArray = invocation.getSelectedMessages();

        // More than one request can be selected, so must loop through them
        for (IHttpRequestResponse requestResponse: requestResponseArray) {

            MessageController messageController = new MessageController(requestResponse);

            // Setting the request
            IMessageEditor requestView = Fresh.callbacks.createMessageEditor(messageController, false);
            requestView.setMessage(requestResponse.getRequest(), true);

            // Setting the response
            IMessageEditor responseView = Fresh.callbacks.createMessageEditor(messageController, false);
            responseView.setMessage(requestResponse.getResponse(), false);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                    requestView.getComponent(),
                    responseView.getComponent());

            // JPanel to hold the splitpane, using borderlayout to fill the available space
            JPanel jpanel = new JPanel();
            jpanel.setLayout(new BorderLayout(2, 2));

            // Add the created splitpane with the requests and change resizeWeight to split at 50%
            // Resize must happen after panel add
            jpanel.add(splitPane);
            splitPane.setResizeWeight(0.5);

            this.mainGui.receivePanel(jpanel);
        }
    }

    // Default implementation of ITab
    @Override
    public String getTabCaption() {
        return "Fresh";
    }

    @Override
    public JPanel getUiComponent() {
        return this.mainGui.getMainPanel();
    }
}
