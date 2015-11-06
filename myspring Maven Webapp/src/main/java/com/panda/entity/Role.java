package com.panda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SYS_ROLE")
public class Role implements Serializable {
	
	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5022166439087501525L;

    @GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROLE_RID", unique = true, nullable = false, length = 38)
	
	private String roleRid;

	@Column(name="ROLE_CODE")
	private String roleCode;

	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;

	@Column(name="ROLE_IS_VALID")
	private String roleIsValid;

	@Column(name="ROLE_NAME")
	private String roleName;

	
	//bi-directional many-to-many association to SysMenu
    @ManyToMany
	@JoinTable(
		name="T_ROLE_MENU"
		, joinColumns={
			@JoinColumn(name="ROLE_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="MENU_ID")
			}
		)
	private List<Menu> menus;

	//bi-directional many-to-many association to SysUser
	@ManyToMany(mappedBy="roles")
	private List<User> users;

    public Role() {
    }

	public String getRoleRid() {
		return this.roleRid;
	}

	public void setRoleRid(String roleRid) {
		this.roleRid = roleRid;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleIsValid() {
		return this.roleIsValid;
	}

	public void setRoleIsValid(String roleIsValid) {
		this.roleIsValid = roleIsValid;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    /**
     * 获取 menus
     * @return 返回 menus
     */
    public List<Menu> getMenus()
    {
        return menus;
    }

    /**
     * 设置 menus
     * @param 对menus进行赋值
     */
    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }

    /**
     * 获取 users
     * @return 返回 users
     */
    public List<User> getUsers()
    {
        return users;
    }

    /**
     * 设置 users
     * @param 对users进行赋值
     */
    public void setUsers(List<User> users)
    {
        this.users = users;
    }

	
	
}