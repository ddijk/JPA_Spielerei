/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.jpa;

import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Dick
 */
@Model
public class AccountBacking {

	@Inject
	AccountSessionBean accountSessionBean;

	/**
	 * Creates a new instance of AccountBacking
	 */
	public AccountBacking() {
	}

	int accountId;
	String name;
	int measureId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void saveAccount() {
		accountSessionBean.createAccount(new UserAccount(accountId, name));
	}

	public void saveAccountMeasureLink() {
		UserAccount ua = accountSessionBean.findAccount(accountId);
		ua.getMetingen().add(accountSessionBean.findMeting(measureId));
		accountSessionBean.updateAccount(ua);
	}

	public List<Meting> getAllMetingen() {
		return accountSessionBean.getAllMetingen();
	}

	public List<UserAccount> getAllAccounts() {
		return accountSessionBean.getAllAccounts();
	}

	public int getMeasureId() {
		return measureId;
	}

	public void setMeasureId(int measureId) {
		this.measureId = measureId;
	}

}
