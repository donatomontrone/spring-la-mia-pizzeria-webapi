package org.java.demo.pizzeria.auth.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@NotNull
	private String username;
	
	@NotBlank
	@NotNull
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	public User() {}
	public User(String username, String password, Role...roles) {
		setUsername(username);
		setPassword(password);
		setRoles(roles);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setRoles(Role[] roles) {
		setRoles(new HashSet<>(Arrays.asList(roles)));
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] - " + getUsername();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<GrantedAuthority> auths = new HashSet<>();
		
		for (Role role : getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return auths;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
