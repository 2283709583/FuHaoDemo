package cn.tiptopgame.tcall.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import java.util.ArrayList;

import cn.tiptopgame.tcall.app.Adapter.FragmentAdapter;
import cn.tiptopgame.tcall.app.Adapter.NoScrollViewPager;
import cn.tiptopgame.tcall.app.Fragment.CallsFragment;
import cn.tiptopgame.tcall.app.Fragment.ContactsFragment;
import cn.tiptopgame.tcall.app.Fragment.CreditsFragment;
import cn.tiptopgame.tcall.app.Fragment.InviteFragment;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private NoScrollViewPager vp;
    private RadioGroup rg;
    private ArrayList<Fragment> fragmentlist;
    private ContactsFragment contactsFragment;
    private CallsFragment callsFragment;
    private CreditsFragment creditsFragment;
    private InviteFragment inviteFragment;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //显示fragment
        vp = (NoScrollViewPager) findViewById(R.id.vp);
        vp.setScroll(false);
        rg = (RadioGroup) findViewById(R.id.rg);
        fragmentlist=new ArrayList<>();
        contactsFragment = new ContactsFragment();
        callsFragment = new CallsFragment();
        creditsFragment = new CreditsFragment();
        inviteFragment = new InviteFragment();
        fragmentlist.add(contactsFragment);
        fragmentlist.add(callsFragment);
        fragmentlist.add(creditsFragment);
        fragmentlist.add(inviteFragment);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentlist);
        vp.setAdapter(fragmentAdapter);
        //点击事件
        vp.addOnPageChangeListener(this);
        rg.setOnCheckedChangeListener(this);
        //默认选中页面
        vp.setCurrentItem(0);
        rg.check(R.id.button01);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i){
            case 0:
                rg.check(R.id.button01);
                break;
            case 1:
                rg.check(R.id.button02);
                break;
            case 2:
                rg.check(R.id.button03);
                break;
            case 3:
                rg.check(R.id.button04);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.button01:
                vp.setCurrentItem(0);
                break;
            case R.id.button02:
                vp.setCurrentItem(1);
                break;
            case R.id.button03:
                vp.setCurrentItem(2);
                break;
            case R.id.button04:
                vp.setCurrentItem(3);
                break;
        }
    }
}
