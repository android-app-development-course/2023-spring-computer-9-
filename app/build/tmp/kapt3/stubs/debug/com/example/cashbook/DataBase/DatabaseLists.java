package com.example.cashbook.DataBase;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J(\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J%\u0010\r\u001a\u00020\u00032\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\'\u00a2\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001a\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001a\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J2\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J(\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J(\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J%\u0010$\u001a\u00020\u00032\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\'\u00a2\u0006\u0002\u0010\u0011JL\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\t2\b\u0010\'\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H\'J%\u0010.\u001a\u00020\u00032\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\'\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006/"}, d2 = {"Lcom/example/cashbook/DataBase/DatabaseLists;", "", "DeleteAll", "", "usrname", "", "dayIn", "", "y", "", "m", "d", "dayOut", "delete", "incomes", "", "Lcom/example/cashbook/DataBase/MyDatabase;", "([Lcom/example/cashbook/DataBase/MyDatabase;)V", "getAllAccounts", "", "getAllExpense", "getAllIn", "getAllIncomes", "getAllOut", "getDayExpense", "getDayI", "getDayMax", "getDayMin", "getDayO", "getMonthI", "getMonthMax", "getMonthMin", "getMonthO", "getNumTran", "getYearMax", "getYearMin", "insert", "search", "io", "type", "fn", "tn", "yy", "mm", "allDt", "", "update", "app_debug"})
public abstract interface DatabaseLists {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM MyDatabase where (username = :usrname) ORDER BY year DESC,month DESC,day DESC,id DESC")
    public abstract java.util.List<com.example.cashbook.DataBase.MyDatabase> getAllAccounts(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM MyDatabase WHERE ((not inOut) and (username = :usrname)) ORDER BY year DESC,month DESC,day DESC,id DESC")
    public abstract java.util.List<com.example.cashbook.DataBase.MyDatabase> getAllIncomes(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM MyDatabase where (inOut and (username = :usrname)) ORDER BY year DESC,month DESC,day DESC,id DESC")
    public abstract java.util.List<com.example.cashbook.DataBase.MyDatabase> getAllExpense(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM MyDatabase where (:io=0 or (inOut and :io=1) or (not inOut and :io=2)) and (:type=\'\u6240\u6709\u7c7b\u522b\' or :type=type) and (money>=:fn and money<=:tn) and ((year=:yy and month=:mm) or :allDt)  ORDER BY year DESC,month DESC,day DESC,id DESC")
    public abstract java.util.List<com.example.cashbook.DataBase.MyDatabase> search(int io, @org.jetbrains.annotations.Nullable()
    java.lang.String type, long fn, long tn, int yy, int mm, boolean allDt);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM MyDatabase WHERE (year=:y and month=:m and day=:d and inOut) and (username = :usrname)")
    public abstract java.util.List<com.example.cashbook.DataBase.MyDatabase> getDayExpense(int y, int m, int d, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and not inOut) and (username = :usrname)")
    public abstract long dayIn(int y, int m, int d, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and inOut) and (username = :usrname)")
    public abstract long dayOut(int y, int m, int d, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and not inOut) and (username = :usrname)")
    public abstract long getMonthI(int y, int m, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and inOut) and (username = :usrname)")
    public abstract long getMonthO(int y, int m, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and not inOut) and (username = :usrname)")
    public abstract long getDayI(int y, int m, int d, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and inOut) and (username = :usrname)")
    public abstract long getDayO(int y, int m, int d, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (not inOut) and (username = :usrname)")
    public abstract long getAllIn(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT sum(money) FROM MyDatabase where (inOut) and (username = :usrname)")
    public abstract long getAllOut(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT max(year) FROM MyDatabase where (username = :usrname)")
    public abstract int getYearMax(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT max(month) FROM MyDatabase where (year=:y) and (username = :usrname)")
    public abstract int getMonthMax(int y, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT max(day) FROM MyDatabase where (year=:y and month=:m) and (username = :usrname)")
    public abstract int getDayMax(int y, int m, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT min(year) FROM MyDatabase where (username = :usrname)")
    public abstract int getYearMin(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT min(month) FROM MyDatabase where (year=:y) and (username = :usrname)")
    public abstract int getMonthMin(int y, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT min(day) FROM MyDatabase where (year=:y and month=:m) and (username = :usrname)")
    public abstract int getDayMin(int y, int m, @org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "SELECT count(*) FROM MyDatabase where (username = :usrname)")
    public abstract int getNumTran(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Query(value = "Delete FROM MyDatabase where (username = :usrname)")
    public abstract void DeleteAll(@org.jetbrains.annotations.NotNull()
    java.lang.String usrname);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.cashbook.DataBase.MyDatabase... incomes);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.example.cashbook.DataBase.MyDatabase... incomes);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.cashbook.DataBase.MyDatabase... incomes);
}