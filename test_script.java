// KeyScript Sample - Message Box + Refresh UI + SOAP Request

// Function to display a message to the user
CR.Script.messageKeyStone({
    message: "Welcome to KeyStone! This script executed successfully.",
    messageType: "info",  // Can be 'info', 'warning', or 'error'
    closeScriptPanel: false
});

// Function to refresh the UI components after the message is shown
CR.Script.messageKeyStone({
    refreshComponents: true,
    closeScriptPanel: true
});

// Simulated SOAP Request (Replace 'soapEndpoint' and XML payload with real values)
function sendSOAPRequest() {
    const soapEndpoint = "https://your-soap-endpoint.com/Service";
    const soapAction = "http://example.com/GetInfo";
    const xmlPayload = `
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                          xmlns:web="http://example.com/service">
            <soapenv:Header/>
            <soapenv:Body>
                <web:GetInfo>
                    <web:ID>12345</web:ID>
                </web:GetInfo>
            </soapenv:Body>
        </soapenv:Envelope>`;

    // Send the SOAP request
    CR.Script.sendRequest({
        url: soapEndpoint,
        method: "POST",
        headers: {
            "Content-Type": "text/xml; charset=utf-8",
            "SOAPAction": soapAction
        },
        body: xmlPayload,
        onSuccess: function(response) {
            CR.Script.messageKeyStone({
                message: "SOAP Request Successful!",
                messageType: "info"
            });
        },
        onFailure: function(error) {
            CR.Script.messageKeyStone({
                message: "SOAP Request Failed: " + error,
                messageType: "error"
            });
        }
    });
}

// Trigger the SOAP request
sendSOAPRequest();
