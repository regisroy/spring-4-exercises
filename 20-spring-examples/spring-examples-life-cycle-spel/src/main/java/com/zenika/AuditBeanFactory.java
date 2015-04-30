package com.zenika;

import com.zenika.bean.AuditBean;
import org.springframework.beans.factory.FactoryBean;

public class AuditBeanFactory implements FactoryBean<AuditBean> {


    @Override
    public AuditBean getObject() throws Exception {
        AuditBean auditBean = new AuditBean();
        auditBean.setMessage("c'est un essai, on verra bien !");
        return auditBean;
    }

    @Override
    public Class<?> getObjectType() {
        return AuditBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}