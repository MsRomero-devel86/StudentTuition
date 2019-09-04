
package beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.flow.FlowScoped;

/**
 *
 * @author Meghan
 */
@Named(value = "tuitionBean")
@FlowScoped(value = "tuition")
public class TuitionBean implements Serializable {

    private int hours;
    private int amount;

    public TuitionBean() {
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = (getHours() * 500);
    }

    public String getReturnValue() {
        return "/success";
    }
}
