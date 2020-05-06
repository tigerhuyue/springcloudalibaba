package com.winsion.net.bootstrap.core.jpa;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.io.Serializable;

/**
 * Created by zhoucong on 2017/6/2.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    public BaseEntity() {
    }

    public static EntityManager session() {
        return EntityManagerHolder.getEntityManager();
    }

    public void delete() {
        session().remove(this);
    }

    @JSONField(serialize = false)
    @JsonIgnore
    public int getObjectId() {
        StoredProcedureQuery proc = session().createStoredProcedureQuery("createid");
        proc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
        proc.setParameter(1, this.getClass().getSimpleName());
        proc.execute();
        return Integer.parseInt(proc.getOutputParameterValue(2).toString());
    }
}
