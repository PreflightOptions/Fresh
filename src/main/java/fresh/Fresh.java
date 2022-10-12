package fresh;

import burp.IBurpExtender;
import burp.IBurpExtenderCallbacks;
import burp.IExtensionHelpers;
import fresh.gui.ContextMenuFactory;
import fresh.gui.GuiController;
import fresh.utilities.Logger;

import javax.swing.*;

public class Fresh implements IBurpExtender {
    public static IBurpExtenderCallbacks callbacks;
    public static IExtensionHelpers helpers;
    public static GuiController guiController;

    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        Fresh.callbacks = callbacks;
        Logger.log("Loading Fresh...");

        Fresh.helpers = callbacks.getHelpers();
        Fresh.callbacks.setExtensionName("Fresh");

        Logger.log("Adding GUI tab");
        SwingUtilities.invokeLater(() -> {
            Fresh.guiController = new GuiController();
            Fresh.callbacks.addSuiteTab(Fresh.guiController);
        });

        Logger.log("Registering context menu");
        Fresh.callbacks.registerContextMenuFactory(new ContextMenuFactory());
        Logger.log("Fresh loaded, be fresh");
    }
}
