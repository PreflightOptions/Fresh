package fresh.gui;

import burp.IContextMenuFactory;
import burp.IContextMenuInvocation;
import fresh.Fresh;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ContextMenuFactory implements IContextMenuFactory {
    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        // List of available Menu's to return to Burp UI based on context
        List<JMenuItem> menuList = new ArrayList<>();

        byte context = invocation.getInvocationContext();

        // Make sure right click is from proxy history
        // If right click is not from proxy history, burp will not show the menu item
        if (context == IContextMenuInvocation.CONTEXT_PROXY_HISTORY) {
            JMenuItem menu = new JMenuItem("Send Proxy Items to Fresh");

            // Action to trigger on selecting "menu"
            menu.addActionListener((e) -> {
                //Send invocation to controller to start building req/resp panels
                Fresh.guiController.receiveInvocation(invocation);
            });
            menuList.add(menu);
        }

        return menuList;
    }
}
