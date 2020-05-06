package com.winsion.net.taskservice.domain.enttiy;

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
@Table(name = "areas")
@DynamicInsert
@DynamicUpdate
@Data
public class Areas extends BaseEntity {


    @Id
    @Column(nullable = false, unique = true)
    private String areaid = UUID.randomUUID().toString();


    @Column(name = "ctime")
    private Date ctime;


    @Column(name = "utime")
    private Date utime;


    @Column(name = "ver")
    private Integer ver;


    @Column(name = "number")
    private Integer number;


    @Column(name = "delflag")
    private Integer delflag;


    @Column(name = "distinction")
    private Integer distinction;


    @Column(name = "level")
    private Integer level;


    @Column(name = "areaname")
    private String areaname;


    @Column(name = "ssid")
    private String ssid;


    @Column(name = "parentid")
    private String parentid;


    @Column(name = "areatypeid")
    private String areatypeid;


    @Column(name = "area_capacity")
    private Integer areaCapacity;


    @Column(name = "warning_line")
    private Integer warningLine;


    @Column(name = "ordernumber")
    private Integer ordernumber;


    @Column(name = "countflag")
    private Integer countflag;


    @Column(name = "signposition")
    private String signposition;

}
