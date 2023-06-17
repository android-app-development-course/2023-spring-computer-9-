package com.example.cashbook.DataBase;

import java.lang.System;

@androidx.room.Database(entities = {com.example.cashbook.DataBase.MyDatabase.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/example/cashbook/DataBase/DatabaseAction;", "Landroidx/room/RoomDatabase;", "()V", "getAllIncomesDao", "Lcom/example/cashbook/DataBase/DatabaseLists;", "getGetAllIncomesDao", "()Lcom/example/cashbook/DataBase/DatabaseLists;", "clearAllTables", "", "Companion", "app_debug"})
public abstract class DatabaseAction extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cashbook.DataBase.DatabaseAction.Companion Companion = null;
    private static final java.lang.String DB_NAME = "MyDatabase.db";
    @kotlin.jvm.Volatile()
    private static volatile com.example.cashbook.DataBase.DatabaseAction instance;
    
    public DatabaseAction() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.cashbook.DataBase.DatabaseLists getGetAllIncomesDao();
    
    @java.lang.Override()
    public void clearAllTables() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/cashbook/DataBase/DatabaseAction$Companion;", "", "()V", "DB_NAME", "", "instance", "Lcom/example/cashbook/DataBase/DatabaseAction;", "create", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.Synchronized()
        public final synchronized com.example.cashbook.DataBase.DatabaseAction getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.example.cashbook.DataBase.DatabaseAction create(android.content.Context context) {
            return null;
        }
    }
}