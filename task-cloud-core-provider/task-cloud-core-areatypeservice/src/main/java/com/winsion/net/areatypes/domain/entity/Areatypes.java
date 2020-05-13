package com.winsion.net.areatypes.domain.entity;

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
@Table(name = "areatypes")
@DynamicInsert
@DynamicUpdate
@Data
public class Areatypes extends BaseEntity {



  
   
      @Id
      @Column( name = "areatypeid",nullable = false, unique = true)
    private String  areatypeid=UUID.randomUUID().toString();
       

    @Column(name = "ctime")
	private Date ctime;

       

    @Column(name = "utime")
	private Date utime;

       

    @Column(name = "ver")
	private Integer ver;

       

    @Column(name = "typename")
	private String typename;

       

    @Column(name = "cut")
	private Integer cut;

       

    @Column(name = "typeno")
	private Integer typeno;

       

    @Column(name = "delflag")
	private Integer delflag;

    
    
    
   
}
        
    
    
    

    
    