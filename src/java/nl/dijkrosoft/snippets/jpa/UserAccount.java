/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dick
 */
@Entity
@Table(name = "ACCOUNT")
public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "ACCOUNT_ID")
	private Integer accountId;
	@Size(max = 20)
        @Column(name = "NAME")
	private String name;

	public UserAccount() {
	}




	@ManyToMany
	@JoinTable(name = "MEAS_ACC", joinColumns = @JoinColumn(name = "ACC_ID", referencedColumnName = "ACCOUNT_ID"), inverseJoinColumns = @JoinColumn(name = "M_ID", referencedColumnName = "ID"))
	List<Meting> metingen;


	public UserAccount(int account_id, String name) {
		this.accountId = account_id;
		this.name = name;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public List<Meting> getMetingen() {
		return metingen;
	}

	public void setMetingen(List<Meting> metingen) {
		this.metingen = metingen;
	}
	
	

	
}
