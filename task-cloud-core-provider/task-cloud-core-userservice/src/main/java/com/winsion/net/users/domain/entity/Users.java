package com.winsion.net.users.domain.entity;

import com.winsion.net.bootstrap.core.jpa.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
@Data
public class Users extends BaseEntity {



  
   
      @Id
      @Column(nullable = false, unique = true)
    private String  id=UUID.randomUUID().toString();
       

    @Column(name = "ctime")
	private Date ctime;

       

    @Column(name = "utime")
	private Date utime;

       

    @Column(name = "ver")
	private Integer ver;

       

    @Column(name = "organizationid")
	private String organizationid;

       

    @Column(name = "areaid")
	private String areaid;

       

    @Column(name = "username")
	private String username;

       

    @Column(name = "login")
	private Integer login;

       

    @Column(name = "loginip")
	private String loginip;

       

    @Column(name = "loginname")
	private String loginname;

       

    @Column(name = "logintime")
	private Date logintime;

       

    @Column(name = "starttime")
	private Date starttime;

       

    @Column(name = "endtime")
	private Date endtime;

       

    @Column(name = "password")
	private String password;

       

    @Column(name = "passwordsec")
	private String passwordsec;

       

    @Column(name = "status")
	private Integer status;

       

    @Column(name = "operatetime")
	private Date operatetime;

       

    @Column(name = "photo")
	private Byte[] photo;

       

    @Column(name = "siptelladdress")
	private String siptelladdress;

       

    @Column(name = "sippassword")
	private String sippassword;

       

    @Column(name = "usertype")
	private Integer usertype;

       

    @Column(name = "mmpuser")
	private String mmpuser;

       

    @Column(name = "mmpwd")
	private String mmpwd;

       

    @Column(name = "userlevel")
	private Integer userlevel;

       

    @Column(name = "delflag")
	private Integer delflag;

       

    @Column(name = "lastssid")
	private String lastssid;

       

    @Column(name = "device")
	private Integer device;

       

    @Column(name = "lasttimestamp")
	private Long lasttimestamp;

       

    @Column(name = "sort")
	private Integer sort;

       

    @Column(name = "photourl")
	private String photourl;

       

    @Column(name = "uareaame")
	private String uareaame;

    
    
    
   
}
        
    
    
    

    
    