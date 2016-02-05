package com.panda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "T_UPLOAD")
public class Upload implements Serializable {
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
	
	@Column(name = "TYPE")
	private String type; 
	
	@Column(name = "FILESIZE")
    private String size; 
	
	@Column(name = "PATH")
    private String path; 
	
    @Column(name = "ISDEL")
    private String isdel; 

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
     * 获取 type
     * @return 返回 type
     */
    public String getType()
    {
        return type;
    }

    /**
     * 设置 type
     * @param 对type进行赋值
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * 获取 size
     * @return 返回 size
     */
    public String getSize()
    {
        return size;
    }

    /**
     * 设置 size
     * @param 对size进行赋值
     */
    public void setSize(String size)
    {
        this.size = size;
    }

    /**
     * 获取 path
     * @return 返回 path
     */
    public String getPath()
    {
        return path;
    }

    /**
     * 设置 path
     * @param 对path进行赋值
     */
    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * 获取 isdel
     * @return 返回 isdel
     */
    public String getIsdel()
    {
        return isdel;
    }

    /**
     * 设置 isdel
     * @param 对isdel进行赋值
     */
    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }

    

	
	

}
