package com.panda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "T_USER")
public class User implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2384280866394066599L;

	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", length = 38)
	private String id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password; 
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="T_USER_ROLE"
        , joinColumns={
            @JoinColumn(name="PERSON_ID")
            }
        , inverseJoinColumns={
            @JoinColumn(name="ROLE_RID")
            }
        )
    private List<Role> roles;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    /**
     * 获取 password
     * @return 返回 password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * 设置 password
     * @param 对password进行赋值
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * 获取 roles
     * @return 返回 roles
     */
    public List<Role> getRoles()
    {
        return roles;
    }

    /**
     * 设置 roles
     * @param 对roles进行赋值
     */
    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }
	
	

}
