package kata.guava.exercise1;

public class Customer {

	private final static String INVALID_NAME = "";

	private final String firstName;
	private final String lastName;
	private final String nickName;

    /**
     * This is a typical constructor with basic checks of the parameters. Try to refactor it with the help of
     * {@link com.google.common.base.Preconditions}.
     *
     * Hint: With JDK7 you can replace the null checks with Objects#requireNonNull instead of
     * {@link com.google.common.base.Preconditions#checkNotNull(Object)}, but it has no equivalent for checking the
     * argument. So I would still prefer to use all checks from guava to avoid mixing several classes up.
     */
	public Customer(String firstName, String lastName, String nickName) {
		if (firstName == null) {
			throw new NullPointerException("firstName cannot be null");
		}
		if (INVALID_NAME.equals(firstName)) {
			throw new IllegalArgumentException("firstName cannot be empty");
		}
		if (lastName == null) {
			throw new NullPointerException("lastName cannot be null");
		}
		if (INVALID_NAME.equals(lastName)) {
			throw new IllegalArgumentException("lastName cannot be empty");
		}
		if (INVALID_NAME.equals(nickName)) {
			throw new IllegalArgumentException("nickName cannot be empty");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getPreferredName() {
		if (nickName != null) {
			return nickName;
		}
		return firstName;
	}

    /**
     * This is the way how a auto-generated hashCode method from an IDE looks like. Replace the code
     * with the help of {@link com.google.common.base.Objects#hashCode(Object...)}. This improves the readability
     * as you get rid of magic numbers and calculation.
     *
     * Hint: If you are using already JDK7, use the contained Objects#hash of the JDK instead.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

    /**
     * This is also an auto-generated method which is pretty hard to read as it is always a mix of null checks and
     * equality checks. Use {@link com.google.common.base.Objects#equal(Object, Object)} to improve it.
     *
     * Hint: Again, if you are using JDK 7, use the Objects#equals method in the JDK instead.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

    /**
     * Use {@link com.google.common.base.MoreObjects.ToStringHelper} to create the same output than below.
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder().append("Customer{").append("lastName=").append(lastName)
				.append(", firstName=").append(firstName);

		if (nickName != null) {
			builder.append(", nickName=").append(nickName);
		}

		builder.append("}");

		return builder.toString();
	}
}
