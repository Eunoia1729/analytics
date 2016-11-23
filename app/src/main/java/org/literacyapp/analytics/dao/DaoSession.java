package org.literacyapp.analytics.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import org.literacyapp.analytics.model.UsageEvent;

import org.literacyapp.analytics.dao.UsageEventDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig usageEventDaoConfig;

    private final UsageEventDao usageEventDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        usageEventDaoConfig = daoConfigMap.get(UsageEventDao.class).clone();
        usageEventDaoConfig.initIdentityScope(type);

        usageEventDao = new UsageEventDao(usageEventDaoConfig, this);

        registerDao(UsageEvent.class, usageEventDao);
    }
    
    public void clear() {
        usageEventDaoConfig.clearIdentityScope();
    }

    public UsageEventDao getUsageEventDao() {
        return usageEventDao;
    }

}
