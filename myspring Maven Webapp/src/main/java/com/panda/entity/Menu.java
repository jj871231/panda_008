package com.panda.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="SYS_MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Menu implements Serializable {

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = -899507948699528723L;

    @GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MENU_ID", unique = true, nullable = false, length = 38)
	
	private String menuId;

    @Column(name="ICON")
	private String icon;

	@Column(name="MENU_IS_VALID")
	private String menuIsValid;

	@Column(name="MENU_TEXT")
	private String menuText;

	@Column(name="MENU_URL")
	private String menuUrl;

	@Column(name="REMARK")
	private String remark;

	@Column(name="SORT")
	private String sort;

    @ManyToOne
	@JoinColumn(name="PARENT_ID")
	private Menu menu;

	//bi-directional many-to-one association to SysMenu
	@OneToMany(mappedBy="menu",cascade=CascadeType.ALL)
	private List<Menu> menus;


	//bi-directional many-to-many association to SysRole
	@ManyToMany(mappedBy="menus")
	private Set<Role> roles;

    public Menu() {
    }

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getMenuIsValid() {
		return this.menuIsValid;
	}

	public void setMenuIsValid(String menuIsValid) {
		this.menuIsValid = menuIsValid;
	}

	public String getMenuText() {
		return this.menuText;
	}

	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}


	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

    /**
     * 获取 menu
     * @return 返回 menu
     */
    public Menu getMenu()
    {
        return menu;
    }

    /**
     * 设置 menu
     * @param 对menu进行赋值
     */
    public void setMenu(Menu menu)
    {
        this.menu = menu;
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
     * 获取 roles
     * @return 返回 roles
     */
    public Set<Role> getRoles()
    {
        return roles;
    }

    /**
     * 设置 roles
     * @param 对roles进行赋值
     */
    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }
	

    
	
}