package fresh.gui;

import burp.IHttpRequestResponse;
import burp.IHttpService;
import burp.IMessageEditorController;

public class MessageController implements IMessageEditorController {
    private final IHttpService service;
    byte[] request;
    byte[] response;

    MessageController(IHttpRequestResponse requestResponse) {
        // Sets one request/response view to a dedicated MessageController
        // If intention is to have many views
        // this is the wrong way to do it
        // Want to implement 1 controller with an update function based on selected object
        this.request = requestResponse.getRequest();
        this.response = requestResponse.getResponse();
        this.service = requestResponse.getHttpService();
    }


    // Default implementation of IMessageEditorController
    @Override
    public IHttpService getHttpService() {
        return this.service;
    }

    @Override
    public byte[] getRequest() {
        return this.request;
    }

    @Override
    public byte[] getResponse() {
        return this.response;
    }
}
