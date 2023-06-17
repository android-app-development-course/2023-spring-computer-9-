package com.example.cashbook.DataBase

import androidx.room.*


@Dao
interface DatabaseLists {
    @Query("SELECT * FROM MyDatabase where (username = :usrname) ORDER BY year DESC,month DESC,day DESC,id DESC")
    fun getAllAccounts(
        usrname:String
    ): List<MyDatabase?>?

    @Query("SELECT * FROM MyDatabase WHERE ((not inOut) and (username = :usrname)) ORDER BY year DESC,month DESC,day DESC,id DESC")
    fun getAllIncomes(
        usrname:String
    ): List<MyDatabase?>?

    @Query("SELECT * FROM MyDatabase where (inOut and (username = :usrname)) ORDER BY year DESC,month DESC,day DESC,id DESC")
    fun getAllExpense(
        usrname:String
    ): List<MyDatabase?>?

    @Query("SELECT * FROM MyDatabase where (:io=0 or (inOut and :io=1) or (not inOut and :io=2)) and (:type='所有类别' or :type=type) and (money>=:fn and money<=:tn) and ((year=:yy and month=:mm) or :allDt)  ORDER BY year DESC,month DESC,day DESC,id DESC")
    fun search(
        io: Int,
        type: String?,
        fn: Long,
        tn: Long,
        yy: Int,
        mm: Int,
        allDt: Boolean
    ): List<MyDatabase?>?

    @Query("SELECT * FROM MyDatabase WHERE (year=:y and month=:m and day=:d and inOut) and (username = :usrname)")
    fun getDayExpense(y: Int, m: Int, d: Int, usrname: String): List<MyDatabase?>?

    @Query("SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and not inOut) and (username = :usrname)")
    fun dayIn(y: Int, m: Int, d: Int, usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and inOut) and (username = :usrname)")
    fun dayOut(y: Int, m: Int, d: Int, usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and not inOut) and (username = :usrname)")
    fun getMonthI(y: Int, m: Int, usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and inOut) and (username = :usrname)")
    fun getMonthO(y: Int, m: Int, usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and not inOut) and (username = :usrname)")
    fun getDayI(y: Int, m: Int, d: Int, usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (year=:y and month=:m and day=:d and inOut) and (username = :usrname)")
    fun getDayO(y: Int, m: Int, d: Int, usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (not inOut) and (username = :usrname)")
    fun getAllIn(usrname: String): Long

    @Query("SELECT sum(money) FROM MyDatabase where (inOut) and (username = :usrname)")
    fun getAllOut(usrname: String): Long

    @Query("SELECT max(year) FROM MyDatabase where (username = :usrname)")
    fun getYearMax(usrname: String): Int

    @Query("SELECT max(month) FROM MyDatabase where (year=:y) and (username = :usrname)")
    fun getMonthMax(y: Int, usrname: String): Int

    @Query("SELECT max(day) FROM MyDatabase where (year=:y and month=:m) and (username = :usrname)")
    fun getDayMax(y: Int,m: Int, usrname: String): Int

    @Query("SELECT min(year) FROM MyDatabase where (username = :usrname)")
    fun getYearMin(usrname: String): Int

    @Query("SELECT min(month) FROM MyDatabase where (year=:y) and (username = :usrname)")
    fun getMonthMin(y: Int, usrname: String): Int

    @Query("SELECT min(day) FROM MyDatabase where (year=:y and month=:m) and (username = :usrname)")
    fun getDayMin(y: Int,m: Int, usrname: String): Int

    @Query("SELECT count(*) FROM MyDatabase where (username = :usrname)")
    fun getNumTran(usrname: String): Int

    @Query("Delete FROM MyDatabase where (username = :usrname)")
    fun DeleteAll(usrname: String)

    @Insert
    fun insert(vararg incomes: MyDatabase?)

    @Update
    fun update(vararg incomes: MyDatabase?)

    @Delete
    fun delete(vararg incomes: MyDatabase?)


}