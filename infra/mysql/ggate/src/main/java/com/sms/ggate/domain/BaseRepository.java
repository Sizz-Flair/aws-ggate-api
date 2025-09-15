package com.sms.ggate.domain;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.impl.UpdatableRecordImpl;

public abstract class BaseRepository<R extends UpdatableRecordImpl<R>> {

    protected final DSLContext dsl;
    protected final Table<R> table;
    protected BaseRepository(DSLContext dsl, Table<R> table) {
        this.dsl = dsl;
        this.table = table;
    }
}
