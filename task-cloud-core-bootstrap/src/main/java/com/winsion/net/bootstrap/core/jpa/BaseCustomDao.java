package com.winsion.net.bootstrap.core.jpa;


import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.persistence.*;
import java.util.*;
/**
 * Created by zhoucong on 2017/6/6.
 */
public class BaseCustomDao {
    @PersistenceContext
    protected EntityManager em;

    @SuppressWarnings("unchecked")
    protected <R> List<R> getResultList(Class<R> clazz, String sql, Object... args) {
        Query query = em.createNativeQuery(sql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i + 1, args[i]);
        }

        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return mapResultList(clazz, query.getResultList());
    }

    protected  Object getResultSingleObject(String sql)
    {
        Query query = em.createNativeQuery(sql);
        return query.getSingleResult();
    }

    private static ConcurrentHashMap<Class, PropertyDescriptor[]> propertyDescriptorMap = new ConcurrentHashMap<>();

    private static PropertyDescriptor[] getPropertyDescriptors(Class clazz) {
        if (!propertyDescriptorMap.containsKey(clazz)) {
            propertyDescriptorMap.put(clazz, BeanUtils.getPropertyDescriptors(clazz));
        }
        return propertyDescriptorMap.get(clazz);
    }

    private <R> R mapResult(Class<R> clazz, Map<String, Object> map) {
        R inst = null;
        try {
            inst = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        for (PropertyDescriptor propertyDescriptor : getPropertyDescriptors(clazz)) {
            if (map.containsKey(propertyDescriptor.getName())) {
                try {
                    propertyDescriptor.getWriteMethod().invoke(inst, map.get(propertyDescriptor.getName()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            if (map.containsKey(propertyDescriptor.getName().toLowerCase())) {
                try {
                    propertyDescriptor.getWriteMethod().invoke(inst, map.get(propertyDescriptor.getName().toLowerCase()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return inst;
    }

    private <R> List<R> mapResultList(Class<R> clazz, List<Map<String, Object>> maps) {
        List<R> result = new ArrayList<>();
        maps.forEach(map -> result.add(mapResult(clazz, map)));
        return result;
    }

     /**
     * 通用查询类
     * @param clazz
     * @param fields
     * @param where
     * @param orderBy
     * @param pageIndex
     * @param pageSize
     * @param sumFields
     * @param <R>
     * @return
     */
    public <R> PagedResult<R> mapQueryResult(Class<R> clazz, String fields,String where,String orderBy,Integer pageIndex,Integer pageSize ,String sumFields) {
        //String tablename=  clazz.getSimpleName();
        Table annotation = clazz.getAnnotation(Table.class);
        String tablename = annotation.name();
        StoredProcedureQuery proc = em.createStoredProcedureQuery("Query_Pagination");
        proc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(9, Integer.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter(10, Integer.class, ParameterMode.OUT);
        proc.setParameter(1, fields);
        proc.setParameter(2, tablename);
        proc.setParameter(3, where);
        proc.setParameter(4, orderBy);
        proc.setParameter(5, pageIndex);
        proc.setParameter(6, pageSize);
        proc.setParameter(7, sumFields);
        proc.setParameter(8, "");
        Integer rowscount = new Integer(proc.getOutputParameterValue(9).toString()).intValue();
        Integer pagecount = new Integer(proc.getOutputParameterValue(10).toString()).intValue();
        List result = proc.getResultList();
        List<R> classList = listResult(clazz, result);
        return new PagedResult<R>(classList, pageIndex, pageSize, pagecount);
    }

    public <R>  HashMap<String,Object>  customMmapQueryResult(Class<R> clazz, String fields,String where,String orderBy,Integer pageIndex,Integer pageSize ,String sumFields,String groupFields) {
        List<HashMap<String, Object>> mapList = new ArrayList<HashMap<String, Object>>();
        Table annotation = clazz.getAnnotation(Table.class);
        String tablename = annotation.name();
        StoredProcedureQuery proc = em.createStoredProcedureQuery("Query_Pagination");
        proc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter(9, Integer.class, ParameterMode.OUT);
        proc.registerStoredProcedureParameter(10, Integer.class, ParameterMode.OUT);
        proc.setParameter(1, fields);
        proc.setParameter(2, tablename);
        proc.setParameter(3, where);
        proc.setParameter(4, orderBy);
        proc.setParameter(5, pageIndex);
        proc.setParameter(6, pageSize);
        proc.setParameter(7, sumFields);
        proc.setParameter(8, groupFields);
        Integer rowscount = new Integer(proc.getOutputParameterValue(9).toString()).intValue();
        Integer pagecount = new Integer(proc.getOutputParameterValue(10).toString()).intValue();
        String[] fds = fields.split(",");
        String[]newfds=new String[fds.length];
        for(int i=0;i<fds.length;i++)
        {
            if(fds[i].contains(" as "))
            {
                String[]temp=fds[i].split(" as ");
                newfds[i]=temp[1].trim();
            }
            else
            {
                newfds[i]=fds[i];
            }
        }
        List result = proc.getResultList();
        List<HashMap<String, Object>> resultList = gainResultList(result, newfds);
        HashMap<String, Object> hmap = new HashMap<>();
        hmap.put("pagecount", pagecount);
        hmap.put("rowcount", rowscount);
        hmap.put("data", resultList);
        return hmap;
    }

    public <R>  HashMap<String,Object>  customMmapQueryResult(Class<R> clazz, String fields,String where,String orderBy,Integer pageIndex,Integer pageSize ,String sumFields)
    {
        return  customMmapQueryResult(clazz, fields, where, orderBy, pageIndex, pageSize, sumFields,"");

    }

    public  List<HashMap<String,Object>> gainResultList(List list, String[]fds){
        List<HashMap<String,Object>> mapList=new ArrayList<HashMap<String,Object>>();
        Iterator it=list.iterator();
        while(it.hasNext()) {
            HashMap map = new HashMap();
            Object[] row= (Object[]) it.next();
            for (int i = 0; i < fds.length; i++) {
                map.put(fds[i],row[i]==null?null: row[i].toString());
            }
            mapList.add(map);
        }
        return mapList;
    }

    /**
     *
     * @param clazz
     * @param list
     * @param <R>
     * @return
     */
 public  <R> List<R>  listResult(Class<R> clazz, List list) {
        R inst = null;
        Iterator it=list.iterator();
        List<R> result = new ArrayList<>();
        while(it.hasNext())
        {
            Object[] row= (Object[])it.next();
            try {
                inst = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            Field[]fields= inst.getClass().getDeclaredFields();
            for(int i=0;i<fields.length;i++)
            {
                try {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fields[i].getName(),clazz);
                    propertyDescriptor.getWriteMethod().invoke(inst, row[i]);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                }
            }
            result.add(inst);
        }
        return result;
    }


    public <R> HashMap<String,Object>  hashMapResult(Class<R> clazz, List list) {
        R inst = null;
        Iterator it=list.iterator();
        HashMap<String,Object> hashMap=new HashMap<>();
        while(it.hasNext())
        {
            Object[] row= (Object[])it.next();
            Field[]fields= inst.getClass().getDeclaredFields();
            for(int i=0;i<fields.length;i++)
            {
                hashMap.put(fields[i].getName(),row[i]);
            }
        }
        return hashMap;
    }



}
