package com.example.coinpocket.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StockDao_Impl implements StockDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CompanyListingEntity> __insertionAdapterOfCompanyListingEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearCompanyListings;

  public StockDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCompanyListingEntity = new EntityInsertionAdapter<CompanyListingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CompanyListingEntity` (`name`,`symbol`,`exchange`,`id`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CompanyListingEntity value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getSymbol() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSymbol());
        }
        if (value.getExchange() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getExchange());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
    this.__preparedStmtOfClearCompanyListings = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete From companylistingentity";
        return _query;
      }
    };
  }

  @Override
  public Object insertCompanyListings(final List<CompanyListingEntity> companyListingEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCompanyListingEntity.insert(companyListingEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object clearCompanyListings(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearCompanyListings.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfClearCompanyListings.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object searchCompanyListings(final String query,
      final Continuation<? super List<CompanyListingEntity>> continuation) {
    final String _sql = "\n"
            + "        Select *\n"
            + "        From companylistingentity \n"
            + "        where LOWER(name) LIKE '%' || LOWER(?) || '%' OR UPPER(?)== symbol\n"
            + "\n"
            + "            \n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CompanyListingEntity>>() {
      @Override
      public List<CompanyListingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "symbol");
          final int _cursorIndexOfExchange = CursorUtil.getColumnIndexOrThrow(_cursor, "exchange");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<CompanyListingEntity> _result = new ArrayList<CompanyListingEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CompanyListingEntity _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSymbol;
            if (_cursor.isNull(_cursorIndexOfSymbol)) {
              _tmpSymbol = null;
            } else {
              _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            }
            final String _tmpExchange;
            if (_cursor.isNull(_cursorIndexOfExchange)) {
              _tmpExchange = null;
            } else {
              _tmpExchange = _cursor.getString(_cursorIndexOfExchange);
            }
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item = new CompanyListingEntity(_tmpName,_tmpSymbol,_tmpExchange,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
