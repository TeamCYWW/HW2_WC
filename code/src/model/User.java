// default package
// Generated 2014-5-25 23:12:04 by Hibernate Tools 3.4.0.CR1

package model;


import java.util.HashSet;
import java.util.Set;


public class User implements java.io.Serializable {

	private Integer uid;
	private String name;
	private String password;
	private String root;
	private Boolean alive;
	private String email;
	private String nickname;
	private Set orderses = new HashSet(0);

	public User() {
	}

	public User(String name,String password, String root, String email, String nickname) {
		this.name = name;
		this.password=password;
		this.root = root;
		this.email = email;
		this.nickname = nickname;
		this.alive=true;
	}

	public User(String name,String password, String root,Boolean alive,
			String email, String nickname) {
		this.name = name;
		this.password=password;
		this.root = root;
		this.email = email;
		this.nickname = nickname;
		this.alive=alive;
	}

	
	public User(String name, String password, String root, Boolean alive,
			String email, String nickname, Set orderses, Set orderdetailses) {
		this.name = name;
		this.password = password;
		this.root = root;
		this.alive = alive;
		this.email = email;
		this.nickname = nickname;
		this.orderses = orderses;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoot() {
		return this.root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public Boolean getAlive() {
		return this.alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}


}
