
package flow;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;


public class Tuition implements Serializable
{
    
    @Produces
    @FlowDefinition
    public Flow defineFlowOrientationOrAnythingYouWant(@FlowBuilderParameter FlowBuilder flowBuilder)
    {

        String flowId = "tuition";
        flowBuilder.id("", flowId);
        
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
        
       // flowBuilder.viewNode("sucsess-id", "/" + flowId + "/success.xhtml");

        flowBuilder.returnNode("taskFlowReturnCalculate").fromOutcome("/tuition/calculate");
                flowBuilder.viewNode("success-id", "/" + flowId + "/success.xhtml");

        flowBuilder.inboundParameter("firstNameParam", "#{flowScope.firstName}");
        flowBuilder.inboundParameter("lastNameParam", "#{flowScope.lastName}");
        flowBuilder.inboundParameter("hoursParam", "#{tuitionScope.hours}");

        return flowBuilder.getFlow();
    }   
}
