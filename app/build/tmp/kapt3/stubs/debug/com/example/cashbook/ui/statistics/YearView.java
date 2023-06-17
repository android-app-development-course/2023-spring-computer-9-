package com.example.cashbook.ui.statistics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/cashbook/ui/statistics/YearView;", "Landroidx/fragment/app/Fragment;", "()V", "am", "Landroid/widget/TextView;", "axisX", "Llecho/lib/hellocharts/model/Axis;", "getAxisX", "()Llecho/lib/hellocharts/model/Axis;", "setAxisX", "(Llecho/lib/hellocharts/model/Axis;)V", "axisY", "getAxisY", "setAxisY", "data", "Llecho/lib/hellocharts/model/LineChartData;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "im", "lineChartView", "Llecho/lib/hellocharts/view/LineChartView;", "monthList", "", "Llecho/lib/hellocharts/model/AxisValue;", "om", "yi", "", "yo", "yy", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "update", "year", "Companion", "app_debug"})
public final class YearView extends androidx.fragment.app.Fragment {
    private lecho.lib.hellocharts.view.LineChartView lineChartView;
    private int yy = 0;
    private long yi = 0L;
    private long yo = 0L;
    private android.widget.TextView im;
    private android.widget.TextView om;
    private android.widget.TextView am;
    @org.jetbrains.annotations.NotNull()
    private lecho.lib.hellocharts.model.Axis axisX;
    @org.jetbrains.annotations.NotNull()
    private lecho.lib.hellocharts.model.Axis axisY;
    private final lecho.lib.hellocharts.model.LineChartData data = null;
    private final java.util.List<lecho.lib.hellocharts.model.AxisValue> monthList = null;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cashbook.ui.statistics.YearView.Companion Companion = null;
    private static final java.lang.String ARG_PARAM1 = "param1";
    private static final java.lang.String ARG_PARAM2 = "param2";
    public static final int COMPLETED = -1;
    
    public YearView() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final lecho.lib.hellocharts.model.Axis getAxisX() {
        return null;
    }
    
    public final void setAxisX(@org.jetbrains.annotations.NotNull()
    lecho.lib.hellocharts.model.Axis p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final lecho.lib.hellocharts.model.Axis getAxisY() {
        return null;
    }
    
    public final void setAxisY(@org.jetbrains.annotations.NotNull()
    lecho.lib.hellocharts.model.Axis p0) {
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
    
    private final void update(int year) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/cashbook/ui/statistics/YearView$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "COMPLETED", "", "newInstance", "Lcom/example/cashbook/ui/statistics/YearView;", "param1", "param2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment1.
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.cashbook.ui.statistics.YearView newInstance(@org.jetbrains.annotations.Nullable()
        java.lang.String param1, @org.jetbrains.annotations.Nullable()
        java.lang.String param2) {
            return null;
        }
    }
}