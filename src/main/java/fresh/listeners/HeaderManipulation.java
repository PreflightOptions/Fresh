package fresh.listeners;

import burp.IHttpRequestResponse;
import burp.IRequestInfo;
import fresh.Fresh;

import java.util.Arrays;
import java.util.List;

public class HeaderManipulation {
    public static byte[] changeHeaders(IHttpRequestResponse messageInfo) {
        byte[] request = messageInfo.getRequest();
        IRequestInfo analyzed = Fresh.helpers.analyzeRequest(request);
        List<String> reqHeaders = analyzed.getHeaders();
        reqHeaders.add("Test: test");

        return Fresh.helpers.buildHttpMessage(
                reqHeaders,
                Arrays.copyOfRange(request, analyzed.getBodyOffset(), request.length));
    }

}
