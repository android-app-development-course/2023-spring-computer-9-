package com.example.cashbook.ui.detailed_accounts;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/example/cashbook/ui/detailed_accounts/expenditure;", "Landroidx/fragment/app/Fragment;", "()V", "editMenu", "", "position", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "refreshList", "Companion", "app_debug"})
public final class expenditure extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cashbook.ui.detailed_accounts.expenditure.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static final java.lang.String ARG_PARAM1 = "param1";
    @org.jetbrains.annotations.Nullable()
    private static final java.lang.String ARG_PARAM2 = "param2";
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<com.example.cashbook.DataBase.MyDatabase> expenditureList;
    @org.jetbrains.annotations.NotNull()
    private static com.example.cashbook.AccountItemAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private static final android.os.Handler handler = null;
    
    public expenditure() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void editMenu(int position, android.view.View v) {
    }
    
    private final void refreshList() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/cashbook/ui/detailed_accounts/expenditure$Companion;", "", "()V", "ARG_PARAM1", "", "getARG_PARAM1", "()Ljava/lang/String;", "ARG_PARAM2", "getARG_PARAM2", "adapter", "Lcom/example/cashbook/AccountItemAdapter;", "getAdapter", "()Lcom/example/cashbook/AccountItemAdapter;", "setAdapter", "(Lcom/example/cashbook/AccountItemAdapter;)V", "expenditureList", "", "Lcom/example/cashbook/DataBase/MyDatabase;", "getExpenditureList", "()Ljava/util/List;", "setExpenditureList", "(Ljava/util/List;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "newInstance", "Lcom/example/cashbook/ui/detailed_accounts/expenditure;", "param1", "param2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getARG_PARAM1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getARG_PARAM2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.cashbook.DataBase.MyDatabase> getExpenditureList() {
            return null;
        }
        
        public final void setExpenditureList(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.cashbook.DataBase.MyDatabase> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.cashbook.AccountItemAdapter getAdapter() {
            return null;
        }
        
        public final void setAdapter(@org.jetbrains.annotations.NotNull()
        com.example.cashbook.AccountItemAdapter p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Handler getHandler() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.cashbook.ui.detailed_accounts.expenditure newInstance(@org.jetbrains.annotations.Nullable()
        java.lang.String param1, @org.jetbrains.annotations.Nullable()
        java.lang.String param2) {
            return null;
        }
    }
}