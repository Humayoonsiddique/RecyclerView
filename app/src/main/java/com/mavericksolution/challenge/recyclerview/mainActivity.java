package com.mavericksolution.challenge.recyclerview;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class mainActivity extends FragmentActivity implements
                                                                DFragment.EditNameDialogListener,
                                                                View.OnClickListener {
    private RecyclerView                        recyclerView;
    private FirstLastNameAdapter                mAdapter;
    private FloatingActionButton                fab;
    List<String>                                firstAndLastNameList=new ArrayList<>();
    android.app.FragmentManager                 fm = getFragmentManager();
    private mainActivity                        myContext;

    /**********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////---------- Initialization
        init();

        ////---------- OnClick Listeners Settings
        OnClickListenerSettings();

        ////---------- General Adapter And RecyclerView Implementation
        SomeGeneralrecyclerViewAndAdapterImplementation();

        ////---------- Prepare First And Last Name in List
        prepareFirstAndLastNameData();
    }

    /************************************* Initialization *****************************************/

    public void init()
    {
        myContext=this;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);




    }

    /**********************************************************************************************/

    /******************************** OnClickListeners Settings **********************************/

    public void OnClickListenerSettings()
    {
        fab.setOnClickListener(myContext);


    }

    /**********************************************************************************************/

    /********************* Some Common Adapter And RecyclerView Implementation ********************/

    public void SomeGeneralrecyclerViewAndAdapterImplementation()
    {

        mAdapter = new FirstLastNameAdapter(firstAndLastNameList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);


    }

    /**********************************************************************************************/


    /************************ prepare First And Last Name Data in List ****************************/

    private void prepareFirstAndLastNameData() {

        firstAndLastNameList.add(getString(R.string.First_LastName1));

        firstAndLastNameList.add(getString(R.string.First_LastName2));

        firstAndLastNameList.add(getString(R.string.First_LastName3));

        firstAndLastNameList.add(getString(R.string.First_LastName4));

        firstAndLastNameList.add(getString(R.string.First_LastName5));

        firstAndLastNameList.add(getString(R.string.First_LastName6));

        firstAndLastNameList.add(getString(R.string.First_LastName7));

        firstAndLastNameList.add(getString(R.string.First_LastName8));

        mAdapter.notifyDataSetChanged();
    }


    /**********************************************************************************************/


    /**********************************************************************************
     *  onFinish Edit Dialog Call For Interface From Fragment For Recyclerview Updation
     *  *******************************************************************************/

    @Override
    public void onFinishEditDialog(String inputText) {

        //------- Specify the position
        int position = firstAndLastNameList.size();

        String itemLabel =inputText;

        //------- Add an item to animals list
        firstAndLastNameList.add(position,"" + itemLabel);


        //------- Notify the adapter that an item inserted
        mAdapter.notifyItemInserted(position);

        //------- Scroll to newly added item position
        recyclerView.scrollToPosition(position);
    }

    /**********************************************************************************************/

    /******************************* OnClick Implementations  *************************************/

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.fab:
            {
                DialogFragment alertdFragment = new DFragment();
                alertdFragment.show(fm, getString(R.string.DialogTitle));

                break;
            }
        }
    }

    /**********************************************************************************************/
}
