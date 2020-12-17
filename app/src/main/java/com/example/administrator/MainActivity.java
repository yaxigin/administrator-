package com.example.administrator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.calendar.BaseActivity;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

/**
 * 记念日
 */

public class MainActivity extends BaseActivity implements CalendarView.OnDateSelectedListener, CalendarView.OnYearChangeListener, View.OnClickListener{
    RelativeLayout bottom_bar_course_btn1,bottom_bar_exercises_btn,bottom_bar_exercises_btn1,bottom_bar_myinfo_btn;
    private TextView mTextMonthDay;
    private   TextView mTextYear;
    private TextView mTextLunar;
    private   TextView mTextCurrentDay;
    private  CalendarView mCalendarView;
    private  RelativeLayout mRelativeTool;
    private int mYear;
    private  CalendarLayout mCalendarLayout;
    private  int check=0;   //控制是否开启年视图
   //private  RelativeLayout bottom_bar_course_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        setStatusBarDarkMode();
        Window window = this.getWindow();
        //如果系统5.0以上
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xff97b4e0);
        }

        bottom_bar_course_btn1 =findViewById(R.id.bottom_bar_course_btn);
        bottom_bar_exercises_btn =findViewById(R.id.bottom_bar_exercises_btn);
        bottom_bar_exercises_btn1 =findViewById(R.id.bottom_bar_exercises_btn1);
        bottom_bar_myinfo_btn =findViewById(R.id.bottom_bar_myinfo_btn);
        bottom_bar_course_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RecommendActivity.class);
                startActivity(intent);
            }
        });

        bottom_bar_exercises_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DingdanActivity.class);
                startActivity(intent);
            }
        });
        bottom_bar_exercises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,XuzhiActivity.class);
                startActivity(intent);
            }
        });
        bottom_bar_myinfo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PersonActivity.class);
                startActivity(intent);
            }
        });
        mTextMonthDay = (TextView) findViewById(R.id.tv_month_day);
        mTextYear = (TextView) findViewById(R.id.tv_year);
        mTextLunar = (TextView) findViewById(R.id.tv_lunar);
        mRelativeTool = (RelativeLayout) findViewById(R.id.rl_tool);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mTextCurrentDay = (TextView) findViewById(R.id.tv_current_day);
//        bottom_bar_course_btn1=(RelativeLayout)findViewById(R.id.bottom_bar_course_btn);
//        bottom_bar_course_btn1.setOnClickListener(this);

        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==0){   //开启年视图
                    if (!mCalendarLayout.isExpand()) {
                        mCalendarView.showYearSelectLayout(mYear);
                        return;
                    }
                    mCalendarView.showYearSelectLayout(mYear);
                    mTextLunar.setVisibility(View.GONE);
                    mTextYear.setVisibility(View.GONE);
                    mTextMonthDay.setText(String.valueOf(mYear));
                    check=1;
                }else{
                    mCalendarView.closeYearSelectLayout(); //关闭年视图
                    check=0;
                }

            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
        });



        mCalendarLayout = (CalendarLayout) findViewById(R.id.calendarLayout);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    //可以传递数据
    @Override
    protected void initData() {
        List<Calendar> schemes = new ArrayList<>();
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();

        schemes.add(getSchemeCalendar(year, month, 3, 0xFF40db25,"假"));
        schemes.add(getSchemeCalendar(year, month, 6, 0xFFe69138,"事"));
        schemes.add(getSchemeCalendar(year, month, 9, 0xFFdf1356,"议"));
        schemes.add(getSchemeCalendar(year, month, 13, 0xFFedc56d,"记"));
        schemes.add(getSchemeCalendar(year, month, 14, 0xFFedc56d,"记"));
        schemes.add(getSchemeCalendar(year, month, 15, 0xFFaacc44,"假"));
        schemes.add(getSchemeCalendar(year, month, 18, 0xFFbc13f0,"记"));
        schemes.add(getSchemeCalendar(year, month, 25, 0xFF13acf0,"假"));
        schemes.add(getSchemeCalendar(year, month, 27, 0xFF13acf0,"多"));
        mCalendarView.setSchemeDate(schemes);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_bar_course_btn:

                break;
        }
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color,String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800,"假");
        calendar.addScheme(0xFF008800,"节");
        return calendar;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
        if (isClick) {
            Toast.makeText(this, getCalendarText(calendar), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }

    private static String getCalendarText(Calendar calendar) {
        return String.format("新历%s \n 农历%s \n 公历节日：%s \n 农历节日：%s \n 节气：%s \n 是否闰月：%s",
                calendar.getMonth() + "月" + calendar.getDay() + "日",
                calendar.getLunarCakendar().getMonth() + "月" + calendar.getLunarCakendar().getDay() + "日",
                TextUtils.isEmpty(calendar.getGregorianFestival()) ? "无" : calendar.getGregorianFestival(),
                TextUtils.isEmpty(calendar.getTraditionFestival()) ? "无" : calendar.getTraditionFestival(),
                TextUtils.isEmpty(calendar.getSolarTerm()) ? "无" : calendar.getSolarTerm(),
                calendar.getLeapMonth() == 0 ? "否" : String.format("闰%s月", calendar.getLeapMonth()));
    }



}

