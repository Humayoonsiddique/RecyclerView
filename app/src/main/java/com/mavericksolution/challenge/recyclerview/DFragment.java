package com.mavericksolution.challenge.recyclerview;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


/**
 * Created by Humayoon on 9/28/2016.
 */

public class DFragment extends DialogFragment implements
                                                         View.OnClickListener {

    private EditText                                    mFirstNameEditText,
                                                        mLastNameEditText;
    private Button                                      cancel,
                                                        ok;
    View                                                rootView;
    DFragment                                           myContext;

    /*********************************************************************************************/

    /******************************* Onclick Listeners Implementation *****************************/

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.ok:
            {
                EditNameDialogListener activity = (EditNameDialogListener) getActivity();
                String FirstName=mFirstNameEditText.getText().toString().substring(0, 1).
                        toUpperCase() + mFirstNameEditText.getText().toString().substring(1);

                String LastName=mLastNameEditText.getText().toString().substring(0, 1).
                        toUpperCase() + mLastNameEditText.getText().toString().substring(1);
                activity.onFinishEditDialog(""+LastName+","+FirstName);

                getDialog().dismiss();
                break;
            }
            case R.id.cancel:
            {

                getDialog().dismiss();

            }
        }
    }

    /*********************************************************************************************/


    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText);
    }

    /*********************************************************************************************/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialogfragment, container,
                false);

        //--------- Initialization
        init();

        ////---------- OnClick Listeners Settings
        OnClickListenerSettings();

        return rootView;
    }

    /*********************************************************************************************/

    /************************************* Initialization *****************************************/

    public void init()
    {
        myContext=this;

        mFirstNameEditText = (EditText) rootView.findViewById(R.id.first_name);
        mLastNameEditText = (EditText) rootView.findViewById(R.id.last_name);
        cancel = (Button) rootView.findViewById(R.id.cancel);
        ok = (Button) rootView.findViewById(R.id.ok);


    }

    /**********************************************************************************************/

    /****************************** On Click listeners Settings ***********************************/

     public void OnClickListenerSettings()
     {
         cancel.setOnClickListener(myContext);
         ok.setOnClickListener(myContext);
     }

    /**********************************************************************************************/

}
