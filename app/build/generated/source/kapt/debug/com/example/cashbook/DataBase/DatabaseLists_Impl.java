package com.example.cashbook.DataBase;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseLists_Impl implements DatabaseLists {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MyDatabase> __insertionAdapterOfMyDatabase;

  private final EntityDeletionOrUpdateAdapter<MyDatabase> __deletionAdapterOfMyDatabase;

  private final EntityDeletionOrUpdateAdapter<MyDatabase> __updateAdapterOfMyDatabase;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DatabaseLists_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMyDatabase = new EntityInsertionAdapter<MyDatabase>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MyDatabase` (`money`,`year`,`month`,`day`,`type`,`remark`,`inOut`,`username`,`id`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyDatabase value) {
        stmt.bindLong(1, value.getMoney());
        stmt.bindLong(2, value.getYear());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getDay());
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getRemark() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRemark());
        }
        final int _tmp = value.getInOut() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getUsername() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUsername());
        }
        stmt.bindLong(9, value.getId());
      }
    };
    this.__deletionAdapterOfMyDatabase = new EntityDeletionOrUpdateAdapter<MyDatabase>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MyDatabase` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyDatabase value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfMyDatabase = new EntityDeletionOrUpdateAdapter<MyDatabase>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MyDatabase` SET `money` = ?,`year` = ?,`month` = ?,`day` = ?,`type` = ?,`remark` = ?,`inOut` = ?,`username` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyDatabase value) {
        stmt.bindLong(1, value.getMoney());
        stmt.bindLong(2, value.getYear());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getDay());
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getRemark() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRemark());
        }
        final int _tmp = value.getInOut() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getUsername() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUsername());
        }
        stmt.bindLong(9, value.getId());
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete FROM MyDatabase where (username = ?)";
        return _query;
      }
    };
  }

  @Override
  public void insert(final MyDatabase... incomes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMyDatabase.insert(incomes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MyDatabase... incomes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMyDatabase.handleMultiple(incomes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final MyDatabase... incomes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMyDatabase.handleMultiple(incomes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteAll(final String usrname) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    int _argIndex = 1;
    if (usrname == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, usrname);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<MyDatabase> getAllAccounts(final String usrname) {
    final String _sql = "SELECT * FROM MyDatabase where (username = ?) ORDER BY year DESC,month DESC,day DESC,id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inOut");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyDatabase> _result = new ArrayList<MyDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyDatabase _item;
        final long _tmpMoney;
        _tmpMoney = _cursor.getLong(_cursorIndexOfMoney);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final String _tmpRemark;
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _tmpRemark = null;
        } else {
          _tmpRemark = _cursor.getString(_cursorIndexOfRemark);
        }
        final boolean _tmpInOut;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfInOut);
        _tmpInOut = _tmp != 0;
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _item = new MyDatabase(_tmpMoney,_tmpYear,_tmpMonth,_tmpDay,_tmpType,_tmpRemark,_tmpInOut,_tmpUsername);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MyDatabase> getAllIncomes(final String usrname) {
    final String _sql = "SELECT * FROM MyDatabase WHERE ((not inOut) and (username = ?)) ORDER BY year DESC,month DESC,day DESC,id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inOut");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyDatabase> _result = new ArrayList<MyDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyDatabase _item;
        final long _tmpMoney;
        _tmpMoney = _cursor.getLong(_cursorIndexOfMoney);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final String _tmpRemark;
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _tmpRemark = null;
        } else {
          _tmpRemark = _cursor.getString(_cursorIndexOfRemark);
        }
        final boolean _tmpInOut;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfInOut);
        _tmpInOut = _tmp != 0;
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _item = new MyDatabase(_tmpMoney,_tmpYear,_tmpMonth,_tmpDay,_tmpType,_tmpRemark,_tmpInOut,_tmpUsername);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MyDatabase> getAllExpense(final String usrname) {
    final String _sql = "SELECT * FROM MyDatabase where (inOut and (username = ?)) ORDER BY year DESC,month DESC,day DESC,id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inOut");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyDatabase> _result = new ArrayList<MyDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyDatabase _item;
        final long _tmpMoney;
        _tmpMoney = _cursor.getLong(_cursorIndexOfMoney);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final String _tmpRemark;
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _tmpRemark = null;
        } else {
          _tmpRemark = _cursor.getString(_cursorIndexOfRemark);
        }
        final boolean _tmpInOut;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfInOut);
        _tmpInOut = _tmp != 0;
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _item = new MyDatabase(_tmpMoney,_tmpYear,_tmpMonth,_tmpDay,_tmpType,_tmpRemark,_tmpInOut,_tmpUsername);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MyDatabase> search(final int io, final String type, final long fn, final long tn,
      final int yy, final int mm, final boolean allDt) {
    final String _sql = "SELECT * FROM MyDatabase where (?=0 or (inOut and ?=1) or (not inOut and ?=2)) and (?='所有类别' or ?=type) and (money>=? and money<=?) and ((year=? and month=?) or ?)  ORDER BY year DESC,month DESC,day DESC,id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 10);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, io);
    _argIndex = 2;
    _statement.bindLong(_argIndex, io);
    _argIndex = 3;
    _statement.bindLong(_argIndex, io);
    _argIndex = 4;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    _argIndex = 5;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, fn);
    _argIndex = 7;
    _statement.bindLong(_argIndex, tn);
    _argIndex = 8;
    _statement.bindLong(_argIndex, yy);
    _argIndex = 9;
    _statement.bindLong(_argIndex, mm);
    _argIndex = 10;
    final int _tmp = allDt ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inOut");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyDatabase> _result = new ArrayList<MyDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyDatabase _item;
        final long _tmpMoney;
        _tmpMoney = _cursor.getLong(_cursorIndexOfMoney);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final String _tmpRemark;
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _tmpRemark = null;
        } else {
          _tmpRemark = _cursor.getString(_cursorIndexOfRemark);
        }
        final boolean _tmpInOut;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfInOut);
        _tmpInOut = _tmp_1 != 0;
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _item = new MyDatabase(_tmpMoney,_tmpYear,_tmpMonth,_tmpDay,_tmpType,_tmpRemark,_tmpInOut,_tmpUsername);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MyDatabase> getDayExpense(final int y, final int m, final int d,
      final String usrname) {
    final String _sql = "SELECT * FROM MyDatabase WHERE (year=? and month=? and day=? and inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    _statement.bindLong(_argIndex, d);
    _argIndex = 4;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfInOut = CursorUtil.getColumnIndexOrThrow(_cursor, "inOut");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyDatabase> _result = new ArrayList<MyDatabase>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyDatabase _item;
        final long _tmpMoney;
        _tmpMoney = _cursor.getLong(_cursorIndexOfMoney);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final String _tmpRemark;
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _tmpRemark = null;
        } else {
          _tmpRemark = _cursor.getString(_cursorIndexOfRemark);
        }
        final boolean _tmpInOut;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfInOut);
        _tmpInOut = _tmp != 0;
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _item = new MyDatabase(_tmpMoney,_tmpYear,_tmpMonth,_tmpDay,_tmpType,_tmpRemark,_tmpInOut,_tmpUsername);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long dayIn(final int y, final int m, final int d, final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (year=? and month=? and day=? and not inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    _statement.bindLong(_argIndex, d);
    _argIndex = 4;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long dayOut(final int y, final int m, final int d, final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (year=? and month=? and day=? and inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    _statement.bindLong(_argIndex, d);
    _argIndex = 4;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getMonthI(final int y, final int m, final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (year=? and month=? and not inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getMonthO(final int y, final int m, final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (year=? and month=? and inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getDayI(final int y, final int m, final int d, final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (year=? and month=? and day=? and not inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    _statement.bindLong(_argIndex, d);
    _argIndex = 4;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getDayO(final int y, final int m, final int d, final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (year=? and month=? and day=? and inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    _statement.bindLong(_argIndex, d);
    _argIndex = 4;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getAllIn(final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (not inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getAllOut(final String usrname) {
    final String _sql = "SELECT sum(money) FROM MyDatabase where (inOut) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getYearMax(final String usrname) {
    final String _sql = "SELECT max(year) FROM MyDatabase where (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getMonthMax(final int y, final String usrname) {
    final String _sql = "SELECT max(month) FROM MyDatabase where (year=?) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getDayMax(final int y, final int m, final String usrname) {
    final String _sql = "SELECT max(day) FROM MyDatabase where (year=? and month=?) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getYearMin(final String usrname) {
    final String _sql = "SELECT min(year) FROM MyDatabase where (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getMonthMin(final int y, final String usrname) {
    final String _sql = "SELECT min(month) FROM MyDatabase where (year=?) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getDayMin(final int y, final int m, final String usrname) {
    final String _sql = "SELECT min(day) FROM MyDatabase where (year=? and month=?) and (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, y);
    _argIndex = 2;
    _statement.bindLong(_argIndex, m);
    _argIndex = 3;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getNumTran(final String usrname) {
    final String _sql = "SELECT count(*) FROM MyDatabase where (username = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usrname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usrname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
