/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dick
 */
@Stateless
public class AccountSessionBean {

	@PersistenceContext
	EntityManager em;

	public void createAccount(UserAccount acc) {
		em.persist(acc);
	}

	public List<UserAccount> getAllAccounts() {
		return em.createQuery("select a from UserAccount a", UserAccount.class).getResultList();
	}

	public List<Meting> getAllMetingen() {
		return em.createQuery("select m from Meting m").getResultList();
	}

	public UserAccount findAccount(int accId) {
		return em.find(UserAccount.class, accId);
	}

	public Meting findMeting(int mId) {
		return em.find(Meting.class, mId);
	}

	public void updateAccount(UserAccount ua) {
		em.merge(ua);
	}
}
