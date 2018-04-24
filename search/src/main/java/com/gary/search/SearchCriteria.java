package com.gary.search;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class SearchCriteria {
	private String accountId;

	private String accountName;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public boolean isValid() {
		if (StringUtils.hasText(accountId))
			return !(StringUtils.hasText(accountName));
		else
			return (StringUtils.hasText(accountName));
	}

	public boolean validate(Errors errors) {
		if (StringUtils.hasText(accountId)) {
			if (accountId.length() != 9)
				errors.rejectValue("accountId", "badFormat",
						"Account number should be 9 digits");
			else {
				try {
					Integer.parseInt(accountId);
				} catch (NumberFormatException e) {
					errors.rejectValue("accountId", "badFormat",
							"Account number should be 9 digits");
				}
			}

			if (StringUtils.hasText(accountName)) {
				errors.rejectValue("accountName", "nonEmpty",
						"Cannot specify account number and search text");
			}
		} else if (StringUtils.hasText(accountName)) {
			; // Nothing to do
		} else {
			errors.rejectValue("accountId", "nonEmpty",
					"Must specify either an account number or search text");

		}

		return errors.hasErrors();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (StringUtils.hasText(accountId) ? "number: " + accountId
				: "")
				+ (StringUtils.hasText(accountName) ? " text: " + accountName
						: "");
	}
}
