package beans;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named (value = "registrationBean")
@FlowScoped(value = "registration")
public class RegistrationBean implements Serializable
{

    private String firstName;
    private String lastName;
    private String street; 
    private String city;
    private String zip;
    private int hours;
    private int amount;

    public RegistrationBean()
    {
    }
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getAmount() {
        amount = this.getHours() * 500;
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    

    public String getReturnValue()
    {
        return "/done";
    }

    public String registrationAction()
    {
        boolean makeRegistrationFail = false;

        if (makeRegistrationFail )
          {
            firstName = "";
            lastName = "";
            street = "";
            city = "";
            zip = "";
            hours = 0;
            amount= 0;
            FacesContext.getCurrentInstance().addMessage("type of message", 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration failed!", ""));
            return "registration";
          }
        else
          {
            return "confirm";
          }
    }


}
