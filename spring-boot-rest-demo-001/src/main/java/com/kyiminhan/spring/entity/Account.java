package com.kyiminhan.spring.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kyiminhan.spring.types.AccountLock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccountLock accountLock;

	@Column(nullable = false)
	private int loginAttempt;

	@Column(nullable = false)
	private LocalDateTime loginDt;

	@Column(nullable = false)
	private LocalDateTime passwordExpiredDt;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = AccountPassword.class)
	@JsonManagedReference
	private Set<AccountPassword> passwords;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = AccountAuthority.class)
	@JsonManagedReference
	private Set<AccountAuthority> authorities;

	@Builder
	public Account(final Long id, final String firstName, final String lastName, final String email,
			final String password, final AccountLock accountLock, final int loginAttempt, final LocalDateTime loginDt,
			final LocalDateTime passwordExpiredDt, final Set<AccountPassword> passwords,
			final Set<AccountAuthority> authorities) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountLock = accountLock;
		this.loginAttempt = loginAttempt;
		this.loginDt = loginDt;
		this.passwordExpiredDt = passwordExpiredDt;
		this.passwords = passwords;
		this.authorities = authorities;
	}
}