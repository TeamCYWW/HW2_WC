// default package
// Generated 2014-5-25 23:12:04 by Hibernate Tools 3.4.0.CR1

package json;


public class User implements java.io.Serializable {

	private Integer uid;
	private String name;
	private String password;
	private String root;
	private Boolean alive;
	private String email;
	private String nickname;
	

	public User() {
	}

	public User(model.User user) {
		this.name = user.getName();
		this.password=user.getPassword();
		this.root = user.getRoot();
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.uid=user.getUid();
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

}
