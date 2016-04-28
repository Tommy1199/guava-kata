package kata.guava.exercise1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenFirstNameIsNull() {
        new Customer(null, "Mann", "Pit");
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenLastNameIsNull() {
        new Customer("Peter", null, "Pit");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenFirstNameIsEmpty() {
        new Customer("", "Mann", "Pit");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenLastNameIsEmpty() {
        new Customer("Peter", "", "Pit");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNickNameIsEmpty() {
        new Customer("Peter", "Mann", "");
    }

    @Test
    public void shouldAddAllCustomerInfoToString() {
        Customer customer = new Customer("Peter", "Mann", "Pit");
        assertThat(customer.toString()).isEqualTo("Customer{lastName=Mann, firstName=Peter, nickName=Pit}");
    }

    @Test
    public void shouldIgnoreNickNameIfNullInToString() {
        Customer customer = new Customer("Peter", "Mann", null);
        assertThat(customer.toString()).isEqualTo("Customer{lastName=Mann, firstName=Peter}");
    }

    @Test
    public void shouldReturnNickNameAsPreferredNameWhenNotNull() {
        Customer customer = new Customer("Peter", "Mann", "Pit");
        assertThat(customer.getPreferredName()).isEqualTo("Pit");
    }

    @Test
    public void shouldReturnFirstNameAsPreferredNameWhenNickNameIsNull() {
        Customer customer = new Customer("Peter", "Mann", null);
        assertThat(customer.getPreferredName()).isEqualTo("Peter");
    }

    @Test
    public void shouldOnlyTakeFirstNameAndLastNameForHashing() {
        Set<Customer> customers = new HashSet<Customer>();
        customers.add(new Customer("Peter", "Mann", "Pit"));
        customers.add(new Customer("Peter", "Mann", null));
        assertThat(customers.size()).isEqualTo(1);
    }

    @Test
    public void shouldIgnoreNickNameForEquality() {
        Customer customerWithNickName = new Customer("Peter", "Mann", "Pit");
        Customer customerWithoutNickname = new Customer("Peter", "Mann", null);
        assertThat(customerWithNickName).isEqualTo(customerWithoutNickname);
    }
}
