package kata.guava.exercise1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;

import org.junit.Test;

public class CustomerTest {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerWhenFirstNameIsNull() {
		new Customer(null, "Maier", "Pit");
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerWhenLastNameIsNull() {
		new Customer("Peter", null, "Pit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenFirstNameIsEmpty() {
		new Customer("", "Maier", "Pit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenLastNameIsEmpty() {
		new Customer("Peter", "", "Pit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenNickNameIsEmpty() {
		new Customer("Peter", "Maier", "");
	}

	@Test
	public void shouldAddAllCustomerInfoToString() {
		Customer customer = new Customer("Peter", "Maier", "Pit");
		assertThat(customer.toString(), is("Customer{lastName=Maier, firstName=Peter, nickName=Pit}"));
	}

	@Test
	public void shouldIgnoreNickNameIfNullInToString() {
		Customer customer = new Customer("Peter", "Maier", null);
		assertThat(customer.toString(), is("Customer{lastName=Maier, firstName=Peter}"));
	}

	@Test
	public void shouldReturnNickNameAsPreferredNameWhenNotNull() {
		Customer customer = new Customer("Peter", "Maier", "Pit");
		assertThat(customer.getPreferredName(), is("Pit"));
	}

	@Test
	public void shouldReturnFirstNameAsPreferredNameWhenNickNameIsNull() {
		Customer customer = new Customer("Peter", "Maier", null);
		assertThat(customer.getPreferredName(), is("Peter"));
	}

	@Test
	public void shouldOnlyTakeFirstNameAndLastNameForHashing() {
		HashSet<Customer> customers = new HashSet<>();
		customers.add(new Customer("Peter", "Maier", "Pit"));
		customers.add(new Customer("Peter", "Maier", null));
		assertThat(customers.size(), is(1));
	}

	@Test
	public void shouldIgnoreNickNameForEquality() {
		Customer customerWithNickName = new Customer("Peter", "Maier", "Pit");
		Customer customerWithoutNickname = new Customer("Peter", "Maier", null);
		assertThat(customerWithNickName.equals(customerWithoutNickname), is(true));
	}
}
