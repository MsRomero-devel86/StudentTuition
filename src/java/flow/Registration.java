package flow;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class Registration implements Serializable
{
    @Produces 
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder)
    {
        String flowId = "registration";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
        flowBuilder.viewNode("confirm-id", "/" + flowId + "/confirm.xhtml");
        flowBuilder.viewNode("thanks-id", "/" + flowId + "/thanks.xhtml");

        flowBuilder.returnNode("taskFlowReturnCalculate").fromOutcome("/tuition/calculate");
        flowBuilder.returnNode("taskFlowReturnIndex").fromOutcome("/index");
        flowBuilder.returnNode("taskFlowReturnDone").fromOutcome("#{registrationBean.returnValue}");
        

        flowBuilder.flowCallNode("callOrientation").flowReference("", "orientation").
                outboundParameter("firstNameParam", "#{registrationBean.firstName}").
                outboundParameter("lastNameParam", "#{registrationBean.lastName}").
                outboundParameter("studentRegistrationCode", "A1FS");

        return flowBuilder.getFlow();
    }
}
