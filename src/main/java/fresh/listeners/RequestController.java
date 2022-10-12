package fresh.listeners;

import burp.IHttpListener;
import burp.IHttpRequestResponse;
import burp.IRequestInfo;
import fresh.Fresh;

import java.util.List;

public class RequestController implements IHttpListener {
    public RequestController() {
        // Registering Request Controller
    }

    // Default implementation of IHttpListener
    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {
        if(messageIsRequest){
            byte[] newRequest = HeaderManipulation.changeHeaders(messageInfo);
            messageInfo.setRequest(newRequest);
        }
        else {
            // HTTPMessage was response
        }

    }
}
