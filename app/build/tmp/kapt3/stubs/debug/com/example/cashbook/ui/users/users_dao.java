package com.example.cashbook.ui.users;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/cashbook/ui/users/users_dao;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Landroid/database/sqlite/SQLiteDatabase;", "getDb", "()Landroid/database/sqlite/SQLiteDatabase;", "setDb", "(Landroid/database/sqlite/SQLiteDatabase;)V", "mysql", "Lcom/example/cashbook/DataBase/Mysql;", "getMysql", "()Lcom/example/cashbook/DataBase/Mysql;", "deleteUser", "", "username", "", "insertUser", "userpassword", "openDatebase", "queryUser", "", "queryUserbyID", "updateUser", "app_debug"})
public final class users_dao {
    @org.jetbrains.annotations.NotNull()
    private final com.example.cashbook.DataBase.Mysql mysql = null;
    public android.database.sqlite.SQLiteDatabase db;
    
    public users_dao(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.cashbook.DataBase.Mysql getMysql() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.database.sqlite.SQLiteDatabase getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase p0) {
    }
    
    public final void openDatebase() {
    }
    
    public final void insertUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String userpassword) {
    }
    
    public final boolean queryUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String userpassword) {
        return false;
    }
    
    public final boolean queryUserbyID(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return false;
    }
    
    public final void deleteUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String userpassword) {
    }
}