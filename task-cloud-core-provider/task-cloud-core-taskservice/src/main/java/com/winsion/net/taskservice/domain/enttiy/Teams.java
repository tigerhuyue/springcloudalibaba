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
@Table(name = "teams")
@DynamicInsert
@DynamicUpdate
@Data
public class Teams  extends  BaseEntity   {





    @Id
    @Column(nullable = false, unique = true)
    private String  teamid=UUID.randomUUID().toString();


    @Column(name = "ctime")
    private Date ctime;



    @Column(name = "utime")
    private Date utime;



    @Column(name = "ver")
    private Integer ver;



    @Column(name = "postid")
    private String postid;



    @Column(name = "name")
    private String name;



    @Column(name = "talkgroupid")
    private String talkgroupid;



    @Column(name = "delflag")
    private Integer delflag;



    @Column(name = "sort")
    private Integer sort;



    @Column(name = "linkphone")
    private String linkphone;


    @Column(name="shift")
    private String shift;


}


